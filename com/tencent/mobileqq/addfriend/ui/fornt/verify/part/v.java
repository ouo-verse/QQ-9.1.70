package com.tencent.mobileqq.addfriend.ui.fornt.verify.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.CallSuper;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.addfriend.handler.NTAddFriendHandler;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.guild.api.IGuildAddQQFriendApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendDataUtilApi;
import com.tencent.mobileqq.newnearby.INearbyAddFriendHelper;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.kernel.nativeinterface.BuddySource;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0012\n\u0002\b7\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u0000 \u0085\u00012\u00020\u0001:\u0002\u0086\u0001B\t\u00a2\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u001a\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0017J\b\u0010\r\u001a\u0004\u0018\u00010\fJ\b\u0010\u000f\u001a\u00020\u000eH\u0004J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0004J\u0006\u0010\u0013\u001a\u00020\u000eJ\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u0012\u0010\u0018\u001a\u00020\u00172\b\b\u0001\u0010\u0016\u001a\u00020\u0010H\u0004J,\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u001aj\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017`\u001b2\u0006\u0010\u0019\u001a\u00020\u0010H\u0004J\u0018\u0010 \u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u000eH\u0004R\"\u0010'\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010+\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\"\u001a\u0004\b)\u0010$\"\u0004\b*\u0010&R\"\u00103\u001a\u00020,8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u0010:\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010A\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010E\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010<\u001a\u0004\bC\u0010>\"\u0004\bD\u0010@R\"\u0010I\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010<\u001a\u0004\bG\u0010>\"\u0004\bH\u0010@R\"\u0010M\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010<\u001a\u0004\bK\u0010>\"\u0004\bL\u0010@R\"\u0010Q\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010<\u001a\u0004\bO\u0010>\"\u0004\bP\u0010@R$\u0010X\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR$\u0010\\\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bY\u00105\u001a\u0004\bZ\u00107\"\u0004\b[\u00109R\"\u0010c\u001a\u00020\u00058\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR$\u0010j\u001a\u0004\u0018\u00010d8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\"\u0010n\u001a\u00020\u00178\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bk\u00105\u001a\u0004\bl\u00107\"\u0004\bm\u00109R\"\u0010r\u001a\u00020\u00178\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bo\u00105\u001a\u0004\bp\u00107\"\u0004\bq\u00109R\"\u0010v\u001a\u00020\u00108\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bs\u0010\"\u001a\u0004\bt\u0010$\"\u0004\bu\u0010&R$\u0010~\u001a\u0004\u0018\u00010w8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R%\u0010\u0082\u0001\u001a\u00020\u00178\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0014\n\u0004\b\u007f\u00105\u001a\u0005\b\u0080\u0001\u00107\"\u0005\b\u0081\u0001\u00109\u00a8\u0006\u0087\u0001"}, d2 = {"Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/v;", "Lcom/tencent/biz/richframework/part/Part;", "", "V9", "U9", "Landroid/content/Intent;", "C9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Lcom/tencent/common/app/AppInterface;", "z9", "", "W9", "", "sourceId", "x9", "X9", "Lcom/tencent/mobileqq/app/QBaseActivity;", "R9", "resId", "", "getString", "errorCode", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "S9", "Lcom/tencent/mobileqq/widget/QQToast;", "toast", "needTitleBarHeight", "aa", "d", "I", "L9", "()I", "setMSourceId", "(I)V", "mSourceId", "e", "M9", "setMSubSourceId", "mSubSourceId", "", "f", "[B", "N9", "()[B", "Y9", "([B)V", "mThirdSourceId", tl.h.F, "Ljava/lang/String;", "O9", "()Ljava/lang/String;", "setMTraceID", "(Ljava/lang/String;)V", "mTraceID", "i", "Z", "K9", "()Z", "setMIsFromNearby", "(Z)V", "mIsFromNearby", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "J9", "setMIsFromMatchFriend", "mIsFromMatchFriend", BdhLogUtil.LogTag.Tag_Conn, "H9", "setMIsFromGroup", "mIsFromGroup", "D", "I9", "setMIsFromGuild", "mIsFromGuild", "E", "G9", "setMIsAddByMobile", "mIsAddByMobile", UserInfo.SEX_FEMALE, "Ljava/lang/Integer;", "P9", "()Ljava/lang/Integer;", "setMType", "(Ljava/lang/Integer;)V", HttpMsg.MTYPE, "G", "D9", "setMAddUin", "mAddUin", "H", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", "intent", "Lcom/tencent/mobileqq/addfriend/handler/NTAddFriendHandler;", "Lcom/tencent/mobileqq/addfriend/handler/NTAddFriendHandler;", "B9", "()Lcom/tencent/mobileqq/addfriend/handler/NTAddFriendHandler;", "setHandler", "(Lcom/tencent/mobileqq/addfriend/handler/NTAddFriendHandler;)V", "handler", "J", "A9", "setCallFrom", "callFrom", "K", "T9", "setWebimVisitId", "webimVisitId", "L", "E9", "setMEntrance", "mEntrance", "Lcom/tencent/mobileqq/data/KplRoleInfo$WZRYUIinfo;", "M", "Lcom/tencent/mobileqq/data/KplRoleInfo$WZRYUIinfo;", "Q9", "()Lcom/tencent/mobileqq/data/KplRoleInfo$WZRYUIinfo;", "Z9", "(Lcom/tencent/mobileqq/data/KplRoleInfo$WZRYUIinfo;)V", "mWZRYUIinfo", "N", "F9", "setMExtUinStr", "mExtUinStr", "<init>", "()V", "P", "a", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public class v extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mIsFromGroup;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mIsFromGuild;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mIsAddByMobile;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Integer mType;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private String mAddUin;

    /* renamed from: H, reason: from kotlin metadata */
    public Intent intent;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private NTAddFriendHandler handler;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private String callFrom;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private String webimVisitId;

    /* renamed from: L, reason: from kotlin metadata */
    private int mEntrance;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private KplRoleInfo.WZRYUIinfo mWZRYUIinfo;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private String mExtUinStr;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mSourceId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mSubSourceId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public byte[] mThirdSourceId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mTraceID;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mIsFromNearby;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mIsFromMatchFriend;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/v$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.addfriend.ui.fornt.verify.part.v$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23959);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 47)) {
            redirector.redirect((short) 47);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mType = 0;
        this.callFrom = "";
        this.webimVisitId = "";
        this.mEntrance = -1;
        this.mExtUinStr = "0";
    }

    private final Intent C9() {
        Intent intent;
        if (getPartHost() instanceof QBaseFragment) {
            IPartHost partHost = getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseFragment");
            Bundle arguments = ((QBaseFragment) partHost).getArguments();
            if (arguments != null) {
                Parcelable parcelable = arguments.getParcelable("add_friend_intent");
                if (parcelable instanceof Intent) {
                    return (Intent) parcelable;
                }
            }
        }
        Activity activity = getActivity();
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        if (intent == null) {
            return new Intent();
        }
        return intent;
    }

    private final void U9() {
        AppInterface f16 = com.tencent.mobileqq.addfriend.utils.a.f();
        if (f16 == null) {
            return;
        }
        BusinessHandler businessHandler = f16.getBusinessHandler(NTAddFriendHandler.class.getName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.addfriend.handler.NTAddFriendHandler");
        this.handler = (NTAddFriendHandler) businessHandler;
        String stringExtra = C9().getStringExtra(IPublicAccountBrowser.KEY_CALL_FROM);
        if (stringExtra == null) {
            stringExtra = getPartHost().getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(stringExtra, "partHost.javaClass.simpleName");
        }
        this.callFrom = stringExtra;
    }

    private final void V9() {
        setIntent(C9());
        this.mType = Integer.valueOf(getIntent().getIntExtra("k_uin_type", 1));
        this.mAddUin = getIntent().getStringExtra("uin");
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("third_source_id");
        if (byteArrayExtra == null) {
            byteArrayExtra = new byte[0];
        }
        Y9(byteArrayExtra);
        this.mSubSourceId = getIntent().getIntExtra("sub_source_id", 0);
        this.mSourceId = getIntent().getIntExtra("source_id", BuddySource.DEFAULT);
        String stringExtra = getIntent().getStringExtra("recom_trace");
        String str = "";
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.mTraceID = stringExtra;
        this.mIsFromNearby = ((INearbyAddFriendHelper) QRoute.api(INearbyAddFriendHelper.class)).isFromNearby(this.mSourceId, this.mSubSourceId, N9());
        this.mIsFromMatchFriend = ((IMatchFriendDataUtilApi) QRoute.api(IMatchFriendDataUtilApi.class)).isFromMatchFriend(this.mSourceId, this.mSubSourceId);
        this.mIsFromGuild = ((IGuildAddQQFriendApi) QRoute.api(IGuildAddQQFriendApi.class)).isFromGuild(this.mSourceId, this.mSubSourceId);
        if (x9(this.mSourceId)) {
            this.mIsFromGroup = true;
        }
        String stringExtra2 = getIntent().getStringExtra("webImVisitId");
        if (stringExtra2 != null) {
            str = stringExtra2;
        }
        this.webimVisitId = str;
        this.mEntrance = getIntent().getIntExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, -1);
        this.mWZRYUIinfo = (KplRoleInfo.WZRYUIinfo) getIntent().getSerializableExtra(IProfileCardConst.KEY_WZRY_DATA);
        this.mIsAddByMobile = friendlist.a.a(getIntent().getIntExtra("sort_id", 0));
        String stringExtra3 = getIntent().getStringExtra("extra");
        if (stringExtra3 == null) {
            stringExtra3 = "0";
        }
        this.mExtUinStr = stringExtra3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final String A9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return this.callFrom;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final NTAddFriendHandler B9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (NTAddFriendHandler) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return this.handler;
    }

    @Nullable
    public final String D9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.mAddUin;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int E9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Integer) iPatchRedirector.redirect((short) 32, (Object) this)).intValue();
        }
        return this.mEntrance;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final String F9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (String) iPatchRedirector.redirect((short) 36, (Object) this);
        }
        return this.mExtUinStr;
    }

    public final boolean G9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return this.mIsAddByMobile;
    }

    public final boolean H9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return this.mIsFromGroup;
    }

    public final boolean I9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return this.mIsFromGuild;
    }

    public final boolean J9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.mIsFromMatchFriend;
    }

    public final boolean K9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.mIsFromNearby;
    }

    public final int L9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.mSourceId;
    }

    public final int M9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.mSubSourceId;
    }

    @NotNull
    public final byte[] N9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (byte[]) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        byte[] bArr = this.mThirdSourceId;
        if (bArr != null) {
            return bArr;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mThirdSourceId");
        return null;
    }

    @Nullable
    public final String O9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mTraceID;
    }

    @Nullable
    public final Integer P9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (Integer) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.mType;
    }

    @Nullable
    public final KplRoleInfo.WZRYUIinfo Q9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (KplRoleInfo.WZRYUIinfo) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        return this.mWZRYUIinfo;
    }

    @Nullable
    public final QBaseActivity R9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return (QBaseActivity) iPatchRedirector.redirect((short) 43, (Object) this);
        }
        Activity activity = getActivity();
        if (activity instanceof QBaseActivity) {
            return (QBaseActivity) activity;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final HashMap<String, String> S9(int errorCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return (HashMap) iPatchRedirector.redirect((short) 45, (Object) this, errorCode);
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("sourceid", String.valueOf(this.mSourceId));
        hashMap.put("subsourceid", String.valueOf(this.mSubSourceId));
        hashMap.put("errorCode", String.valueOf(errorCode));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final String T9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (String) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return this.webimVisitId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean W9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Boolean) iPatchRedirector.redirect((short) 40, (Object) this)).booleanValue();
        }
        if (getActivity() != null && !getActivity().isFinishing()) {
            return false;
        }
        return true;
    }

    public final boolean X9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Boolean) iPatchRedirector.redirect((short) 42, (Object) this)).booleanValue();
        }
        if (getPartHost() instanceof Fragment) {
            Object partHost = getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            return ((Fragment) partHost).isAdded();
        }
        return false;
    }

    public final void Y9(@NotNull byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bArr);
        } else {
            Intrinsics.checkNotNullParameter(bArr, "<set-?>");
            this.mThirdSourceId = bArr;
        }
    }

    public final void Z9(@Nullable KplRoleInfo.WZRYUIinfo wZRYUIinfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) wZRYUIinfo);
        } else {
            this.mWZRYUIinfo = wZRYUIinfo;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void aa(@NotNull QQToast toast, boolean needTitleBarHeight) {
        int dimensionPixelSize;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, this, toast, Boolean.valueOf(needTitleBarHeight));
            return;
        }
        Intrinsics.checkNotNullParameter(toast, "toast");
        QBaseActivity R9 = R9();
        if (needTitleBarHeight) {
            if (R9 != null) {
                dimensionPixelSize = R9.getTitleBarHeight();
            } else {
                dimensionPixelSize = getActivity().getResources().getDimensionPixelSize(R.dimen.title_bar_height);
            }
            toast.show(dimensionPixelSize);
            return;
        }
        toast.show();
    }

    @NotNull
    public final Intent getIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (Intent) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        Intent intent = this.intent;
        if (intent != null) {
            return intent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("intent");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final String getString(@StringRes int resId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return (String) iPatchRedirector.redirect((short) 44, (Object) this, resId);
        }
        if (getActivity() != null) {
            String string = getActivity().getResources().getString(resId);
            Intrinsics.checkNotNullExpressionValue(string, "activity.resources.getString(resId)");
            return string;
        }
        return "";
    }

    @Override // com.tencent.biz.richframework.part.Part
    @CallSuper
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        V9();
        U9();
    }

    public final void setIntent(@NotNull Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) intent);
        } else {
            Intrinsics.checkNotNullParameter(intent, "<set-?>");
            this.intent = intent;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean x9(int sourceId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Boolean) iPatchRedirector.redirect((short) 41, (Object) this, sourceId)).booleanValue();
        }
        if (sourceId == 3004) {
            return true;
        }
        return false;
    }

    @Nullable
    public final AppInterface z9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (AppInterface) iPatchRedirector.redirect((short) 39, (Object) this);
        }
        return com.tencent.mobileqq.addfriend.utils.a.f();
    }
}
