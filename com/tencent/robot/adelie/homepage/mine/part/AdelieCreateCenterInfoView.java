package com.tencent.robot.adelie.homepage.mine.part;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.am;
import com.tencent.robot.adelie.homepage.mine.part.AdelieHomeMineGridPart;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010&\u001a\u00020%\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000fR\u0018\u0010\u001a\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u000fR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u000fR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006)"}, d2 = {"Lcom/tencent/robot/adelie/homepage/mine/part/AdelieCreateCenterInfoView;", "Landroid/widget/RelativeLayout;", "", "uin", "", "a", "La24/d;", "data", "setData", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "d", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "userIconView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "userNameView", "f", "createCountView", tl.h.F, "friendCountView", "i", "messageCountView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "createCountUnitView", BdhLogUtil.LogTag.Tag_Conn, "friendCountUnitView", "D", "messageCountUnitView", "Landroid/widget/LinearLayout;", "E", "Landroid/widget/LinearLayout;", "userInfoView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieCreateCenterInfoView extends RelativeLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TextView friendCountUnitView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private TextView messageCountUnitView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private LinearLayout userInfoView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQProAvatarView userIconView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView userNameView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView createCountView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView friendCountView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView messageCountView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView createCountUnitView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieCreateCenterInfoView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a(String uin) {
        com.tencent.mobileqq.proavatar.e a16 = new e.a(0, false, false, false, 0, false, 0, 0, null, false, false, 0, null, null, 0, 32767, null).g(140).a();
        QQProAvatarView qQProAvatarView = this.userIconView;
        if (qQProAvatarView != null) {
            qQProAvatarView.x(1, uin, a16);
        }
    }

    public final void setData(@NotNull a24.d data) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(data, "data");
        AdelieHomeMineGridPart.Companion companion = AdelieHomeMineGridPart.INSTANCE;
        Pair<String, String> a16 = companion.a(data.getSummary().robotNum);
        TextView textView = this.createCountView;
        if (textView != null) {
            textView.setText(a16.getFirst());
        }
        boolean z18 = true;
        if (a16.getSecond().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            TextView textView2 = this.createCountUnitView;
            if (textView2 != null) {
                textView2.setText(a16.getSecond());
            }
            TextView textView3 = this.createCountUnitView;
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
        } else {
            TextView textView4 = this.createCountUnitView;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
        }
        Pair<String, String> a17 = companion.a(data.getSummary().friendNum);
        TextView textView5 = this.friendCountView;
        if (textView5 != null) {
            textView5.setText(a17.getFirst());
        }
        if (a17.getSecond().length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            TextView textView6 = this.friendCountUnitView;
            if (textView6 != null) {
                textView6.setText(a17.getSecond());
            }
            TextView textView7 = this.friendCountUnitView;
            if (textView7 != null) {
                textView7.setVisibility(0);
            }
        } else {
            TextView textView8 = this.friendCountUnitView;
            if (textView8 != null) {
                textView8.setVisibility(8);
            }
        }
        Pair<String, String> a18 = companion.a(data.getSummary().msgNum);
        TextView textView9 = this.messageCountView;
        if (textView9 != null) {
            textView9.setText(a18.getFirst());
        }
        if (a18.getSecond().length() <= 0) {
            z18 = false;
        }
        if (z18) {
            TextView textView10 = this.messageCountUnitView;
            if (textView10 != null) {
                textView10.setText(a18.getSecond());
            }
            TextView textView11 = this.messageCountUnitView;
            if (textView11 != null) {
                textView11.setVisibility(0);
            }
        } else {
            TextView textView12 = this.messageCountUnitView;
            if (textView12 != null) {
                textView12.setVisibility(8);
            }
        }
        TextView textView13 = this.userNameView;
        if (textView13 != null) {
            textView13.setText(data.getSelfNick());
        }
        a(String.valueOf(data.getSelfUin()));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieCreateCenterInfoView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AdelieCreateCenterInfoView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieCreateCenterInfoView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.dsa, this);
        this.userIconView = (QQProAvatarView) findViewById(R.id.klf);
        this.userNameView = (TextView) findViewById(R.id.km_);
        this.createCountView = (TextView) findViewById(R.id.uat);
        this.friendCountView = (TextView) findViewById(R.id.vet);
        this.messageCountView = (TextView) findViewById(R.id.z5d);
        this.createCountUnitView = (TextView) findViewById(R.id.uau);
        this.friendCountUnitView = (TextView) findViewById(R.id.veu);
        this.messageCountUnitView = (TextView) findViewById(R.id.z5e);
        this.userInfoView = (LinearLayout) findViewById(R.id.tqb);
        QQProAvatarView qQProAvatarView = this.userIconView;
        if (qQProAvatarView != null) {
            qQProAvatarView.setEnableFrame(am.a(1.0f), -1);
        }
    }
}
