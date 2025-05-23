package com.tencent.mobileqq.shortvideo.panoramicvideo;

import android.opengl.GLES20;
import com.tencent.mobileqq.shortvideo.panoramicvideo.GL.FBO;
import com.tencent.mobileqq.shortvideo.panoramicvideo.utils.PanoramicLogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class GroupRenderObj extends BaseRenderObj {
    private static final String TAG = "GroupRenderObj";
    private FBO[] fboList;
    private boolean isRunning;
    protected List<BaseRenderObj> renderObjLists = new ArrayList();

    private void destroyFrameBuffers() {
        for (FBO fbo : this.fboList) {
            fbo.destroy();
        }
    }

    public void addFilter(final BaseRenderObj baseRenderObj) {
        if (baseRenderObj == null) {
            return;
        }
        if (!this.isRunning) {
            this.renderObjLists.add(baseRenderObj);
        } else {
            addPreDrawTask(new Runnable() { // from class: com.tencent.mobileqq.shortvideo.panoramicvideo.GroupRenderObj.1
                @Override // java.lang.Runnable
                public void run() {
                    baseRenderObj.init();
                    GroupRenderObj.this.renderObjLists.add(baseRenderObj);
                    GroupRenderObj groupRenderObj = GroupRenderObj.this;
                    groupRenderObj.onRenderObjChanged(groupRenderObj.surfaceWidth, groupRenderObj.surfaceHeight);
                }
            });
        }
    }

    public void addFilterList(final List<BaseRenderObj> list) {
        if (list == null) {
            return;
        }
        if (!this.isRunning) {
            Iterator<BaseRenderObj> it = list.iterator();
            while (it.hasNext()) {
                this.renderObjLists.add(it.next());
            }
            return;
        }
        addPreDrawTask(new Runnable() { // from class: com.tencent.mobileqq.shortvideo.panoramicvideo.GroupRenderObj.2
            @Override // java.lang.Runnable
            public void run() {
                for (BaseRenderObj baseRenderObj : list) {
                    baseRenderObj.init();
                    GroupRenderObj.this.renderObjLists.add(baseRenderObj);
                }
                GroupRenderObj groupRenderObj = GroupRenderObj.this;
                groupRenderObj.onRenderObjChanged(groupRenderObj.surfaceWidth, groupRenderObj.surfaceHeight);
            }
        });
    }

    @Override // com.tencent.mobileqq.shortvideo.panoramicvideo.BaseRenderObj
    public void destroy() {
        destroyFrameBuffers();
        Iterator<BaseRenderObj> it = this.renderObjLists.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
        this.isRunning = false;
    }

    public void drawToFBO(int i3, FBO fbo) {
        runPreDrawTasks();
        if (this.fboList != null && fbo != null) {
            int size = this.renderObjLists.size();
            for (int i16 = 0; i16 < size; i16++) {
                BaseRenderObj baseRenderObj = this.renderObjLists.get(i16);
                PanoramicLogUtil.Log("onDrawFrame: " + i16 + " / " + size + " " + baseRenderObj.getClass().getSimpleName() + " |previousTexture=" + i3);
                if (i16 < size - 1) {
                    baseRenderObj.setViewport();
                    this.fboList[i16].bind();
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                    if (baseRenderObj instanceof GroupRenderObj) {
                        ((GroupRenderObj) baseRenderObj).drawToFBO(i3, this.fboList[i16]);
                    } else {
                        baseRenderObj.onDrawFrame(i3);
                    }
                    this.fboList[i16].unbind();
                    i3 = this.fboList[i16].getFrameBufferTextureId();
                } else {
                    fbo.bind();
                    baseRenderObj.setViewport();
                    if (baseRenderObj instanceof GroupRenderObj) {
                        ((GroupRenderObj) baseRenderObj).drawToFBO(i3, fbo);
                    } else {
                        baseRenderObj.onDrawFrame(i3);
                    }
                    fbo.unbind();
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.panoramicvideo.BaseRenderObj
    public void init() {
        Iterator<BaseRenderObj> it = this.renderObjLists.iterator();
        while (it.hasNext()) {
            it.next().init();
        }
        this.isRunning = true;
    }

    @Override // com.tencent.mobileqq.shortvideo.panoramicvideo.BaseRenderObj
    public void onDrawFrame(int i3) {
        throw new RuntimeException("Illegal call");
    }

    @Override // com.tencent.mobileqq.shortvideo.panoramicvideo.BaseRenderObj
    public void onRenderObjChanged(int i3, int i16) {
        super.onRenderObjChanged(i3, i16);
        int size = this.renderObjLists.size();
        for (int i17 = 0; i17 < size; i17++) {
            this.renderObjLists.get(i17).onRenderObjChanged(i3, i16);
        }
        if (this.fboList != null) {
            destroyFrameBuffers();
            this.fboList = null;
        }
        if (this.fboList == null) {
            int i18 = size - 1;
            this.fboList = new FBO[i18];
            for (int i19 = 0; i19 < i18; i19++) {
                this.fboList[i19] = this.renderObjLists.get(i19).createFBO();
            }
        }
    }

    public void switchFilterAt(final BaseRenderObj baseRenderObj, final int i3) {
        if (baseRenderObj != null && i3 < this.renderObjLists.size()) {
            addPreDrawTask(new Runnable() { // from class: com.tencent.mobileqq.shortvideo.panoramicvideo.GroupRenderObj.4
                @Override // java.lang.Runnable
                public void run() {
                    baseRenderObj.init();
                    ArrayList arrayList = new ArrayList();
                    for (int i16 = 0; i16 < GroupRenderObj.this.renderObjLists.size(); i16++) {
                        BaseRenderObj baseRenderObj2 = GroupRenderObj.this.renderObjLists.get(i16);
                        if (i16 == i3) {
                            arrayList.add(baseRenderObj);
                            baseRenderObj2.destroy();
                        } else {
                            arrayList.add(baseRenderObj2);
                        }
                    }
                    GroupRenderObj.this.renderObjLists.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        GroupRenderObj.this.renderObjLists.add((BaseRenderObj) it.next());
                    }
                    GroupRenderObj groupRenderObj = GroupRenderObj.this;
                    groupRenderObj.onRenderObjChanged(groupRenderObj.surfaceWidth, groupRenderObj.surfaceHeight);
                }
            });
        }
    }

    public void switchLastFilter(final BaseRenderObj baseRenderObj) {
        if (baseRenderObj == null) {
            return;
        }
        if (!this.isRunning) {
            if (this.renderObjLists.size() > 0) {
                this.renderObjLists.remove(r0.size() - 1).destroy();
            }
            this.renderObjLists.add(baseRenderObj);
            return;
        }
        addPreDrawTask(new Runnable() { // from class: com.tencent.mobileqq.shortvideo.panoramicvideo.GroupRenderObj.3
            @Override // java.lang.Runnable
            public void run() {
                if (GroupRenderObj.this.renderObjLists.size() > 0) {
                    GroupRenderObj.this.renderObjLists.remove(r0.size() - 1).destroy();
                }
                baseRenderObj.init();
                GroupRenderObj.this.renderObjLists.add(baseRenderObj);
                GroupRenderObj groupRenderObj = GroupRenderObj.this;
                groupRenderObj.onRenderObjChanged(groupRenderObj.surfaceWidth, groupRenderObj.surfaceHeight);
            }
        });
    }
}
