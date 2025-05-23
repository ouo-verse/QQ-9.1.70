package com.tencent.mobileqq.zplan.easteregg;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b!\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b[\u0010\\R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R6\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010&\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u0014\u001a\u0004\b$\u0010\u0016\"\u0004\b%\u0010\u0018R$\u0010*\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR$\u0010.\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\u0004\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR\"\u00105\u001a\u00020/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00107\u001a\u00020/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00100\u001a\u0004\b+\u00102\"\u0004\b6\u00104R\"\u00109\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b8\u0010\bR$\u0010;\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b:\u0010\bR\"\u0010B\u001a\u00020<8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010D\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0014\u001a\u0004\bC\u0010\u0016\"\u0004\b\u0014\u0010\u0018R\"\u0010F\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010\u0014\u001a\u0004\bE\u0010\u0016\"\u0004\b\f\u0010\u0018R$\u0010K\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010G\u001a\u0004\b\u000b\u0010H\"\u0004\bI\u0010JR$\u0010N\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010G\u001a\u0004\b\u0013\u0010H\"\u0004\bM\u0010JR\"\u0010Q\u001a\u00020<8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010=\u001a\u0004\bL\u0010?\"\u0004\bP\u0010AR\"\u0010S\u001a\u00020<8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010=\u001a\u0004\bO\u0010?\"\u0004\bR\u0010AR\"\u0010U\u001a\u00020<8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010=\u001a\u0004\b#\u0010?\"\u0004\bT\u0010AR\"\u0010X\u001a\u00020<8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010=\u001a\u0004\bV\u0010?\"\u0004\bW\u0010AR\"\u0010Z\u001a\u00020<8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010=\u001a\u0004\b'\u0010?\"\u0004\bY\u0010A\u00a8\u0006]"}, d2 = {"Lcom/tencent/mobileqq/zplan/easteregg/a;", "", "", "a", "Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/lang/String;", "H", "(Ljava/lang/String;)V", "portraitName", "", "b", "J", ReportConstant.COSTREPORT_PREFIX, "()J", "N", "(J)V", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "", "c", "I", "k", "()I", "E", "(I)V", QQBrowserActivity.KEY_MSG_TYPE, "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "d", "Ljava/util/HashSet;", "r", "()Ljava/util/HashSet;", "M", "(Ljava/util/HashSet;)V", "textKeywords", "e", "l", "G", "portraitID", "f", "j", "D", "maleUrl", "g", tl.h.F, "B", "femaleUrl", "Lcom/tencent/mobileqq/zplan/easteregg/a$a;", "Lcom/tencent/mobileqq/zplan/easteregg/a$a;", "i", "()Lcom/tencent/mobileqq/zplan/easteregg/a$a;", "setMalePagResourcePath", "(Lcom/tencent/mobileqq/zplan/easteregg/a$a;)V", "malePagResourcePath", "setFemalePagResourcePath", "femalePagResourcePath", "y", "backgroundUrl", "v", "appearanceKey", "", "Z", "t", "()Z", BdhLogUtil.LogTag.Tag_Conn, "(Z)V", "isMale", DomainData.DOMAIN_NAME, "priority", "o", "repeatCount", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "w", "(Ljava/lang/Integer;)V", "avatarBackgroundLayer", "p", HippyTKDListViewAdapter.X, "avatarCharacterLayer", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "K", "shouldReverseForAvatar", "L", "shouldReverseForEffect", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "enablePrerecord", "u", UserInfo.SEX_FEMALE, "isOutBoundAvatar", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "enableReport", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long timeStamp;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int msgType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private HashSet<String> textKeywords;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String maleUrl;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String femaleUrl;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String appearanceKey;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int priority;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer avatarBackgroundLayer;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer avatarCharacterLayer;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private boolean shouldReverseForAvatar;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private boolean shouldReverseForEffect;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private boolean enablePrerecord;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private boolean isOutBoundAvatar;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private boolean enableReport;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String portraitName = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int portraitID = -1;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private C9169a malePagResourcePath = new C9169a();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private C9169a femalePagResourcePath = new C9169a();

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String backgroundUrl = "";

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean isMale = true;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private int repeatCount = 1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\n\u0010\bR$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0013\u0010\bR$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\b\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/zplan/easteregg/a$a;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", tl.h.F, "(Ljava/lang/String;)V", "avatarPath", "g", "atmospherePath", "c", "i", "fullScreenPath", "d", "e", "k", "reverseAvatarPath", "j", "reverseAtmospherePath", "f", "l", "reverseFullScreenPath", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.easteregg.a$a, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static final class C9169a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String avatarPath;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String atmospherePath;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String fullScreenPath;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String reverseAvatarPath;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String reverseAtmospherePath;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String reverseFullScreenPath;

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getAtmospherePath() {
            return this.atmospherePath;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getAvatarPath() {
            return this.avatarPath;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final String getFullScreenPath() {
            return this.fullScreenPath;
        }

        @Nullable
        /* renamed from: d, reason: from getter */
        public final String getReverseAtmospherePath() {
            return this.reverseAtmospherePath;
        }

        @Nullable
        /* renamed from: e, reason: from getter */
        public final String getReverseAvatarPath() {
            return this.reverseAvatarPath;
        }

        @Nullable
        /* renamed from: f, reason: from getter */
        public final String getReverseFullScreenPath() {
            return this.reverseFullScreenPath;
        }

        public final void g(@Nullable String str) {
            this.atmospherePath = str;
        }

        public final void h(@Nullable String str) {
            this.avatarPath = str;
        }

        public final void i(@Nullable String str) {
            this.fullScreenPath = str;
        }

        public final void j(@Nullable String str) {
            this.reverseAtmospherePath = str;
        }

        public final void k(@Nullable String str) {
            this.reverseAvatarPath = str;
        }

        public final void l(@Nullable String str) {
            this.reverseFullScreenPath = str;
        }
    }

    public final void A(boolean z16) {
        this.enableReport = z16;
    }

    public final void B(@Nullable String str) {
        this.femaleUrl = str;
    }

    public final void C(boolean z16) {
        this.isMale = z16;
    }

    public final void D(@Nullable String str) {
        this.maleUrl = str;
    }

    public final void E(int i3) {
        this.msgType = i3;
    }

    public final void F(boolean z16) {
        this.isOutBoundAvatar = z16;
    }

    public final void G(int i3) {
        this.portraitID = i3;
    }

    public final void H(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.portraitName = str;
    }

    public final void I(int i3) {
        this.priority = i3;
    }

    public final void J(int i3) {
        this.repeatCount = i3;
    }

    public final void K(boolean z16) {
        this.shouldReverseForAvatar = z16;
    }

    public final void L(boolean z16) {
        this.shouldReverseForEffect = z16;
    }

    public final void M(@Nullable HashSet<String> hashSet) {
        this.textKeywords = hashSet;
    }

    public final void N(long j3) {
        this.timeStamp = j3;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getAppearanceKey() {
        return this.appearanceKey;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final Integer getAvatarBackgroundLayer() {
        return this.avatarBackgroundLayer;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final Integer getAvatarCharacterLayer() {
        return this.avatarCharacterLayer;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getBackgroundUrl() {
        return this.backgroundUrl;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getEnablePrerecord() {
        return this.enablePrerecord;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getEnableReport() {
        return this.enableReport;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final C9169a getFemalePagResourcePath() {
        return this.femalePagResourcePath;
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    public final String getFemaleUrl() {
        return this.femaleUrl;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final C9169a getMalePagResourcePath() {
        return this.malePagResourcePath;
    }

    @Nullable
    /* renamed from: j, reason: from getter */
    public final String getMaleUrl() {
        return this.maleUrl;
    }

    /* renamed from: k, reason: from getter */
    public final int getMsgType() {
        return this.msgType;
    }

    /* renamed from: l, reason: from getter */
    public final int getPortraitID() {
        return this.portraitID;
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final String getPortraitName() {
        return this.portraitName;
    }

    /* renamed from: n, reason: from getter */
    public final int getPriority() {
        return this.priority;
    }

    /* renamed from: o, reason: from getter */
    public final int getRepeatCount() {
        return this.repeatCount;
    }

    /* renamed from: p, reason: from getter */
    public final boolean getShouldReverseForAvatar() {
        return this.shouldReverseForAvatar;
    }

    /* renamed from: q, reason: from getter */
    public final boolean getShouldReverseForEffect() {
        return this.shouldReverseForEffect;
    }

    @Nullable
    public final HashSet<String> r() {
        return this.textKeywords;
    }

    /* renamed from: s, reason: from getter */
    public final long getTimeStamp() {
        return this.timeStamp;
    }

    /* renamed from: t, reason: from getter */
    public final boolean getIsMale() {
        return this.isMale;
    }

    /* renamed from: u, reason: from getter */
    public final boolean getIsOutBoundAvatar() {
        return this.isOutBoundAvatar;
    }

    public final void v(@Nullable String str) {
        this.appearanceKey = str;
    }

    public final void w(@Nullable Integer num) {
        this.avatarBackgroundLayer = num;
    }

    public final void x(@Nullable Integer num) {
        this.avatarCharacterLayer = num;
    }

    public final void y(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.backgroundUrl = str;
    }

    public final void z(boolean z16) {
        this.enablePrerecord = z16;
    }
}
