package com.tencent.timi.game.profile.impl.view.record;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import co4.b;
import co4.d;
import com.tencent.av.utils.ba;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.timi.game.ui.widget.rc.RCImageView;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.utils.l;
import fh4.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pm4.a;
import tl.h;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.GameDataServerOuterClass$SmobaLadderGrade;
import trpc.yes.common.GameRoleOuterClass$SmobaGameRoleInfo;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010D\u001a\u00020C\u00a2\u0006\u0004\bE\u0010FB\u001b\b\u0016\u0012\u0006\u0010D\u001a\u00020C\u0012\b\u0010H\u001a\u0004\u0018\u00010G\u00a2\u0006\u0004\bE\u0010IB#\b\u0016\u0012\u0006\u0010D\u001a\u00020C\u0012\b\u0010H\u001a\u0004\u0018\u00010G\u0012\u0006\u0010J\u001a\u00020\n\u00a2\u0006\u0004\bE\u0010KJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u001a\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\"\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00020\nH\u0002J\b\u0010\u0014\u001a\u00020\nH\u0002J\"\u0010\u0018\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\bH\u0002J\"\u0010\u0019\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J\u0010\u0010\u001c\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001dJ\b\u0010 \u001a\u0004\u0018\u00010\u001aJ\u0016\u0010#\u001a\u00020\u0003*\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\bH\u0004J\b\u0010$\u001a\u00020\u0003H\u0014J\b\u0010%\u001a\u00020\u0003H\u0014J\b\u0010&\u001a\u00020\u0003H&J\b\u0010'\u001a\u00020\u0005H\u0016J\b\u0010(\u001a\u00020\u0003H\u0016J\b\u0010)\u001a\u00020\u0003H\u0016J\b\u0010*\u001a\u00020\u0003H\u0016J\u0012\u0010,\u001a\u00020\u00032\b\u0010+\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010-\u001a\u0004\u0018\u00010\bJ\b\u0010.\u001a\u00020\bH\u0004J\b\u0010/\u001a\u00020\bH\u0004J\u0010\u00100\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\nH\u0004J \u00104\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u00152\u0006\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u00020\u0015H\u0004J\u001c\u00108\u001a\u00020\u00032\b\u00105\u001a\u0004\u0018\u00010\u00152\b\u00107\u001a\u0004\u0018\u000106H\u0004R\u0018\u0010;\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010=R\u0014\u0010A\u001a\u00020\b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010B\u001a\u00020\b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b/\u0010@\u00a8\u0006L"}, d2 = {"Lcom/tencent/timi/game/profile/impl/view/record/BaseProfileSmobaRecordView;", "Landroid/widget/RelativeLayout;", "Lco4/b;", "", "r", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "", "l", "", "k", "Landroid/widget/TextView;", "textView", "Landroid/text/SpannableString;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "content", ReportConstant.COSTREPORT_PREFIX, "number", "o", "j", "Landroid/view/View;", "view", "titleResId", "w", "v", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "userId", "setUserId", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", ITVKPlayerEventListener.KEY_USER_INFO, "setUserInfo", "p", "Landroid/widget/ImageView;", "url", "y", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "t", "c", "b", "a", "d", "allUserInfoModel", "e", "g", "i", h.F, DomainData.DOMAIN_NAME, "firstDescribeItem", "secondDescribeItem", "thirdDescribeItem", "u", "heroListNullText", "Landroid/widget/LinearLayout;", "roleLinear", HippyTKDListViewAdapter.X, "Lco4/d;", "Lco4/d;", "userInfoViewWrapper", "Ltrpc/yes/common/GameRoleOuterClass$SmobaGameRoleInfo;", "Ltrpc/yes/common/GameRoleOuterClass$SmobaGameRoleInfo;", "smobaGameRoleExtInfo", "f", "Ljava/lang/String;", "smobaHeroBaseUrl", "levelUrl", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public abstract class BaseProfileSmobaRecordView extends RelativeLayout implements b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d userInfoViewWrapper;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GameRoleOuterClass$SmobaGameRoleInfo smobaGameRoleExtInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String smobaHeroBaseUrl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String levelUrl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseProfileSmobaRecordView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.smobaHeroBaseUrl = "https://cdn.yes.qq.com/smoba/hero/";
        this.levelUrl = "https://cdn.yes.qq.com/smoba/level/";
        r();
    }

    private final int j() {
        int i3;
        PBUInt32Field pBUInt32Field;
        PBUInt32Field pBUInt32Field2;
        GameRoleOuterClass$SmobaGameRoleInfo gameRoleOuterClass$SmobaGameRoleInfo = this.smobaGameRoleExtInfo;
        int i16 = 0;
        if (gameRoleOuterClass$SmobaGameRoleInfo != null && (pBUInt32Field2 = gameRoleOuterClass$SmobaGameRoleInfo.win_mvp) != null) {
            i3 = pBUInt32Field2.get();
        } else {
            i3 = 0;
        }
        GameRoleOuterClass$SmobaGameRoleInfo gameRoleOuterClass$SmobaGameRoleInfo2 = this.smobaGameRoleExtInfo;
        if (gameRoleOuterClass$SmobaGameRoleInfo2 != null && (pBUInt32Field = gameRoleOuterClass$SmobaGameRoleInfo2.lose_mvp) != null) {
            i16 = pBUInt32Field.get();
        }
        return i3 + i16;
    }

    private final int k() {
        int i3;
        PBUInt32Field pBUInt32Field;
        PBUInt32Field pBUInt32Field2;
        GameRoleOuterClass$SmobaGameRoleInfo gameRoleOuterClass$SmobaGameRoleInfo = this.smobaGameRoleExtInfo;
        int i16 = 0;
        if (gameRoleOuterClass$SmobaGameRoleInfo != null && (pBUInt32Field2 = gameRoleOuterClass$SmobaGameRoleInfo.win_num) != null) {
            i3 = pBUInt32Field2.get();
        } else {
            i3 = 0;
        }
        GameRoleOuterClass$SmobaGameRoleInfo gameRoleOuterClass$SmobaGameRoleInfo2 = this.smobaGameRoleExtInfo;
        if (gameRoleOuterClass$SmobaGameRoleInfo2 != null && (pBUInt32Field = gameRoleOuterClass$SmobaGameRoleInfo2.lose_num) != null) {
            i16 = pBUInt32Field.get();
        }
        return i3 + i16;
    }

    private final List<String> l() {
        PBRepeatField<Integer> pBRepeatField;
        List<Integer> list;
        ArrayList arrayList = new ArrayList();
        GameRoleOuterClass$SmobaGameRoleInfo gameRoleOuterClass$SmobaGameRoleInfo = this.smobaGameRoleExtInfo;
        if (gameRoleOuterClass$SmobaGameRoleInfo != null && (pBRepeatField = gameRoleOuterClass$SmobaGameRoleInfo.display_hero_list) != null && (list = pBRepeatField.get()) != null) {
            for (Integer num : list) {
                arrayList.add(this.smobaHeroBaseUrl + num);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0014, code lost:
    
        r0 = kotlin.math.MathKt__MathJVMKt.roundToInt((r0 * 10000.0d) / r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final SpannableString m(TextView textView) {
        int i3;
        int roundToInt;
        PBUInt32Field pBUInt32Field;
        GameRoleOuterClass$SmobaGameRoleInfo gameRoleOuterClass$SmobaGameRoleInfo = this.smobaGameRoleExtInfo;
        if (gameRoleOuterClass$SmobaGameRoleInfo != null && (pBUInt32Field = gameRoleOuterClass$SmobaGameRoleInfo.win_num) != null) {
            i3 = pBUInt32Field.get();
        } else {
            i3 = 0;
        }
        int k3 = k();
        if (k3 > 0 && roundToInt > 0) {
            return s(roundToInt, textView);
        }
        return new SpannableString("--");
    }

    private final SpannableString o(String content, TextView textView, int number) {
        SpannableString spannableString = new SpannableString(content);
        if (content.length() > number && textView != null) {
            spannableString.setSpan(new AbsoluteSizeSpan((int) textView.getTextSize()), 0, content.length() - number, 33);
            spannableString.setSpan(new AbsoluteSizeSpan((int) ba.dp2px(getContext(), 12.0f)), content.length() - number, content.length(), 33);
        }
        return spannableString;
    }

    private final boolean q() {
        String str;
        PBStringField pBStringField;
        GameRoleOuterClass$SmobaGameRoleInfo gameRoleOuterClass$SmobaGameRoleInfo = this.smobaGameRoleExtInfo;
        if (gameRoleOuterClass$SmobaGameRoleInfo != null && (pBStringField = gameRoleOuterClass$SmobaGameRoleInfo.role_name) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        return !TextUtils.isEmpty(str);
    }

    private final void r() {
        this.userInfoViewWrapper = ((bo4.d) mm4.b.b(bo4.d.class)).n2(this);
    }

    private final SpannableString s(int content, TextView textView) {
        if (content % 100 == 0) {
            return o((content / 100) + "%", textView, 1);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(content / 100.0f)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return o(format + "%", textView, 3);
    }

    private final void v(View view, int titleResId, SpannableString content) {
        TextView textView;
        TextView textView2;
        if (view != null && (textView2 = (TextView) view.findViewById(R.id.xse)) != null) {
            textView2.setText(titleResId);
        }
        if (view != null && (textView = (TextView) view.findViewById(R.id.xsc)) != null) {
            textView.setText(content);
        }
    }

    private final void w(View view, int titleResId, String content) {
        TextView textView;
        TextView textView2;
        if (view != null && (textView2 = (TextView) view.findViewById(R.id.xse)) != null) {
            textView2.setText(titleResId);
        }
        if (view != null && (textView = (TextView) view.findViewById(R.id.xsc)) != null) {
            textView.setText(content);
        }
    }

    @Override // co4.b
    public boolean c() {
        if (p() == null) {
            return true;
        }
        return false;
    }

    @Override // co4.b
    public void d() {
        a();
    }

    @Override // co4.b
    public void e(@Nullable IUserInfo allUserInfoModel) {
        GameRoleOuterClass$SmobaGameRoleInfo gameRoleOuterClass$SmobaGameRoleInfo;
        if (allUserInfoModel != null) {
            gameRoleOuterClass$SmobaGameRoleInfo = allUserInfoModel.g();
        } else {
            gameRoleOuterClass$SmobaGameRoleInfo = null;
        }
        this.smobaGameRoleExtInfo = gameRoleOuterClass$SmobaGameRoleInfo;
        g.o(this, q());
        t();
    }

    @Nullable
    public final String g() {
        PBRepeatField<Integer> pBRepeatField;
        List<Integer> list;
        GameRoleOuterClass$SmobaGameRoleInfo gameRoleOuterClass$SmobaGameRoleInfo = this.smobaGameRoleExtInfo;
        if (gameRoleOuterClass$SmobaGameRoleInfo != null && (pBRepeatField = gameRoleOuterClass$SmobaGameRoleInfo.display_branch_list) != null && (list = pBRepeatField.get()) != null && list.size() > 0) {
            a aVar = (a) mm4.b.b(a.class);
            Integer num = list.get(0);
            Intrinsics.checkNotNullExpressionValue(num, "it[0]");
            return aVar.w0(num.intValue());
        }
        return "--";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final String h() {
        PBUInt32Field pBUInt32Field;
        String str;
        PBStringField pBStringField;
        GameRoleOuterClass$SmobaGameRoleInfo gameRoleOuterClass$SmobaGameRoleInfo = this.smobaGameRoleExtInfo;
        if (gameRoleOuterClass$SmobaGameRoleInfo != null && (pBUInt32Field = gameRoleOuterClass$SmobaGameRoleInfo.disp_grade_level) != null) {
            GameDataServerOuterClass$SmobaLadderGrade T = ((a) mm4.b.b(a.class)).T(pBUInt32Field.get());
            if (T != null && (pBStringField = T.grade_level_name) != null) {
                str = pBStringField.get();
            } else {
                str = null;
            }
            if (str == null) {
                return "";
            }
            Intrinsics.checkNotNullExpressionValue(str, "ladderGradeConf?.grade_level_name?.get() ?: \"\"");
            return str;
        }
        l.e("BaseProfileSmobaRecordView", "acquireLevelName error ");
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final String i() {
        PBUInt32Field pBUInt32Field;
        GameRoleOuterClass$SmobaGameRoleInfo gameRoleOuterClass$SmobaGameRoleInfo = this.smobaGameRoleExtInfo;
        if (gameRoleOuterClass$SmobaGameRoleInfo != null && (pBUInt32Field = gameRoleOuterClass$SmobaGameRoleInfo.disp_grade_level) != null) {
            int i3 = pBUInt32Field.get();
            return this.levelUrl + i3 + "_b";
        }
        l.e("BaseProfileSmobaRecordView", "acquireLevelUrl error ");
        return "";
    }

    @NotNull
    protected final String n(int content) {
        if (content != 0) {
            return String.valueOf(content);
        }
        return "--";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d dVar = this.userInfoViewWrapper;
        if (dVar != null) {
            dVar.e();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d dVar = this.userInfoViewWrapper;
        if (dVar != null) {
            dVar.f();
        }
    }

    @Nullable
    public final CommonOuterClass$QQUserId p() {
        d dVar = this.userInfoViewWrapper;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    public final void setUserId(@Nullable CommonOuterClass$QQUserId userId) {
        d dVar = this.userInfoViewWrapper;
        if (dVar != null) {
            dVar.g(userId);
        }
    }

    public final void setUserInfo(@NotNull IUserInfo userInfo) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        e(userInfo);
    }

    public abstract void t();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void u(@NotNull View firstDescribeItem, @NotNull View secondDescribeItem, @NotNull View thirdDescribeItem) {
        Intrinsics.checkNotNullParameter(firstDescribeItem, "firstDescribeItem");
        Intrinsics.checkNotNullParameter(secondDescribeItem, "secondDescribeItem");
        Intrinsics.checkNotNullParameter(thirdDescribeItem, "thirdDescribeItem");
        w(firstDescribeItem, R.string.f2314071r, n(k()));
        v(secondDescribeItem, R.string.f2314171s, m((TextView) secondDescribeItem.findViewById(R.id.xsc)));
        w(thirdDescribeItem, R.string.f2313971q, n(j()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void x(@Nullable View heroListNullText, @Nullable LinearLayout roleLinear) {
        List<String> l3 = l();
        if (l3.isEmpty()) {
            if (heroListNullText != null) {
                g.o(heroListNullText, true);
            }
            if (roleLinear != null) {
                g.o(roleLinear, false);
                return;
            }
            return;
        }
        if (heroListNullText != null) {
            g.o(heroListNullText, false);
        }
        if (roleLinear != null) {
            g.o(roleLinear, true);
        }
        if (roleLinear != null) {
            roleLinear.removeAllViews();
        }
        int dp2px = (int) ba.dp2px(getContext(), 2.0f);
        int dp2px2 = (int) ba.dp2px(getContext(), 24.0f);
        int dp2px3 = (int) ba.dp2px(getContext(), 4.0f);
        for (String str : l3) {
            RCImageView rCImageView = new RCImageView(getContext());
            rCImageView.setRadius(dp2px3);
            y(rCImageView, str);
            rCImageView.setPadding(dp2px, dp2px, dp2px, dp2px);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(dp2px2, dp2px2);
            if (roleLinear != null) {
                roleLinear.addView(rCImageView, layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void y(@NotNull ImageView imageView, @Nullable String str) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        if (!TextUtils.isEmpty(str)) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = new ColorDrawable(0);
            obtain.mFailedDrawable = new ColorDrawable(0);
            if (imageView.getMeasuredWidth() > 0) {
                obtain.mRequestWidth = imageView.getMeasuredWidth();
                obtain.mRequestHeight = imageView.getMeasuredHeight();
            }
            try {
                imageView.setImageDrawable(((ei4.a) mm4.b.b(ei4.a.class)).m(str, obtain));
            } catch (IllegalArgumentException e16) {
                l.e("BaseProfileSmobaRecordView", "setImageDrawable error " + e16);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseProfileSmobaRecordView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.smobaHeroBaseUrl = "https://cdn.yes.qq.com/smoba/hero/";
        this.levelUrl = "https://cdn.yes.qq.com/smoba/level/";
        r();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseProfileSmobaRecordView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.smobaHeroBaseUrl = "https://cdn.yes.qq.com/smoba/hero/";
        this.levelUrl = "https://cdn.yes.qq.com/smoba/level/";
        r();
    }

    @Override // co4.b
    public void a() {
    }

    @Override // co4.b
    public void b() {
    }
}
