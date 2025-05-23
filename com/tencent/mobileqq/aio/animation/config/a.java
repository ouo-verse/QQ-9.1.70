package com.tencent.mobileqq.aio.animation.config;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.bl;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 U2\u00020\u0001:\u0001\fB\t\b\u0016\u00a2\u0006\u0004\ba\u0010bB\u0011\b\u0016\u0012\u0006\u0010c\u001a\u00020\u0000\u00a2\u0006\u0004\ba\u0010dJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\t\u001a\u00020\bH\u0016J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002R\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R6\u0010 \u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010'\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b#\u0010&R\"\u0010*\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010#\u001a\u0004\b(\u0010%\"\u0004\b)\u0010&R\"\u0010.\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\r\u001a\u0004\b,\u0010\u000f\"\u0004\b-\u0010\u0011R\"\u00101\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010\r\u001a\u0004\b+\u0010\u000f\"\u0004\b0\u0010\u0011R\"\u00104\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\r\u001a\u0004\b2\u0010\u000f\"\u0004\b3\u0010\u0011R\"\u0010:\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b\u001a\u00107\"\u0004\b8\u00109R6\u0010=\u001a\u0016\u0012\u0004\u0012\u00020;\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020;\u0018\u0001`\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010\u001b\u001a\u0004\b5\u0010\u001d\"\u0004\b<\u0010\u001fR$\u0010E\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010K\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bF\u0010H\"\u0004\bI\u0010JR$\u0010M\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010G\u001a\u0004\b?\u0010H\"\u0004\bL\u0010JR\u0017\u0010Q\u001a\u00020N8\u0006\u00a2\u0006\f\n\u0004\bA\u0010O\u001a\u0004\b\"\u0010PR\"\u0010T\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010\r\u001a\u0004\bS\u0010\u000f\"\u0004\b\r\u0010\u0011R\"\u0010W\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bS\u00106\u001a\u0004\bU\u00107\"\u0004\bV\u00109R\"\u0010Y\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u00106\u001a\u0004\b\u0013\u00107\"\u0004\bX\u00109R\"\u0010[\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010#\u001a\u0004\b/\u0010%\"\u0004\bZ\u0010&R\"\u0010^\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010G\u001a\u0004\b\\\u0010H\"\u0004\b]\u0010JR\u0011\u0010_\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u000fR\u0011\u0010`\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\bR\u0010H\u00a8\u0006e"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/config/a;", "", "", "largeCount", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", ReportConstant.COSTREPORT_PREFIX, "", "toString", "chatType", "N", "a", "I", "r", "()I", "M", "(I)V", "type", "b", h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "id", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/aio/animation/egg/a;", "Lkotlin/collections/ArrayList;", "c", "Ljava/util/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/util/ArrayList;", UserInfo.SEX_FEMALE, "(Ljava/util/ArrayList;)V", "keywordsList", "", "d", "J", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()J", "(J)V", "startTimeStamp", "e", "w", "endTimeStamp", "f", "getMatchKeyIndex", "H", "matchKeyIndex", "g", HippyTKDListViewAdapter.X, "floorLimit", "j", BdhLogUtil.LogTag.Tag_Conn, "jumpLimit", "i", "Z", "()Z", "v", "(Z)V", "crazyModeEnable", "Lcom/tencent/mobileqq/aio/animation/config/e;", "B", "jumpImageList", "Lcom/tencent/mobileqq/aio/animation/config/b;", "k", "Lcom/tencent/mobileqq/aio/animation/config/b;", DomainData.DOMAIN_NAME, "()Lcom/tencent/mobileqq/aio/animation/config/b;", "G", "(Lcom/tencent/mobileqq/aio/animation/config/b;)V", "mBusinessData", "l", "Ljava/lang/String;", "()Ljava/lang/String;", "E", "(Ljava/lang/String;)V", WadlProxyConsts.KEY_JUMP_URL, "D", "jumpType", "Lcom/tencent/mobileqq/aio/animation/config/d;", "Lcom/tencent/mobileqq/aio/animation/config/d;", "()Lcom/tencent/mobileqq/aio/animation/config/d;", "emitterProperties", "o", "p", "maxTriggerCount", "t", "L", "isTrigger", "u", "canInterceptTouch", "y", "frequencyDuration", "getSupportChatType", "K", "supportChatType", "bid", "matchedKeyword", "<init>", "()V", QCircleDaTongConstant.ElementParamValue.XSJ_SHARE_PANEL_STYLE_OLD, "(Lcom/tencent/mobileqq/aio/animation/config/a;)V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int id;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ArrayList<com.tencent.mobileqq.aio.animation.egg.a> keywordsList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long startTimeStamp;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long endTimeStamp;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int matchKeyIndex;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int floorLimit;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int jumpLimit;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean crazyModeEnable;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ArrayList<e> jumpImageList;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b mBusinessData;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String jumpUrl;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String jumpType;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d emitterProperties;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private int maxTriggerCount;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private boolean isTrigger;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private boolean canInterceptTouch;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private long frequencyDuration;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String supportChatType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/config/a$a;", "", "", "JUMP_HTML", "Ljava/lang/String;", "TAG", "<init>", "()V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.animation.config.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29688);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 48)) {
            redirector.redirect((short) 48);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this);
            return;
        }
        this.id = -1;
        this.floorLimit = -1;
        this.jumpLimit = -1;
        this.canInterceptTouch = true;
        this.supportChatType = "";
        this.emitterProperties = new d();
    }

    public final void A(int largeCount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, largeCount);
            return;
        }
        if (bl.b(this.jumpImageList)) {
            return;
        }
        ArrayList<e> arrayList = this.jumpImageList;
        Intrinsics.checkNotNull(arrayList);
        int i3 = 0;
        for (int size = arrayList.size() - 1; i3 < largeCount && size >= 0; size--) {
            ArrayList<e> arrayList2 = this.jumpImageList;
            Intrinsics.checkNotNull(arrayList2);
            arrayList2.get(size).s(true);
            i3++;
        }
    }

    public final void B(@Nullable ArrayList<e> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) arrayList);
        } else {
            this.jumpImageList = arrayList;
        }
    }

    public final void C(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
        } else {
            this.jumpLimit = i3;
        }
    }

    public final void D(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) str);
        } else {
            this.jumpType = str;
        }
    }

    public final void E(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) str);
        } else {
            this.jumpUrl = str;
        }
    }

    public final void F(@Nullable ArrayList<com.tencent.mobileqq.aio.animation.egg.a> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) arrayList);
        } else {
            this.keywordsList = arrayList;
        }
    }

    public final void G(@Nullable b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) bVar);
        } else {
            this.mBusinessData = bVar;
        }
    }

    public final void H(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.matchKeyIndex = i3;
        }
    }

    public final void I(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, i3);
        } else {
            this.maxTriggerCount = i3;
        }
    }

    public final void J(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, j3);
        } else {
            this.startTimeStamp = j3;
        }
    }

    public final void K(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.supportChatType = str;
        }
    }

    public final void L(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, z16);
        } else {
            this.isTrigger = z16;
        }
    }

    public final void M(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.type = i3;
        }
    }

    public final boolean N(int chatType) {
        boolean z16;
        boolean contains$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return ((Boolean) iPatchRedirector.redirect((short) 46, (Object) this, chatType)).booleanValue();
        }
        String str = this.supportChatType;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return true;
        }
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) this.supportChatType, (CharSequence) ("[" + chatType + "]"), false, 2, (Object) null);
        return contains$default;
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }
        if (this.mBusinessData != null) {
            return a();
        }
        return -1;
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this)).booleanValue();
        }
        return this.canInterceptTouch;
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return this.crazyModeEnable;
    }

    @NotNull
    public final d d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (d) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return this.emitterProperties;
    }

    public final long e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this)).longValue();
        }
        return this.endTimeStamp;
    }

    public final int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.floorLimit;
    }

    public final long g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Long) iPatchRedirector.redirect((short) 37, (Object) this)).longValue();
        }
        return this.frequencyDuration;
    }

    public final int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.id;
    }

    @Nullable
    public final ArrayList<e> i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (ArrayList) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.jumpImageList;
    }

    public final int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return this.jumpLimit;
    }

    @Nullable
    public final String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return this.jumpType;
    }

    @Nullable
    public final String l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return this.jumpUrl;
    }

    @Nullable
    public final ArrayList<com.tencent.mobileqq.aio.animation.egg.a> m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ArrayList) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.keywordsList;
    }

    @Nullable
    public final b n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (b) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.mBusinessData;
    }

    @NotNull
    public final String o() {
        ArrayList<com.tencent.mobileqq.aio.animation.egg.a> arrayList;
        com.tencent.mobileqq.aio.animation.egg.a aVar;
        String a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return (String) iPatchRedirector.redirect((short) 47, (Object) this);
        }
        if (this.matchKeyIndex >= bl.d(this.keywordsList) || (arrayList = this.keywordsList) == null || (aVar = arrayList.get(this.matchKeyIndex)) == null || (a16 = aVar.a()) == null) {
            return "";
        }
        return a16;
    }

    public final int p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Integer) iPatchRedirector.redirect((short) 31, (Object) this)).intValue();
        }
        return this.maxTriggerCount;
    }

    public final long q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        return this.startTimeStamp;
    }

    public final int r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
        }
        return this.type;
    }

    public final boolean s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Boolean) iPatchRedirector.redirect((short) 44, (Object) this)).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.startTimeStamp;
        if (j3 != 0) {
            long j16 = this.endTimeStamp;
            if (j16 != 0) {
                if (currentTimeMillis > j16 || j3 > currentTimeMillis) {
                    return false;
                }
                return true;
            }
        }
        if (j3 != 0) {
            if (currentTimeMillis < j3) {
                return false;
            }
        } else {
            long j17 = this.endTimeStamp;
            if (j17 != 0 && currentTimeMillis > j17) {
                return false;
            }
        }
        return true;
    }

    public final boolean t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this)).booleanValue();
        }
        return this.isTrigger;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return (String) iPatchRedirector.redirect((short) 45, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.id);
        ArrayList<com.tencent.mobileqq.aio.animation.egg.a> arrayList = this.keywordsList;
        if (arrayList != null) {
            Iterator<com.tencent.mobileqq.aio.animation.egg.a> it = arrayList.iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.aio.animation.egg.a next = it.next();
                sb5.append(next.b());
                sb5.append(".");
                sb5.append(next.a());
                sb5.append(".");
            }
        }
        return super.toString() + ((Object) sb5);
    }

    public final void u(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, z16);
        } else {
            this.canInterceptTouch = z16;
        }
    }

    public final void v(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
        } else {
            this.crazyModeEnable = z16;
        }
    }

    public final void w(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, j3);
        } else {
            this.endTimeStamp = j3;
        }
    }

    public final void x(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.floorLimit = i3;
        }
    }

    public final void y(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, j3);
        } else {
            this.frequencyDuration = j3;
        }
    }

    public final void z(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.id = i3;
        }
    }

    public a(@NotNull a old) {
        Intrinsics.checkNotNullParameter(old, "old");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, (Object) old);
            return;
        }
        this.id = -1;
        this.floorLimit = -1;
        this.jumpLimit = -1;
        this.canInterceptTouch = true;
        this.supportChatType = "";
        this.id = old.id;
        this.type = old.type;
        this.keywordsList = old.keywordsList;
        this.matchKeyIndex = old.matchKeyIndex;
        this.floorLimit = old.floorLimit;
        this.jumpLimit = old.jumpLimit;
        this.crazyModeEnable = old.crazyModeEnable;
        this.jumpImageList = old.jumpImageList;
        this.mBusinessData = old.mBusinessData;
        this.jumpUrl = old.jumpUrl;
        this.jumpType = old.jumpType;
        this.endTimeStamp = old.endTimeStamp;
        this.startTimeStamp = old.startTimeStamp;
        this.maxTriggerCount = old.maxTriggerCount;
        this.canInterceptTouch = old.canInterceptTouch;
        this.emitterProperties = old.emitterProperties.clone();
        this.frequencyDuration = old.frequencyDuration;
    }
}
