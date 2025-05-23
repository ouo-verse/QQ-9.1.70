package com.tencent.mobileqq.wink.pubcover;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.Pair;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.editor.export.WinkExportUtils;
import com.tencent.mobileqq.wink.editor.model.WinkTavCutScene;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.wink.pubcover.WinkCoverSelectFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.cover.ICoverProvider;
import com.tencent.tavcut.core.render.rendernode.BaseEffectNode;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.ttpic.openapi.filter.SimpleGLThread;
import com.tencent.videocut.model.BackgroundFillMode;
import com.tencent.videocut.model.BackgroundModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.SizeF;
import com.tencent.videocut.picker.MediaData;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import okio.ByteString;
import org.light.lightAssetKit.components.Size;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkCoverSelectViewModel extends BaseViewModel {
    private ICoverProvider D;
    private String E;
    private SimpleGLThread G;
    private String H;
    private LocalMediaInfo I;
    private LAKRenderModel J;

    /* renamed from: i, reason: collision with root package name */
    private WinkEditDataWrapper f325521i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f325522m = false;
    private Bitmap C = null;
    private final MutableLiveData<t73.a<Long>> F = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class a implements WinkExportUtils.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Size f325526a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WinkEditData f325527b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f325528c;

        a(Size size, WinkEditData winkEditData, b bVar) {
            this.f325526a = size;
            this.f325527b = winkEditData;
            this.f325528c = bVar;
        }

        @Override // com.tencent.mobileqq.wink.editor.export.WinkExportUtils.b
        public void a(ICutSession iCutSession, LAKRenderModel lAKRenderModel) {
            WinkCoverSelectViewModel.this.J = lAKRenderModel;
            if (iCutSession != null) {
                iCutSession.release();
            }
            WinkCoverSelectViewModel.this.i2(lAKRenderModel, this.f325526a, this.f325527b, this.f325528c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface b {
        void a(LAKRenderModel lAKRenderModel, String str, List<BaseEffectNode> list, long j3, List<MediaClip> list2);
    }

    private void R1(WinkEditData winkEditData) {
        winkEditData.setStretchData(null);
        winkEditData.setStickerExtraMap(null);
        winkEditData.setAssetData(null);
        winkEditData.setStickerModelMap(null);
    }

    private WinkEditDataWrapper S1(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                LocalMediaInfo d16 = WinkExportUtils.d(str);
                ArrayList arrayList = new ArrayList();
                arrayList.add(d16);
                return com.tencent.mobileqq.wink.editor.draft.c.d(arrayList, 0, 0);
            } catch (Exception e16) {
                QLog.d("WinkCoverSelectViewModel", 1, e16, new Object[0]);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] T1(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            if (!bitmap.isRecycled()) {
                bitmap.recycle();
            }
        } catch (Exception e16) {
            w53.b.a("WinkCoverSelectViewModel", "cbitmap.recycle() " + e16.toString());
        }
        return byteArray;
    }

    private String Z1(Activity activity) {
        if (activity != null && activity.getIntent() != null && activity.getIntent().getExtras() != null) {
            return activity.getIntent().getExtras().getString(AEEditorConstants.KEY_VIDEO_MEDIA_PATH);
        }
        return "";
    }

    private boolean g2(WinkEditDataWrapper winkEditDataWrapper) {
        if (winkEditDataWrapper == null || winkEditDataWrapper.getEditDatas() == null || winkEditDataWrapper.getEditDatas().size() <= 0 || winkEditDataWrapper.getEditDatas().get(0) == null || winkEditDataWrapper.getEditDatas().get(0).getRenderModelStr() == null) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i2(LAKRenderModel lAKRenderModel, Size size, WinkEditData winkEditData, b bVar) {
        if (lAKRenderModel != null) {
            try {
                String r16 = com.tencent.mobileqq.wink.editor.draft.c.r(e2());
                w53.b.f("WinkCoverSelectViewModel", "initProviderInner.");
                this.D = rd4.c.f431135f.d(lAKRenderModel, size, r16, com.tencent.mobileqq.wink.editor.export.u.T1(winkEditData), null);
                if (winkEditData != null) {
                    List<MediaClip> list = winkEditData.getMediaModel().videos;
                    if (bVar != null) {
                        bVar.a(lAKRenderModel, r16, com.tencent.mobileqq.wink.editor.export.u.T1(winkEditData), winkEditData.getDurationUs(), list);
                        return;
                    }
                    return;
                }
                return;
            } catch (Exception e16) {
                w53.b.d("WinkCoverSelectViewModel", "startExport ERROR", e16);
                return;
            }
        }
        w53.b.c("WinkCoverSelectViewModel", "getVideoCover renderModel == null");
    }

    public List<BaseEffectNode> Q1(WinkEditDataWrapper winkEditDataWrapper) {
        if (winkEditDataWrapper != null && winkEditDataWrapper.getEditDatas() != null && winkEditDataWrapper.getEditDatas().size() != 0) {
            return com.tencent.mobileqq.wink.editor.export.u.T1(winkEditDataWrapper.getEditDatas().get(0));
        }
        return null;
    }

    public Bitmap U1(final Long l3) {
        SimpleGLThread simpleGLThread = this.G;
        if (simpleGLThread != null) {
            simpleGLThread.postJobSync(new Runnable() { // from class: com.tencent.mobileqq.wink.pubcover.WinkCoverSelectViewModel.3
                @Override // java.lang.Runnable
                public void run() {
                    if (WinkCoverSelectViewModel.this.D != null) {
                        WinkCoverSelectViewModel winkCoverSelectViewModel = WinkCoverSelectViewModel.this;
                        winkCoverSelectViewModel.C = winkCoverSelectViewModel.D.getCoverAtTime(Math.max(0L, l3.longValue()));
                    }
                }
            });
        }
        return this.C;
    }

    public dr.WinkTavCutParams W1(int i3, int i16, boolean z16) {
        WinkEditDataWrapper b16;
        int i17;
        int i18;
        ArrayList arrayList;
        BackgroundFillMode backgroundFillMode;
        if (e2() == null) {
            return null;
        }
        String str = this.H;
        if (str != null) {
            b16 = S1(str);
        } else {
            b16 = com.tencent.mobileqq.wink.editor.draft.a.b(e2().getMissionId());
        }
        if (b16 == null) {
            return null;
        }
        ArrayList editDatas = b16.getEditDatas();
        int i19 = i3 * 4;
        int i26 = i16 * 3;
        if (i19 > i26) {
            i18 = i16;
            i17 = i26 / 4;
        } else {
            i17 = i3;
            i18 = i19 / 3;
        }
        boolean z17 = false;
        if (editDatas != null && editDatas.size() > 0 && editDatas.get(0) != null) {
            WinkEditData winkEditData = editDatas.get(0);
            winkEditData.setFilterModelMap(new LinkedHashMap<>());
            w wVar = w.f325612a;
            if (wVar.b().getCurrentTabType() == 1 && wVar.b().getAlbumDraft().d() != null && wVar.b().getAlbumDraft().d().size() > 0) {
                String str2 = wVar.b().getAlbumDraft().d().get(0).path;
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str2, options);
                winkEditData = com.tencent.mobileqq.wink.editor.draft.c.b(winkEditData, com.tencent.mobileqq.wink.editor.model.a.f(winkEditData.getMediaModel(), options.outWidth, options.outHeight, winkEditData.getDurationUs(), str2), winkEditData.getDurationUs());
            } else if (k2()) {
                WinkEditData X1 = X1();
                if (X1 != null) {
                    X1.setMediaModel(com.tencent.mobileqq.wink.editor.model.a.j(X1.getMediaModel(), winkEditData.getMediaModel().backgroundModel));
                    winkEditData = X1;
                }
            } else {
                if (this.I != null && !z16) {
                    String str3 = d2().thumbnailPath;
                    BitmapFactory.Options options2 = new BitmapFactory.Options();
                    options2.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(str3, options2);
                    winkEditData = com.tencent.mobileqq.wink.editor.draft.c.b(winkEditData, com.tencent.mobileqq.wink.editor.model.a.f(winkEditData.getMediaModel(), options2.outWidth, options2.outHeight, winkEditData.getDurationUs(), str3), winkEditData.getDurationUs());
                } else {
                    winkEditData = com.tencent.mobileqq.wink.editor.draft.c.b(winkEditData, com.tencent.mobileqq.wink.editor.model.a.i(winkEditData.getMediaModel()), winkEditData.getDurationUs());
                }
                R1(winkEditData);
            }
            int lastCoverBgSelectPostion = wVar.b().getLastCoverBgSelectPostion();
            String lastCoverBgSelectColor = wVar.b().getLastCoverBgSelectColor();
            BackgroundFillMode.Companion companion = BackgroundFillMode.INSTANCE;
            if (lastCoverBgSelectPostion == 0) {
                backgroundFillMode = BackgroundFillMode.PAG;
            } else {
                backgroundFillMode = BackgroundFillMode.SOLID_COLOR;
            }
            MediaModel k3 = com.tencent.mobileqq.wink.editor.model.a.k(com.tencent.mobileqq.wink.editor.model.a.h(winkEditData.getMediaModel(), 3, 4, Float.valueOf(0.5625f), backgroundFillMode, lastCoverBgSelectColor, WinkExportUtils.t()), 0.0f);
            if (wVar.b().h() != null) {
                HashMap hashMap = new HashMap();
                Iterator<WinkStickerModel> it = wVar.b().h().iterator();
                while (it.hasNext()) {
                    WinkStickerModel next = it.next();
                    hashMap.put(next.id, next);
                }
                winkEditData.setStickerModelMap(hashMap);
                k3 = com.tencent.mobileqq.wink.editor.model.a.a(k3, w.f325612a.b().h());
            }
            winkEditData.setMediaModel(k3);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(winkEditData);
            arrayList = arrayList2;
        } else {
            arrayList = editDatas;
        }
        String v3 = WinkExportUtils.v();
        w wVar2 = w.f325612a;
        if (wVar2.b().getTemplateMetaMaterial() != null) {
            v3 = WinkEditorResourceManager.a1().i2(wVar2.b().getTemplateMetaMaterial());
        }
        String str4 = v3;
        WinkEditorViewModel.EditMode editMode = WinkEditorViewModel.EditMode.Video;
        Boolean bool = Boolean.FALSE;
        Boolean bool2 = u53.i.f438428a;
        if (bool2 != null) {
            z17 = bool2.booleanValue();
        }
        return new dr.WinkTavCutParams(false, editMode, arrayList, str4, bool, i17, i18, null, null, z17, u53.i.f438429b.intValue(), Long.MAX_VALUE, true, false, null, WinkTavCutScene.Cover, false, true, 0, 0, true, null);
    }

    public WinkEditData X1() {
        if (!k2()) {
            return null;
        }
        LocalMediaInfo d16 = WinkExportUtils.d(b2());
        if (d16 == null) {
            ms.a.c("WinkCoverSelectViewModel", "getExportWinkEditData localMediaInfo is null");
            return null;
        }
        MediaData e16 = e93.i.e(d16);
        ArrayList arrayList = new ArrayList();
        arrayList.add(e16);
        return WinkVideoTavCut.INSTANCE.d(arrayList, d16.mDuration * 1000);
    }

    public LAKRenderModel a2() {
        return this.J;
    }

    public String b2() {
        LocalMediaInfo x16 = WinkExportUtils.x(this.E);
        if (x16 != null) {
            return x16.path;
        }
        return null;
    }

    public LiveData<t73.a<Long>> c2() {
        return this.F;
    }

    public LocalMediaInfo d2() {
        return this.I;
    }

    public WinkEditDataWrapper e2() {
        return this.f325521i;
    }

    public void f2(final LocalMediaInfo localMediaInfo, final WinkCoverSelectFragment.m mVar) {
        if (localMediaInfo != null) {
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.pubcover.WinkCoverSelectViewModel.4
                @Override // java.lang.Runnable
                public void run() {
                    float floatValue;
                    int width;
                    try {
                        Bitmap decodeFile = BitmapFactory.decodeFile(localMediaInfo.path);
                        if (decodeFile.getHeight() > 1280 || decodeFile.getWidth() > 1280) {
                            Matrix matrix = new Matrix();
                            if (decodeFile.getHeight() > decodeFile.getWidth()) {
                                floatValue = Float.valueOf(1280.0f).floatValue();
                                width = decodeFile.getHeight();
                            } else {
                                floatValue = Float.valueOf(1280.0f).floatValue();
                                width = decodeFile.getWidth();
                            }
                            float f16 = floatValue / width;
                            matrix.postScale(f16, f16);
                            decodeFile = Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true);
                        }
                        mVar.a(com.tencent.videocut.render.extension.e.s(decodeFile.getWidth(), decodeFile.getHeight(), 2500000L, "id_2500000", WinkCoverSelectViewModel.this.T1(decodeFile), 0.0f, null));
                    } catch (Throwable th5) {
                        w53.b.a("WinkCoverSelectViewModel", "handleSelectCoverFromAlbum " + th5.toString());
                        LocalMediaInfo localMediaInfo2 = localMediaInfo;
                        String str = localMediaInfo2.mMimeType;
                        int i3 = localMediaInfo2.mediaWidth;
                        int i16 = localMediaInfo2.mediaHeight;
                        String str2 = localMediaInfo2.path;
                        MediaData mediaData = new MediaData(1, str, i3, i16, 0L, 0L, 2500000L, str2, str2, localMediaInfo2.mAlbumName);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(mediaData);
                        mVar.a(com.tencent.videocut.render.repository.a.f384196a.d(arrayList, 0.0f));
                    }
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkCoverSelectViewModel";
    }

    public void h2(b bVar) {
        SizeF sizeF;
        if (this.G == null && this.D == null && e2() != null && e2().getEditDatas().size() > 0) {
            this.G = new SimpleGLThread(null, "coverEdit");
            WinkEditData winkEditData = e2().getEditDatas().get(0);
            if (winkEditData.getMediaModel().backgroundModel != null) {
                sizeF = winkEditData.getMediaModel().backgroundModel.renderSize;
            } else {
                sizeF = new SizeF(0.0f, 0.0f, ByteString.EMPTY);
            }
            Size size = new Size((int) sizeF.width, (int) sizeF.height);
            if (g2(e2())) {
                ms.a.f("WinkCoverSelectViewModel", "use renderModel export video.");
                LAKRenderModel q16 = com.tencent.mobileqq.wink.editor.draft.c.q(winkEditData);
                this.J = q16;
                i2(q16, size, winkEditData, bVar);
                return;
            }
            ms.a.f("WinkCoverSelectViewModel", "use mediaModel export video.");
            WinkExportUtils.u(e2(), new a(size, winkEditData, bVar));
        }
    }

    public void j2(String str, Activity activity) {
        boolean z16;
        this.f325521i = com.tencent.mobileqq.wink.editor.draft.a.b(str);
        this.E = str;
        if (WinkExportUtils.x(str) != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f325522m = z16;
        WinkEditDataWrapper winkEditDataWrapper = this.f325521i;
        if (winkEditDataWrapper != null) {
            ArrayList<WinkEditData> editDatas = winkEditDataWrapper.getEditDatas();
            if (editDatas != null && editDatas.size() == 1 && editDatas.get(0) != null) {
                MediaModel e16 = com.tencent.mobileqq.wink.editor.model.a.e(editDatas.get(0).getMediaModel(), Collections.emptyMap());
                Pair<Integer, Integer> u16 = com.tencent.mobileqq.wink.editor.draft.c.u(e2());
                SizeF sizeF = new SizeF(((Integer) u16.first).intValue(), ((Integer) u16.second).intValue(), ByteString.EMPTY);
                BackgroundModel backgroundModel = e16.backgroundModel;
                if (backgroundModel != null) {
                    e16 = com.tencent.mobileqq.wink.editor.model.a.g(e16, com.tencent.mobileqq.wink.editor.model.a.l(backgroundModel, sizeF, "#FF000000"));
                }
                editDatas.get(0).setMediaModel(e16);
            }
            long preferredCoverTime = this.f325521i.getPreferredCoverTime();
            if (preferredCoverTime != 0 && preferredCoverTime <= e2().getDuration()) {
                this.F.postValue(new t73.a<>(Long.valueOf(preferredCoverTime)));
                return;
            }
            return;
        }
        String Z1 = Z1(activity);
        this.H = Z1;
        this.f325521i = S1(Z1);
    }

    public boolean k2() {
        return this.f325522m;
    }

    public void l2() {
        SimpleGLThread simpleGLThread = this.G;
        if (simpleGLThread == null) {
            return;
        }
        simpleGLThread.postJob(new Runnable() { // from class: com.tencent.mobileqq.wink.pubcover.WinkCoverSelectViewModel.1
            @Override // java.lang.Runnable
            public void run() {
                if (WinkCoverSelectViewModel.this.D != null) {
                    WinkCoverSelectViewModel.this.D.release();
                }
            }
        });
        this.G.destroy();
    }

    public void m2(LocalMediaInfo localMediaInfo) {
        this.I = localMediaInfo;
    }
}
