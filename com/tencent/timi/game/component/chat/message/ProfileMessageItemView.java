package com.tencent.timi.game.component.chat.message;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.timi.game.profile.api.ui.ProfileMessageView;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.LogUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.MessageOuterClass$QQUserInfoMsg;
import trpc.yes.common.UserProxyCmdOuterClass$QQUserInfo;

@Metadata(d1 = {"\u0000\u008f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001F\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010K\u001a\u00020J\u00a2\u0006\u0004\bL\u0010MB\u001b\b\u0016\u0012\u0006\u0010K\u001a\u00020J\u0012\b\u0010O\u001a\u0004\u0018\u00010N\u00a2\u0006\u0004\bL\u0010PB#\b\u0016\u0012\u0006\u0010K\u001a\u00020J\u0012\b\u0010O\u001a\u0004\u0018\u00010N\u0012\u0006\u0010Q\u001a\u00020)\u00a2\u0006\u0004\bL\u0010RJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0002J\u0012\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J\u0012\u0010\u0018\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J\u0012\u0010\u0019\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J\u0016\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001aH\u0002J*\u0010 \u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u000eH\u0002J*\u0010!\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u000eH\u0002J\u0010\u0010\"\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014R\u0016\u0010#\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u0004R\u0018\u0010%\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010'R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\"R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010\"R\u0014\u0010.\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010\"R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00109R\u0016\u0010>\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u00109R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010I\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010H\u00a8\u0006S"}, d2 = {"Lcom/tencent/timi/game/component/chat/message/ProfileMessageItemView;", "Lcom/tencent/timi/game/component/chat/message/BaseMessageView;", "", "h0", "Z", "Lcom/tencent/timi/game/tim/api/message/a;", "msg", "", "W", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", ITVKPlayerEventListener.KEY_USER_INFO, "Ltrpc/yes/common/MessageOuterClass$QQUserInfoMsg;", "qqUserInfo", "b0", "", "nick", "tip", "i0", "X", "V", "Y", "Landroid/view/View;", "view", "e0", "d0", "c0", "", "U", "", "toUserId", "yesUid", "id", "f0", "g0", "I", "isInFleet", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "alluerInfo", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "qqUserId", "", "CPDD_TYPE_TEXT", "j0", "cpddType", "k0", "nickColor", "Lzf4/d;", "l0", "Lzf4/d;", "tipSelectHelper", "Landroid/widget/RelativeLayout;", "m0", "Landroid/widget/RelativeLayout;", "profileRootView", "Landroid/widget/TextView;", "n0", "Landroid/widget/TextView;", "addQQFriendView", "o0", "roomChatTextView", "p0", "cardDescribeText", "Lcom/tencent/timi/game/profile/api/ui/ProfileMessageView;", "q0", "Lcom/tencent/timi/game/profile/api/ui/ProfileMessageView;", "profileView", "r0", "Landroid/view/View;", "dividerView", "com/tencent/timi/game/component/chat/message/ProfileMessageItemView$a", "s0", "Lcom/tencent/timi/game/component/chat/message/ProfileMessageItemView$a;", "nickNameClickable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class ProfileMessageItemView extends BaseMessageView {

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private boolean isInFleet;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IUserInfo alluerInfo;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CommonOuterClass$QQUserId qqUserId;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private int CPDD_TYPE_TEXT;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private int cpddType;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private final int nickColor;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final zf4.d tipSelectHelper;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RelativeLayout profileRootView;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView addQQFriendView;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView roomChatTextView;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView cardDescribeText;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ProfileMessageView profileView;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View dividerView;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a nickNameClickable;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/timi/game/component/chat/message/ProfileMessageItemView$a", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a extends ClickableSpan {
        a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            if (!com.tencent.timi.game.utils.o.a()) {
                ProfileMessageItemView.this.Y();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds5) {
            Intrinsics.checkNotNullParameter(ds5, "ds");
            ds5.setColor(ProfileMessageItemView.this.nickColor);
            ds5.setUnderlineText(false);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileMessageItemView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.CPDD_TYPE_TEXT = 1;
        this.cpddType = 1;
        this.nickColor = Color.parseColor("#F5A300");
        this.tipSelectHelper = new zf4.d();
        setContentView(R.layout.hvu);
        View findViewById = findViewById(R.id.f27910hi);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.profileRootView)");
        this.profileRootView = (RelativeLayout) findViewById;
        View findViewById2 = findViewById(R.id.scq);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.addQQFriendView)");
        this.addQQFriendView = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.f779845u);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.roomChatTextView)");
        this.roomChatTextView = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.f164725tm0);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.cardDescribeText)");
        this.cardDescribeText = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.f27920hj);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.profileView)");
        this.profileView = (ProfileMessageView) findViewById5;
        View findViewById6 = findViewById(R.id.lft);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.dividerView)");
        this.dividerView = findViewById6;
        RelativeLayout relativeLayout = this.profileRootView;
        if (relativeLayout != null) {
            fh4.g.f(relativeLayout, fh4.b.b(15), -1);
        }
        TextView textView = this.addQQFriendView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.component.chat.message.ae
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProfileMessageItemView.Q(ProfileMessageItemView.this, view);
                }
            });
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.tencent.timi.game.component.chat.message.af
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileMessageItemView.R(ProfileMessageItemView.this, view);
            }
        };
        TextView textView2 = this.roomChatTextView;
        if (textView2 != null) {
            textView2.setOnClickListener(onClickListener);
        }
        this.cardDescribeText.setMovementMethod(LinkMovementMethod.getInstance());
        this.nickNameClickable = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(ProfileMessageItemView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.timi.game.utils.o.a()) {
            Context context = this$0.getContext();
            if ((context instanceof QBaseActivity) && this$0.alluerInfo != null && this$0.qqUserId != null) {
                if (this$0.isInFleet) {
                    if (this$0.getSelfQQUserId() != null) {
                        bm4.a aVar = (bm4.a) mm4.b.b(bm4.a.class);
                        QBaseActivity qBaseActivity = (QBaseActivity) context;
                        CommonOuterClass$QQUserId selfQQUserId = this$0.getSelfQQUserId();
                        Intrinsics.checkNotNull(selfQQUserId);
                        IUserInfo iUserInfo = this$0.alluerInfo;
                        Intrinsics.checkNotNull(iUserInfo);
                        Long c16 = iUserInfo.c();
                        Intrinsics.checkNotNull(c16);
                        String valueOf = String.valueOf(c16.longValue());
                        IUserInfo iUserInfo2 = this$0.alluerInfo;
                        Intrinsics.checkNotNull(iUserInfo2);
                        String i3 = iUserInfo2.i(this$0.qqUserId);
                        Intrinsics.checkNotNullExpressionValue(i3, "alluerInfo!!.nick(qqUserId)");
                        CommonOuterClass$QQUserId commonOuterClass$QQUserId = this$0.qqUserId;
                        Intrinsics.checkNotNull(commonOuterClass$QQUserId);
                        aVar.k0(qBaseActivity, selfQQUserId, valueOf, i3, commonOuterClass$QQUserId, this$0.l());
                    } else {
                        com.tencent.timi.game.utils.l.e("ProfileMessageItemView", "addQQFriendView selfQQUserId==null");
                    }
                } else if (this$0.cpddType == this$0.CPDD_TYPE_TEXT) {
                    bm4.a aVar2 = (bm4.a) mm4.b.b(bm4.a.class);
                    QBaseActivity qBaseActivity2 = (QBaseActivity) context;
                    IUserInfo iUserInfo3 = this$0.alluerInfo;
                    Intrinsics.checkNotNull(iUserInfo3);
                    String valueOf2 = String.valueOf(iUserInfo3.c());
                    IUserInfo iUserInfo4 = this$0.alluerInfo;
                    Intrinsics.checkNotNull(iUserInfo4);
                    String i16 = iUserInfo4.i(this$0.qqUserId);
                    Intrinsics.checkNotNullExpressionValue(i16, "alluerInfo!!.nick(qqUserId)");
                    CommonOuterClass$QQUserId commonOuterClass$QQUserId2 = this$0.qqUserId;
                    Intrinsics.checkNotNull(commonOuterClass$QQUserId2);
                    aVar2.z2(qBaseActivity2, valueOf2, i16, commonOuterClass$QQUserId2, this$0.l());
                } else {
                    bm4.a aVar3 = (bm4.a) mm4.b.b(bm4.a.class);
                    QBaseActivity qBaseActivity3 = (QBaseActivity) context;
                    IUserInfo iUserInfo5 = this$0.alluerInfo;
                    Intrinsics.checkNotNull(iUserInfo5);
                    String valueOf3 = String.valueOf(iUserInfo5.c());
                    IUserInfo iUserInfo6 = this$0.alluerInfo;
                    Intrinsics.checkNotNull(iUserInfo6);
                    String i17 = iUserInfo6.i(this$0.qqUserId);
                    Intrinsics.checkNotNullExpressionValue(i17, "alluerInfo!!.nick(qqUserId)");
                    CommonOuterClass$QQUserId commonOuterClass$QQUserId3 = this$0.qqUserId;
                    Intrinsics.checkNotNull(commonOuterClass$QQUserId3);
                    aVar3.B3(qBaseActivity3, valueOf3, i17, commonOuterClass$QQUserId3, this$0.l());
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(ProfileMessageItemView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.timi.game.utils.o.a()) {
            this$0.h0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final Map<String, String> U() {
        String str;
        String a16;
        Long c16;
        Map<String, String> u16 = u();
        if (u16 instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) u16;
            IUserInfo iUserInfo = this.alluerInfo;
            String str2 = "";
            if (iUserInfo == null || (c16 = iUserInfo.c()) == null) {
                str = "";
            } else {
                str = String.valueOf(c16);
            }
            concurrentHashMap.put("yes_to_uid", str);
            IUserInfo iUserInfo2 = this.alluerInfo;
            if (iUserInfo2 != null && (a16 = nn4.a.a(iUserInfo2.b())) != null) {
                str2 = a16;
            }
            concurrentHashMap.put("yes_to_yes_uid", str2);
        }
        return u16;
    }

    private final void V() {
        com.tencent.timi.game.tim.api.message.a msg2 = getMsg();
        if (msg2 != null) {
            if (X()) {
                CommonOuterClass$QQUserId commonOuterClass$QQUserId = this.qqUserId;
                if (commonOuterClass$QQUserId != null) {
                    Intrinsics.checkNotNull(commonOuterClass$QQUserId);
                    G(commonOuterClass$QQUserId);
                    return;
                }
                return;
            }
            F(msg2);
        }
    }

    private final boolean W(com.tencent.timi.game.tim.api.message.a msg2) {
        if (System.currentTimeMillis() - msg2.time() < 3000) {
            return true;
        }
        return false;
    }

    private final boolean X() {
        CommonOuterClass$QQUserId commonOuterClass$QQUserId;
        bo4.d dVar = (bo4.d) mm4.b.b(bo4.d.class);
        com.tencent.timi.game.tim.api.message.a msg2 = getMsg();
        if (msg2 != null) {
            commonOuterClass$QQUserId = msg2.c();
        } else {
            commonOuterClass$QQUserId = null;
        }
        return dVar.W0(commonOuterClass$QQUserId, l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y() {
        V();
        Map<String, String> U = U();
        if (U != null) {
            ug4.b bVar = (ug4.b) mm4.b.b(ug4.b.class);
            TextView textView = this.cardDescribeText;
            Intrinsics.checkNotNull(textView, "null cannot be cast to non-null type java.lang.Object");
            bVar.reportEvent("clck", textView, U);
        }
    }

    private final void Z() {
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.tencent.timi.game.component.chat.message.ag
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileMessageItemView.a0(ProfileMessageItemView.this, view);
            }
        };
        ProfileMessageView profileMessageView = this.profileView;
        if (profileMessageView != null) {
            profileMessageView.setAvatarClickListener(onClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(ProfileMessageItemView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.V();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0091, code lost:
    
        if (r0 == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00b6, code lost:
    
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00b4, code lost:
    
        if (r11 != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void b0(IUserInfo userInfo, MessageOuterClass$QQUserInfoMsg qqUserInfo, com.tencent.timi.game.tim.api.message.a msg2) {
        boolean z16;
        boolean z17;
        PBUInt64Field pBUInt64Field;
        View b16;
        View b17;
        boolean z18;
        PBUInt64Field pBUInt64Field2;
        com.tencent.timi.game.utils.l.b("ProfileMessageItemView", "refreshUI " + LogUtil.getSafePrintUin(String.valueOf(userInfo.c())));
        ProfileMessageView profileMessageView = this.profileView;
        if (profileMessageView != null) {
            profileMessageView.setUserInfo(userInfo, this.qqUserId, W(msg2));
        }
        if (qqUserInfo.show_scene.get() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isInFleet = z16;
        String i3 = userInfo.i(qqUserInfo.user_id);
        if (i3 == null) {
            i3 = "";
        }
        String str = qqUserInfo.add_friend_tips_text.get();
        Intrinsics.checkNotNullExpressionValue(str, "qqUserInfo.add_friend_tips_text.get()");
        i0(i3, str);
        CommonOuterClass$QQUserId userId = ((ll4.a) mm4.b.b(ll4.a.class)).E();
        Intrinsics.checkNotNullExpressionValue(userId, "userId");
        CommonOuterClass$QQUserId commonOuterClass$QQUserId = qqUserInfo.user_id;
        if (userId.uid.get() != 0) {
            if (commonOuterClass$QQUserId != null && (pBUInt64Field2 = commonOuterClass$QQUserId.uid) != null && userId.uid.get() == pBUInt64Field2.get()) {
                z18 = true;
            } else {
                z18 = false;
            }
        }
        if (userId.yes_uid.get() != 0) {
            if (commonOuterClass$QQUserId != null && (pBUInt64Field = commonOuterClass$QQUserId.yes_uid) != null && userId.yes_uid.get() == pBUInt64Field.get()) {
                z17 = true;
            } else {
                z17 = false;
            }
        }
        boolean z19 = false;
        View view = this.dividerView;
        if (view != null) {
            fh4.g.o(view, false);
        }
        msg2.c().user_from.get();
        TextView textView = this.addQQFriendView;
        if (textView != null) {
            fh4.g.o(textView, false);
        }
        TextView textView2 = this.roomChatTextView;
        if (textView2 != null) {
            fh4.g.f(textView2, fh4.b.b(14), Color.parseColor("#F4A92B"));
        }
        TextView textView3 = this.roomChatTextView;
        if (textView3 != null) {
            fh4.g.o(textView3, !z19);
        }
        TextView textView4 = this.roomChatTextView;
        if (textView4 != null) {
            textView4.setText(R.string.f2314471v);
        }
        if (this.isInFleet) {
            ProfileMessageView profileMessageView2 = this.profileView;
            if (profileMessageView2 != null && (b17 = profileMessageView2.b()) != null) {
                fh4.g.o(b17, true);
            }
            TextView textView5 = this.roomChatTextView;
            IUserInfo iUserInfo = this.alluerInfo;
            Intrinsics.checkNotNull(iUserInfo);
            Long c16 = iUserInfo.c();
            Intrinsics.checkNotNullExpressionValue(c16, "alluerInfo!!.uid()");
            long longValue = c16.longValue();
            IUserInfo iUserInfo2 = this.alluerInfo;
            Intrinsics.checkNotNull(iUserInfo2);
            f0(textView5, longValue, iUserInfo2.b(), "em_yes_chat_userprofile_sayhi");
        } else {
            ProfileMessageView profileMessageView3 = this.profileView;
            if (profileMessageView3 != null && (b16 = profileMessageView3.b()) != null) {
                fh4.g.o(b16, false);
            }
            TextView textView6 = this.roomChatTextView;
            IUserInfo iUserInfo3 = this.alluerInfo;
            Intrinsics.checkNotNull(iUserInfo3);
            Long c17 = iUserInfo3.c();
            Intrinsics.checkNotNullExpressionValue(c17, "alluerInfo!!.uid()");
            long longValue2 = c17.longValue();
            IUserInfo iUserInfo4 = this.alluerInfo;
            Intrinsics.checkNotNull(iUserInfo4);
            g0(textView6, longValue2, iUserInfo4.b(), "em_yes_chat_userprofile_sayhi");
        }
        if (this.isInFleet) {
            c0(this.addQQFriendView);
            d0(this.profileView);
            e0(this.cardDescribeText);
            this.cardDescribeText.setTextSize(1, 10.0f);
            return;
        }
        TextView textView7 = this.addQQFriendView;
        IUserInfo iUserInfo5 = this.alluerInfo;
        Intrinsics.checkNotNull(iUserInfo5);
        Long c18 = iUserInfo5.c();
        Intrinsics.checkNotNullExpressionValue(c18, "alluerInfo!!.uid()");
        long longValue3 = c18.longValue();
        IUserInfo iUserInfo6 = this.alluerInfo;
        Intrinsics.checkNotNull(iUserInfo6);
        f0(textView7, longValue3, iUserInfo6.b(), "em_yes_chat_userprofile_add_friend");
        this.cardDescribeText.setTextSize(1, 12.0f);
    }

    private final void c0(View view) {
        Map<String, String> U = U();
        if (U != null) {
            ql4.b.f429064a.b(view, "em_yes_chat_userprofile_add_friend", U);
        }
    }

    private final void d0(View view) {
        Map<String, String> U = U();
        if (U != null) {
            ql4.b.f429064a.b(view, "em_yes_chat_userprofile_user_head", U);
        }
    }

    private final void e0(View view) {
        Map<String, String> U = U();
        if (U != null) {
            ql4.b.f429064a.b(view, "em_yes_chat_userprofile_nickname", U);
        }
    }

    private final void f0(View view, long toUserId, long yesUid, String id5) {
        ql4.b.f429064a.b(view, id5, zf4.b.f452467a.a(getRoomInfo(), toUserId, yesUid, l()));
    }

    private final void g0(View view, long toUserId, long yesUid, String id5) {
        ql4.b.f429064a.b(view, id5, zf4.b.f452467a.b(getRoomInfo(), toUserId, yesUid, l()));
    }

    private final void h0() {
        zf4.c.f452468a.l(this.alluerInfo, getMsg(), this.qqUserId, getRoomInfo(), getSelfQQUserId(), this.tipSelectHelper);
    }

    private final void i0(String nick, String tip) {
        if (this.isInFleet) {
            StringBuilder sb5 = new StringBuilder(nick);
            sb5.append(" ");
            sb5.append(getResources().getString(R.string.f2314371u));
            if (!TextUtils.isEmpty(tip)) {
                sb5.append("\uff0c");
                sb5.append(tip);
            }
            SpannableString spannableString = new SpannableString(sb5.toString());
            if (!TextUtils.isEmpty(nick)) {
                spannableString.setSpan(new ForegroundColorSpan(this.nickColor), 0, nick.length(), 33);
                spannableString.setSpan(this.nickNameClickable, 0, nick.length(), 33);
            }
            this.cardDescribeText.setText(spannableString);
            fh4.g.o(this.cardDescribeText, true);
            return;
        }
        this.cardDescribeText.setText(tip);
        fh4.g.o(this.cardDescribeText, !TextUtils.isEmpty(tip));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.component.chat.message.BaseMessageView
    public void I(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        super.I(msg2);
        MessageOuterClass$QQUserInfoMsg messageOuterClass$QQUserInfoMsg = msg2.a().qq_user_info_msg.get();
        if (messageOuterClass$QQUserInfoMsg != null) {
            bo4.d dVar = (bo4.d) mm4.b.b(bo4.d.class);
            UserProxyCmdOuterClass$QQUserInfo userProxyCmdOuterClass$QQUserInfo = messageOuterClass$QQUserInfoMsg.qq_user_info;
            Intrinsics.checkNotNullExpressionValue(userProxyCmdOuterClass$QQUserInfo, "it.qq_user_info");
            IUserInfo d16 = dVar.d1(userProxyCmdOuterClass$QQUserInfo);
            this.alluerInfo = d16;
            this.qqUserId = messageOuterClass$QQUserInfoMsg.user_id;
            b0(d16, messageOuterClass$QQUserInfoMsg, msg2);
            Z();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileMessageItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.CPDD_TYPE_TEXT = 1;
        this.cpddType = 1;
        this.nickColor = Color.parseColor("#F5A300");
        this.tipSelectHelper = new zf4.d();
        setContentView(R.layout.hvu);
        View findViewById = findViewById(R.id.f27910hi);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.profileRootView)");
        this.profileRootView = (RelativeLayout) findViewById;
        View findViewById2 = findViewById(R.id.scq);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.addQQFriendView)");
        this.addQQFriendView = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.f779845u);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.roomChatTextView)");
        this.roomChatTextView = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.f164725tm0);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.cardDescribeText)");
        this.cardDescribeText = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.f27920hj);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.profileView)");
        this.profileView = (ProfileMessageView) findViewById5;
        View findViewById6 = findViewById(R.id.lft);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.dividerView)");
        this.dividerView = findViewById6;
        RelativeLayout relativeLayout = this.profileRootView;
        if (relativeLayout != null) {
            fh4.g.f(relativeLayout, fh4.b.b(15), -1);
        }
        TextView textView = this.addQQFriendView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.component.chat.message.ae
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProfileMessageItemView.Q(ProfileMessageItemView.this, view);
                }
            });
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.tencent.timi.game.component.chat.message.af
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileMessageItemView.R(ProfileMessageItemView.this, view);
            }
        };
        TextView textView2 = this.roomChatTextView;
        if (textView2 != null) {
            textView2.setOnClickListener(onClickListener);
        }
        this.cardDescribeText.setMovementMethod(LinkMovementMethod.getInstance());
        this.nickNameClickable = new a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileMessageItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.CPDD_TYPE_TEXT = 1;
        this.cpddType = 1;
        this.nickColor = Color.parseColor("#F5A300");
        this.tipSelectHelper = new zf4.d();
        setContentView(R.layout.hvu);
        View findViewById = findViewById(R.id.f27910hi);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.profileRootView)");
        this.profileRootView = (RelativeLayout) findViewById;
        View findViewById2 = findViewById(R.id.scq);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.addQQFriendView)");
        this.addQQFriendView = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.f779845u);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.roomChatTextView)");
        this.roomChatTextView = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.f164725tm0);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.cardDescribeText)");
        this.cardDescribeText = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.f27920hj);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.profileView)");
        this.profileView = (ProfileMessageView) findViewById5;
        View findViewById6 = findViewById(R.id.lft);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.dividerView)");
        this.dividerView = findViewById6;
        RelativeLayout relativeLayout = this.profileRootView;
        if (relativeLayout != null) {
            fh4.g.f(relativeLayout, fh4.b.b(15), -1);
        }
        TextView textView = this.addQQFriendView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.component.chat.message.ae
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProfileMessageItemView.Q(ProfileMessageItemView.this, view);
                }
            });
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.tencent.timi.game.component.chat.message.af
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileMessageItemView.R(ProfileMessageItemView.this, view);
            }
        };
        TextView textView2 = this.roomChatTextView;
        if (textView2 != null) {
            textView2.setOnClickListener(onClickListener);
        }
        this.cardDescribeText.setMovementMethod(LinkMovementMethod.getInstance());
        this.nickNameClickable = new a();
    }
}
