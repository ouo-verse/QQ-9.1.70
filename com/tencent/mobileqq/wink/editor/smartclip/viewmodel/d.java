package com.tencent.mobileqq.wink.editor.smartclip.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil;
import com.tencent.mobileqq.wink.editor.music.vo.MusicInfoWrapper;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingViewModel;
import com.tencent.mobileqq.wink.editor.smartclip.algorithm.MusicInfo;
import com.tencent.mobileqq.wink.editor.smartclip.algorithm.TemplateFixedClipConfig;
import com.tencent.mobileqq.wink.editor.smartclip.o;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.render.extension.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import n73.AutoClipResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleSmartMatchMusic$MusicStuckPointInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 U2\u00020\u0001:\u0001VB\u0007\u00a2\u0006\u0004\bS\u0010TJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002JD\u0010\u0012\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0007J\u0014\u0010\u0014\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u001e\u0010\u0016\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u0007J,\u0010\u0019\u001a\u00020\u00072\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u0007J\u000e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0007J\u0006\u0010\u001c\u001a\u00020\u0007J\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000e\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0007J\u0006\u0010 \u001a\u00020\u0007J\u0006\u0010!\u001a\u00020\u0007J\u0006\u0010\"\u001a\u00020\u0007J\u0006\u0010#\u001a\u00020\u0007J\u0006\u0010$\u001a\u00020\u0007J\u0006\u0010&\u001a\u00020%R\"\u0010-\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020/0.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u001d\u00108\u001a\b\u0012\u0004\u0012\u00020/038\u0006\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R(\u0010\n\u001a\u0004\u0018\u00010\t2\b\u00109\u001a\u0004\u0018\u00010\t8\u0002@BX\u0082\u000e\u00a2\u0006\f\n\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\"\u0010E\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010(\u001a\u0004\bC\u0010*\"\u0004\bD\u0010,R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010K\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010(R\"\u0010O\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010(\u001a\u0004\bM\u0010*\"\u0004\bN\u0010,R\u001e\u0010R\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010Q\u00a8\u0006W"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/smartclip/viewmodel/d;", "Landroidx/lifecycle/ViewModel;", "", "Lcom/tencent/videocut/model/MediaClip;", "originClips", "", "l2", "", "O1", "Lcom/tencent/mobileqq/wink/editor/music/vo/b;", "musicInfo", "clips", "usingTemplate", "", "templatePath", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "templateMaterial", "isSingleClipOpen", "W1", "mediaClips", "k2", "ignoreSize", ICustomDataEditor.STRING_ARRAY_PARAM_2, "oldClips", "newClips", "M1", NodeProps.ENABLED, "i2", "Q1", "R1", "isFirst", "f2", "X1", "T1", "e2", "U1", "L1", "", "P1", "i", "Z", "d2", "()Z", "j2", "(Z)V", "isUserOpCloseSmartClip", "Landroidx/lifecycle/MutableLiveData;", "Ln73/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_smartClipResultLiveData", "Landroidx/lifecycle/LiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "S1", "()Landroidx/lifecycle/LiveData;", "smartClipResultLiveData", "value", "D", "Lcom/tencent/mobileqq/wink/editor/music/vo/b;", "g2", "(Lcom/tencent/mobileqq/wink/editor/music/vo/b;)V", "Lqqcircle/QQCircleSmartMatchMusic$MusicStuckPointInfo;", "E", "Lqqcircle/QQCircleSmartMatchMusic$MusicStuckPointInfo;", "musicStuckPointInfo", UserInfo.SEX_FEMALE, "c2", "setTemplateMode", ShortVideoConstants.PARAM_KEY_IS_TEMPLATE_MODE, "G", "Ljava/lang/String;", "H", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "I", "isOpenSmartClip", "J", "Z1", SemanticAttributes.DbSystemValues.H2, "isOpenMusicDot", "K", "Ljava/util/List;", "originMediaClips", "<init>", "()V", "L", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class d extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final LiveData<AutoClipResult> smartClipResultLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private MusicInfoWrapper musicInfo;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private QQCircleSmartMatchMusic$MusicStuckPointInfo musicStuckPointInfo;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isTemplateMode;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private String templatePath;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private MetaMaterial templateMaterial;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isOpenSmartClip;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isOpenMusicDot;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private List<? extends MediaClip> originMediaClips;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isUserOpCloseSmartClip;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<AutoClipResult> _smartClipResultLiveData;

    public d() {
        MutableLiveData<AutoClipResult> mutableLiveData = new MutableLiveData<>();
        this._smartClipResultLiveData = mutableLiveData;
        Intrinsics.checkNotNull(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<com.tencent.mobileqq.wink.editor.smartclip.model.AutoClipResult>");
        this.smartClipResultLiveData = mutableLiveData;
        this.templatePath = "";
        this.isOpenSmartClip = true;
        this.isOpenMusicDot = true;
    }

    public static /* synthetic */ boolean N1(d dVar, List list, List list2, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        return dVar.M1(list, list2, z16);
    }

    private final boolean O1() {
        QQCircleSmartMatchMusic$MusicStuckPointInfo qQCircleSmartMatchMusic$MusicStuckPointInfo;
        int i3;
        WinkEditorMusicInfo musicInfo;
        TemplateFixedClipConfig b16 = a.f321532a.b();
        if (b16 == null || !b16.getUseInternalRhythm() || (qQCircleSmartMatchMusic$MusicStuckPointInfo = this.musicStuckPointInfo) == null) {
            return true;
        }
        MusicInfoWrapper musicInfoWrapper = this.musicInfo;
        int i16 = 0;
        if (musicInfoWrapper != null) {
            i3 = musicInfoWrapper.getStartTime();
        } else {
            i3 = 0;
        }
        MusicInfoWrapper musicInfoWrapper2 = this.musicInfo;
        if (musicInfoWrapper2 != null && (musicInfo = musicInfoWrapper2.getMusicInfo()) != null) {
            i16 = musicInfo.n();
        }
        return com.tencent.mobileqq.wink.editor.smartclip.algorithm.d.INSTANCE.e(new MusicInfo(i3, i16 - i3, com.tencent.mobileqq.wink.editor.smartclip.c.p(qQCircleSmartMatchMusic$MusicStuckPointInfo)), b16);
    }

    public static /* synthetic */ boolean b2(d dVar, List list, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return dVar.a2(list, z16);
    }

    private final void g2(MusicInfoWrapper musicInfoWrapper) {
        QQCircleSmartMatchMusic$MusicStuckPointInfo qQCircleSmartMatchMusic$MusicStuckPointInfo;
        WinkEditorMusicInfo musicInfo;
        String p16;
        if (musicInfoWrapper != null && (musicInfo = musicInfoWrapper.getMusicInfo()) != null && (p16 = musicInfo.p()) != null) {
            qQCircleSmartMatchMusic$MusicStuckPointInfo = a.f321532a.d(p16);
        } else {
            qQCircleSmartMatchMusic$MusicStuckPointInfo = null;
        }
        this.musicStuckPointInfo = qQCircleSmartMatchMusic$MusicStuckPointInfo;
        this.musicInfo = musicInfoWrapper;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0068, code lost:
    
        if (r13 == null) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void l2(List<? extends MediaClip> originClips) {
        AutoClipResult autoClipResult;
        AutoClipResult autoClipResult2;
        int i3;
        WinkEditorMusicInfo musicInfo;
        List<? extends MediaClip> list;
        boolean z16;
        AutoClipResult autoClipResult3;
        List<MediaClip> m3 = e.m(originClips);
        int i16 = 0;
        if (this.isTemplateMode) {
            MusicInfoWrapper musicInfoWrapper = this.musicInfo;
            if (musicInfoWrapper != null && com.tencent.mobileqq.wink.editor.smartclip.a.a(musicInfoWrapper)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                a aVar = a.f321532a;
                MusicInfo c16 = aVar.c();
                if (c16 == null || (autoClipResult3 = com.tencent.mobileqq.wink.editor.smartclip.c.c(m3, c16, aVar.b())) == null) {
                    autoClipResult3 = new AutoClipResult(true, "", originClips);
                }
                autoClipResult2 = autoClipResult3;
                list = this.originMediaClips;
                if (list != null || (r13 = WinkEditorOpeningEndingViewModel.INSTANCE.a(list, autoClipResult2)) == null) {
                    List<MediaClip> c17 = autoClipResult2.c();
                }
                this._smartClipResultLiveData.setValue(AutoClipResult.b(autoClipResult2, false, null, c17, 3, null));
            }
        }
        QQCircleSmartMatchMusic$MusicStuckPointInfo qQCircleSmartMatchMusic$MusicStuckPointInfo = this.musicStuckPointInfo;
        if (qQCircleSmartMatchMusic$MusicStuckPointInfo != null) {
            MusicInfoWrapper musicInfoWrapper2 = this.musicInfo;
            if (musicInfoWrapper2 != null) {
                i3 = musicInfoWrapper2.getStartTime();
            } else {
                i3 = 0;
            }
            MusicInfoWrapper musicInfoWrapper3 = this.musicInfo;
            if (musicInfoWrapper3 != null && (musicInfo = musicInfoWrapper3.getMusicInfo()) != null) {
                i16 = musicInfo.n();
            }
            autoClipResult = com.tencent.mobileqq.wink.editor.smartclip.c.c(m3, new MusicInfo(i3, i16 - i3, com.tencent.mobileqq.wink.editor.smartclip.c.p(qQCircleSmartMatchMusic$MusicStuckPointInfo)), a.f321532a.b());
        }
        autoClipResult = new AutoClipResult(true, "", m3);
        autoClipResult2 = autoClipResult;
        list = this.originMediaClips;
        if (list != null) {
        }
        List<MediaClip> c172 = autoClipResult2.c();
        this._smartClipResultLiveData.setValue(AutoClipResult.b(autoClipResult2, false, null, c172, 3, null));
    }

    public final boolean L1() {
        if (T1() && U1() && O1()) {
            return true;
        }
        return false;
    }

    public final boolean M1(@NotNull List<? extends MediaClip> oldClips, @NotNull List<? extends MediaClip> newClips, boolean ignoreSize) {
        String str;
        Long l3;
        Long l16;
        Long l17;
        String str2;
        Intrinsics.checkNotNullParameter(oldClips, "oldClips");
        Intrinsics.checkNotNullParameter(newClips, "newClips");
        if (!ignoreSize && oldClips.size() != newClips.size()) {
            return false;
        }
        HashMap hashMap = new HashMap();
        Iterator<T> it = oldClips.iterator();
        while (true) {
            String str3 = "";
            if (!it.hasNext()) {
                break;
            }
            MediaClip mediaClip = (MediaClip) it.next();
            ResourceModel resourceModel = mediaClip.resource;
            if (resourceModel != null && (str2 = resourceModel.id) != null) {
                str3 = str2;
            }
            hashMap.put(str3, mediaClip);
        }
        for (MediaClip mediaClip2 : newClips) {
            ResourceModel resourceModel2 = mediaClip2.resource;
            if (resourceModel2 == null || (str = resourceModel2.id) == null) {
                str = "";
            }
            MediaClip mediaClip3 = (MediaClip) hashMap.get(str);
            if (mediaClip3 != null) {
                ResourceModel resourceModel3 = mediaClip3.resource;
                Long l18 = null;
                if (resourceModel3 != null) {
                    l3 = Long.valueOf(resourceModel3.scaleDuration);
                } else {
                    l3 = null;
                }
                ResourceModel resourceModel4 = mediaClip2.resource;
                if (resourceModel4 != null) {
                    l16 = Long.valueOf(resourceModel4.scaleDuration);
                } else {
                    l16 = null;
                }
                if (Intrinsics.areEqual(l3, l16)) {
                    ResourceModel resourceModel5 = mediaClip3.resource;
                    if (resourceModel5 != null) {
                        l17 = Long.valueOf(resourceModel5.selectDuration);
                    } else {
                        l17 = null;
                    }
                    ResourceModel resourceModel6 = mediaClip2.resource;
                    if (resourceModel6 != null) {
                        l18 = Long.valueOf(resourceModel6.selectDuration);
                    }
                    if (!Intrinsics.areEqual(l17, l18)) {
                    }
                }
                return false;
            }
        }
        return true;
    }

    public final int P1() {
        List<MediaClip> c16;
        AutoClipResult value = this._smartClipResultLiveData.getValue();
        if (value != null && (c16 = value.c()) != null) {
            return c16.size();
        }
        return 0;
    }

    /* renamed from: Q1, reason: from getter */
    public final boolean getIsOpenSmartClip() {
        return this.isOpenSmartClip;
    }

    @NotNull
    public final List<MediaClip> R1() {
        List<MediaClip> emptyList;
        List<MediaClip> c16;
        AutoClipResult value = this._smartClipResultLiveData.getValue();
        if (value == null || (c16 = value.c()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return c16;
    }

    @NotNull
    public final LiveData<AutoClipResult> S1() {
        return this.smartClipResultLiveData;
    }

    public final boolean T1() {
        if (this.musicInfo != null) {
            return true;
        }
        return false;
    }

    public final boolean U1() {
        return o.f321529a.a(this.musicInfo);
    }

    public final void W1(@Nullable MusicInfoWrapper musicInfo, @NotNull List<? extends MediaClip> clips, boolean usingTemplate, @NotNull String templatePath, @Nullable MetaMaterial templateMaterial, boolean isSingleClipOpen) {
        boolean z16;
        Intrinsics.checkNotNullParameter(clips, "clips");
        Intrinsics.checkNotNullParameter(templatePath, "templatePath");
        g2(musicInfo);
        this.templatePath = templatePath;
        this.templateMaterial = templateMaterial;
        boolean z17 = false;
        if (a.manualTurnOnSmartClip && T1() && U1() && (e.w(clips).size() > 1 || isSingleClipOpen)) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isOpenSmartClip = z16;
        this.isUserOpCloseSmartClip = a.isUserOpCloseSmartClip;
        if (T1() && U1() && (this.isOpenSmartClip || this.isUserOpCloseSmartClip)) {
            z17 = true;
        }
        this.isOpenMusicDot = z17;
        this.isTemplateMode = usingTemplate;
        ms.a.f("WinkSmartClipViewModel", "init---isOpenSmartClip=" + this.isOpenSmartClip + ", isUserOpCloseSmartClip=" + this.isUserOpCloseSmartClip + ", isOpenMusicDot=" + z17 + ", isTemplateMode=" + usingTemplate);
    }

    public final boolean X1() {
        return AECameraPrefsUtil.c().b(AECameraPrefsUtil.f318473k, true, 0);
    }

    /* renamed from: Z1, reason: from getter */
    public final boolean getIsOpenMusicDot() {
        return this.isOpenMusicDot;
    }

    public final boolean a2(@NotNull List<? extends MediaClip> clips, boolean ignoreSize) {
        List<MediaClip> emptyList;
        Intrinsics.checkNotNullParameter(clips, "clips");
        AutoClipResult value = this.smartClipResultLiveData.getValue();
        if (value == null || (emptyList = value.c()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        return M1(emptyList, clips, ignoreSize);
    }

    /* renamed from: c2, reason: from getter */
    public final boolean getIsTemplateMode() {
        return this.isTemplateMode;
    }

    /* renamed from: d2, reason: from getter */
    public final boolean getIsUserOpCloseSmartClip() {
        return this.isUserOpCloseSmartClip;
    }

    public final boolean e2() {
        MusicInfoWrapper musicInfoWrapper = this.musicInfo;
        if (musicInfoWrapper != null) {
            return com.tencent.mobileqq.wink.editor.smartclip.a.a(musicInfoWrapper);
        }
        return false;
    }

    public final void f2(boolean isFirst) {
        AECameraPrefsUtil.c().h(AECameraPrefsUtil.f318473k, isFirst, 0);
    }

    public final void h2(boolean z16) {
        this.isOpenMusicDot = z16;
    }

    public final void i2(boolean enabled) {
        this.isOpenSmartClip = enabled;
    }

    public final void j2(boolean z16) {
        this.isUserOpCloseSmartClip = z16;
    }

    public final void k2(@NotNull List<? extends MediaClip> mediaClips) {
        Intrinsics.checkNotNullParameter(mediaClips, "mediaClips");
        ms.a.f("WinkSmartClipViewModel", "triggerSmartClip");
        this.originMediaClips = mediaClips;
        List<MediaClip> w3 = e.w(mediaClips);
        if (b2(this, mediaClips, false, 2, null) && !N1(this, mediaClips, e.m(mediaClips), false, 4, null)) {
            AutoClipResult autoClipResult = new AutoClipResult(true, "", w3);
            this._smartClipResultLiveData.setValue(AutoClipResult.b(autoClipResult, false, null, WinkEditorOpeningEndingViewModel.INSTANCE.a(mediaClips, autoClipResult), 3, null));
            return;
        }
        l2(w3);
    }
}
