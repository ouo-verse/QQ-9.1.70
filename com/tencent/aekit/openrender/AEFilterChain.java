package com.tencent.aekit.openrender;

import android.util.Log;
import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.AEProfiler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AEFilterChain {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG;
    private static final String fragShader = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n";
    private static final String vertexShader = "precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main() {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}\n";
    private VideoFilterBase copyFilter;
    private List<AEChainI> filterList;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12083);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            TAG = AEFilterChain.class.getSimpleName();
        }
    }

    public AEFilterChain() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.copyFilter = new VideoFilterBase("precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main() {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}\n", "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
            this.filterList = new CopyOnWriteArrayList();
        }
    }

    private void copy(Frame frame, int i3) {
        if (this.copyFilter == null) {
            return;
        }
        Frame frame2 = new Frame();
        this.copyFilter.RenderProcess(frame.getTextureId(), frame.width, frame.height, i3, 0.0d, frame2);
        frame2.clear();
    }

    public void add(List<? extends AEChainI> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) list);
        } else {
            if (list == null) {
                return;
            }
            Iterator<? extends AEChainI> it = list.iterator();
            while (it.hasNext()) {
                this.filterList.add(it.next());
            }
        }
    }

    public void clearFilterList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            this.filterList.clear();
        }
    }

    public boolean containFilter(AEChainI aEChainI) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) aEChainI)).booleanValue();
        }
        List<AEChainI> list = this.filterList;
        if (list != null && list.contains(aEChainI)) {
            return true;
        }
        return false;
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            clearFilterList();
            this.copyFilter.clearGLSLSelf();
        }
    }

    public int indexOfFilter(AEChainI aEChainI) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) aEChainI)).intValue();
        }
        if (containFilter(aEChainI)) {
            return this.filterList.indexOf(aEChainI);
        }
        return -1;
    }

    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.copyFilter.ApplyGLSLFilter();
        }
    }

    public void process(int i3, int i16, int i17, int i18, AEChainI... aEChainIArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), aEChainIArr);
            return;
        }
        Log.i(TAG, "[process] + BEGIN, width = " + i17 + ", height = " + i18);
        Frame frame = new Frame();
        frame.setSizedTexture(i3, i17, i18);
        for (AEChainI aEChainI : aEChainIArr) {
            if (aEChainI != null && aEChainI.isApplied()) {
                Frame render = aEChainI.render(frame);
                Log.d(TAG, "[process] filter = " + aEChainI);
                if (render != frame && !frame.unlock()) {
                    frame.clear();
                }
                frame = render;
            }
        }
        copy(frame, i16);
        if (!frame.unlock()) {
            frame.clear();
        }
        Log.i(TAG, "[process] + END");
    }

    public void remove(AEChainI aEChainI) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) aEChainI);
            return;
        }
        int indexOf = this.filterList.indexOf(aEChainI);
        if (indexOf >= 0) {
            this.filterList.remove(indexOf);
        }
    }

    public void setFilterList(List<AEChainI> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
        } else {
            this.filterList = list;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return "AEFilterChain{filterList=" + this.filterList + '}';
    }

    public void add(AEChainI aEChainI) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            this.filterList.add(aEChainI);
        } else {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) aEChainI);
        }
    }

    public void remove(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else if (i3 >= 0) {
            this.filterList.remove(i3);
        }
    }

    public void add(int i3, AEChainI aEChainI) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            this.filterList.add(i3, aEChainI);
        } else {
            iPatchRedirector.redirect((short) 9, (Object) this, i3, (Object) aEChainI);
        }
    }

    public Frame process(Frame frame) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Frame) iPatchRedirector.redirect((short) 12, (Object) this, (Object) frame);
        }
        for (AEChainI aEChainI : this.filterList) {
            if (aEChainI != null && aEChainI.isApplied()) {
                Frame render = aEChainI.render(frame);
                if (render != frame && !frame.unlock()) {
                    frame.clear();
                }
                frame = render;
            }
        }
        return frame;
    }

    public void process(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        Frame frame = new Frame();
        frame.setSizedTexture(i3, i17, i18);
        if (this.filterList.isEmpty()) {
            copy(frame, i16);
            frame.clear();
            return;
        }
        for (AEChainI aEChainI : this.filterList) {
            if (aEChainI != null && aEChainI.isApplied()) {
                String str = aEChainI.getClass().getSimpleName() + "@" + aEChainI.hashCode();
                AEProfiler.getInstance().start(str, true);
                Frame render = aEChainI.render(frame);
                AEProfiler.getInstance().add(2, str, AEProfiler.getInstance().end(str, true));
                if (render != frame) {
                    Frame frame2 = frame;
                    for (Frame frame3 = frame.nextFrame; frame3 != null; frame3 = frame3.nextFrame) {
                        if (render == frame3) {
                            frame2.nextFrame = render.nextFrame;
                            render.nextFrame = null;
                        }
                        frame2 = frame3;
                    }
                    if (!frame.unlock()) {
                        frame.clear();
                    }
                }
                frame = render;
            }
        }
        copy(frame, i16);
        if (frame.unlock()) {
            return;
        }
        frame.clear();
    }
}
