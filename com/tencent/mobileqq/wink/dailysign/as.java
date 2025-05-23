package com.tencent.mobileqq.wink.dailysign;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.editor.music.vo.MusicInfoWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bC\u0010DR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\u0013\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR$\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010%\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u001d\u001a\u0004\b\u001c\u0010\u001f\"\u0004\b$\u0010!R$\u0010+\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010.\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010\u000f\u001a\u0004\b#\u0010\u0010\"\u0004\b-\u0010\u0012R$\u00104\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u00100\u001a\u0004\b\u0003\u00101\"\u0004\b2\u00103R\"\u0010:\u001a\u0002058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00106\u001a\u0004\b\u0014\u00107\"\u0004\b8\u00109R$\u0010A\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0011\u0010B\u001a\u0002058F\u00a2\u0006\u0006\u001a\u0004\b,\u00107\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/wink/dailysign/as;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "l", "(Ljava/lang/String;)V", "inputText", tl.h.F, "u", "textPagEntityName", "", "c", UserInfo.SEX_FEMALE, "()F", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(F)V", "inputTextHeight", "d", "e", "r", "originInputText", "getBackPicPath", "j", "backPicPath", "Lcom/tencent/mobileqq/wink/editor/music/vo/b;", "f", "Lcom/tencent/mobileqq/wink/editor/music/vo/b;", "getMusicInfo", "()Lcom/tencent/mobileqq/wink/editor/music/vo/b;", "o", "(Lcom/tencent/mobileqq/wink/editor/music/vo/b;)V", "musicInfo", "g", ReportConstant.COSTREPORT_PREFIX, "originMusicIdInfo", "Ljava/lang/Float;", "getMusicInfoVolume", "()Ljava/lang/Float;", "p", "(Ljava/lang/Float;)V", "musicInfoVolume", "i", "t", "originMusicInfoVolume", "Lorg/json/JSONObject;", "Lorg/json/JSONObject;", "()Lorg/json/JSONObject;", "k", "(Lorg/json/JSONObject;)V", "initTextInfo", "", "Z", "()Z", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Z)V", "needShowHint", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "getMood", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", DomainData.DOMAIN_NAME, "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)V", "mood", "isEdit", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class as {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String inputText = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String textPagEntityName = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private float inputTextHeight = 90.0f;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String originInputText = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String backPicPath;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MusicInfoWrapper musicInfo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MusicInfoWrapper originMusicIdInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Float musicInfoVolume;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float originMusicInfoVolume;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private JSONObject initTextInfo;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean needShowHint;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MetaMaterial mood;

    @Nullable
    /* renamed from: a, reason: from getter */
    public final JSONObject getInitTextInfo() {
        return this.initTextInfo;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getInputText() {
        return this.inputText;
    }

    /* renamed from: c, reason: from getter */
    public final float getInputTextHeight() {
        return this.inputTextHeight;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getNeedShowHint() {
        return this.needShowHint;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getOriginInputText() {
        return this.originInputText;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final MusicInfoWrapper getOriginMusicIdInfo() {
        return this.originMusicIdInfo;
    }

    /* renamed from: g, reason: from getter */
    public final float getOriginMusicInfoVolume() {
        return this.originMusicInfoVolume;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getTextPagEntityName() {
        return this.textPagEntityName;
    }

    public final boolean i() {
        if (Intrinsics.areEqual(this.inputText, this.originInputText) && this.backPicPath == null && Intrinsics.areEqual(this.originMusicIdInfo, this.musicInfo) && Intrinsics.areEqual(this.musicInfoVolume, this.originMusicInfoVolume) && this.mood == null) {
            return false;
        }
        return true;
    }

    public final void j(@Nullable String str) {
        this.backPicPath = str;
    }

    public final void k(@Nullable JSONObject jSONObject) {
        this.initTextInfo = jSONObject;
    }

    public final void l(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.inputText = str;
    }

    public final void m(float f16) {
        this.inputTextHeight = f16;
    }

    public final void n(@Nullable MetaMaterial metaMaterial) {
        this.mood = metaMaterial;
    }

    public final void o(@Nullable MusicInfoWrapper musicInfoWrapper) {
        this.musicInfo = musicInfoWrapper;
    }

    public final void p(@Nullable Float f16) {
        this.musicInfoVolume = f16;
    }

    public final void q(boolean z16) {
        this.needShowHint = z16;
    }

    public final void r(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.originInputText = str;
    }

    public final void s(@Nullable MusicInfoWrapper musicInfoWrapper) {
        this.originMusicIdInfo = musicInfoWrapper;
    }

    public final void t(float f16) {
        this.originMusicInfoVolume = f16;
    }

    public final void u(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.textPagEntityName = str;
    }
}
