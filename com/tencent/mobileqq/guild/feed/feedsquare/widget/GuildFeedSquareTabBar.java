package com.tencent.mobileqq.guild.feed.feedsquare.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.feed.feedsquare.fragment.GuildFeedCreateNewSectionFragment;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 J2\u00020\u0001:\u0001KB\u001b\u0012\u0006\u0010E\u001a\u00020D\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010F\u00a2\u0006\u0004\bH\u0010IJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0014\u0010\u0014\u001a\u00020\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J \u0010\u001b\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019J\b\u0010\u001c\u001a\u00020\nH\u0014J\u001a\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0015H\u0014J\"\u0010!\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00152\u0006\u0010 \u001a\u00020\nH\u0016J\u001a\u0010\"\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0015H\u0016J\u0006\u0010#\u001a\u00020\u0002J\u0010\u0010%\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\nH\u0014J\u0010\u0010&\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\nH\u0014J\b\u0010'\u001a\u00020\u0002H\u0016R\u0018\u0010*\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R$\u00100\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u00101R\u0018\u00105\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010<\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010;R(\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00120=8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b7\u0010@\"\u0004\bA\u0010B\u00a8\u0006L"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/GuildFeedSquareTabBar;", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "", "initPaint", "k", "e", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "l", "g", "", "childPos", "currentChosenPos", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", tl.h.F, "", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/l;", "list", "setData", "", "curGuildId", "Landroidx/fragment/app/Fragment;", "fragment", "", "squareCategoryId", "setParam", "getTabMargin", "position", "title", "addTab", "leftMargin", "f", "c", "j", "currentPos", "updateTextColor", "getUnderLineRect", "notifyDataSetChanged", "d", "Landroidx/fragment/app/Fragment;", "hostFragment", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "setGuildId", "(Ljava/lang/String;)V", "guildId", "J", "categoryId", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "hotTab", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "hotTabTv", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "hotTabIv", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "()Ljava/util/List;", "setSectionListData", "(Ljava/util/List;)V", "sectionListData", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "D", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class GuildFeedSquareTabBar extends QUIPageTabBar {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private List<com.tencent.mobileqq.guild.feed.feedsquare.data.l> sectionListData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Fragment hostFragment;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String guildId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long categoryId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout hotTab;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView hotTabTv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView hotTabIv;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/widget/GuildFeedSquareTabBar$b", "Lcom/tencent/mobileqq/guild/feed/feedsquare/fragment/GuildFeedCreateNewSectionFragment$b;", "", NodeProps.ON_CLICK, "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements GuildFeedCreateNewSectionFragment.b {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.fragment.GuildFeedCreateNewSectionFragment.b
        public void onClick() {
            GuildFeedSquareTabBar.this.g();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedSquareTabBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.sectionListData = new ArrayList();
        k();
        initPaint();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(GuildFeedSquareTabBar this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!FastClickUtils.isFastDoubleClick("GuildFeedSquareTabBar")) {
            this$0.j();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void e() {
        TextView textView;
        int i3;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.er6, (ViewGroup) this, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) inflate;
        this.hotTab = linearLayout;
        ImageView imageView = null;
        if (linearLayout != null) {
            textView = (TextView) linearLayout.findViewById(R.id.wem);
        } else {
            textView = null;
        }
        this.hotTabTv = textView;
        if (getCurrentPosition() == 0) {
            TextView textView2 = this.hotTabTv;
            if (textView2 != null) {
                textView2.setTextColor(this.mCheckedTextColor);
            }
            i3 = R.color.qui_common_brand_standard;
        } else {
            TextView textView3 = this.hotTabTv;
            if (textView3 != null) {
                textView3.setTextColor(this.mUncheckedTextColor);
            }
            i3 = R.color.qui_common_text_primary;
        }
        LinearLayout linearLayout2 = this.hotTab;
        if (linearLayout2 != null) {
            imageView = (ImageView) linearLayout2.findViewById(R.id.wel);
        }
        this.hotTabIv = imageView;
        if (imageView != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            imageView.setImageDrawable(GuildUIUtils.w(context, R.drawable.qui_arrow_down, Integer.valueOf(i3)));
        }
        setAccessibilityDelegate(this.hotTab);
        setTabClickListener(0, this.hotTab);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 17;
        layoutParams.leftMargin = ViewUtils.dpToPx(16.0f);
        layoutParams.rightMargin = getTabMargin();
        this.mTabContainer.addView(this.hotTab, 0, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        Fragment fragment = this.hostFragment;
        if (fragment != null) {
            ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).createBoardChannel(fragment.getChildFragmentManager(), this.guildId, "feed_square", this.categoryId);
        }
    }

    private final int[] h() {
        ImageView imageView;
        if (this.hotTab != null && this.hotTabTv != null && (imageView = this.hotTabIv) != null) {
            Intrinsics.checkNotNull(imageView);
            int width = imageView.getWidth();
            LinearLayout linearLayout = this.hotTab;
            Intrinsics.checkNotNull(linearLayout);
            int width2 = linearLayout.getWidth();
            int height = getHeight();
            Paint paint = this.mPaint;
            TextView textView = this.hotTabTv;
            Intrinsics.checkNotNull(textView);
            float measureText = paint.measureText(textView.getText().toString());
            LinearLayout linearLayout2 = this.hotTab;
            Intrinsics.checkNotNull(linearLayout2);
            int left = linearLayout2.getLeft() + (((int) ((width2 - measureText) - width)) / 2);
            LinearLayout linearLayout3 = this.hotTab;
            Intrinsics.checkNotNull(linearLayout3);
            int left2 = linearLayout3.getLeft() + ((int) measureText);
            int dip2px = (height / 2) + (ViewUtils.dip2px(15.0f) / 2) + ViewUtils.dpToPx(5.0f);
            return new int[]{left, dip2px, left2, ViewUtils.dpToPx(2.0f) + dip2px};
        }
        QLog.e("GuildFeedSquareTabBar", 1, "getUnderLineRect, currentTab is null!");
        return new int[]{0, 0, 0, 0};
    }

    private final void initPaint() {
        this.mPaint.setTextSize(ViewUtils.dip2px(15.0f));
    }

    private final void k() {
        this.mUncheckedTextColor = ie0.a.f().h(getContext(), R.color.qui_common_text_primary, 1000);
    }

    private final void l(FragmentManager fragmentManager) {
        String str = this.guildId;
        if (str != null) {
            fragmentManager.beginTransaction().add(new GuildFeedCreateNewSectionFragment(str, new b()), "GuildFeedCreateNewSectionFragment").commitAllowingStateLoss();
            bw.i1();
        }
    }

    private final void m(int childPos, int currentChosenPos) {
        TextView textView = this.hotTabTv;
        if (textView != null) {
            if (childPos == currentChosenPos) {
                textView.setTextColor(this.mCheckedTextColor);
            } else {
                textView.setTextColor(this.mUncheckedTextColor);
            }
        }
        ImageView imageView = this.hotTabIv;
        if (imageView != null) {
            if (childPos == currentChosenPos) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                imageView.setImageDrawable(GuildUIUtils.w(context, R.drawable.qui_arrow_down, Integer.valueOf(R.color.qui_common_brand_standard)));
            } else {
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                imageView.setImageDrawable(GuildUIUtils.w(context2, R.drawable.qui_arrow_down, Integer.valueOf(R.color.qui_common_text_primary)));
            }
        }
    }

    private final void n(int childPos, int currentChosenPos) {
        TextView textView;
        View childAt = this.mTabContainer.getChildAt(childPos);
        if (childAt instanceof TextView) {
            textView = (TextView) childAt;
        } else {
            textView = null;
        }
        if (textView != null) {
            if (childPos == currentChosenPos) {
                textView.setTextColor(this.mCheckedTextColor);
            } else {
                textView.setTextColor(this.mUncheckedTextColor);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public void addTab(int position, @Nullable String title) {
        if (position >= this.sectionListData.size()) {
            return;
        }
        int type = this.sectionListData.get(position).getSectionInfo().getType();
        if (type != 2) {
            if (type != 3) {
                if (type != 5) {
                    f(position, title, ViewUtils.dpToPx(24.0f));
                    return;
                } else {
                    f(position, title, ViewUtils.dpToPx(16.0f));
                    return;
                }
            }
            c(position, title);
            return;
        }
        e();
    }

    public void c(int position, @Nullable String title) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f168088er0, (ViewGroup) this, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) inflate;
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.weh);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        imageView.setImageDrawable(GuildUIUtils.w(context, R.drawable.qui_add, Integer.valueOf(R.color.qui_common_text_primary)));
        linearLayout.setPadding(0, 0, 0, 0);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.widget.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildFeedSquareTabBar.d(GuildFeedSquareTabBar.this, view);
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 17;
        layoutParams.rightMargin = getTabMargin();
        this.mTabContainer.addView(linearLayout, position, layoutParams);
    }

    public void f(int position, @Nullable String title, int leftMargin) {
        ColorStateList colorStateList;
        TextView textView = new TextView(getContext());
        textView.setFocusable(true);
        textView.setText(title);
        textView.setTextSize(15.0f);
        if (position == getCurrentPosition()) {
            colorStateList = this.mCheckedTextColor;
        } else {
            colorStateList = this.mUncheckedTextColor;
        }
        textView.setTextColor(colorStateList);
        textView.setGravity(17);
        textView.setPadding(0, 0, 0, 0);
        textView.setSingleLine();
        textView.setTag(Integer.valueOf(position));
        setAccessibilityDelegate(textView);
        setTabClickListener(position, textView);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 17;
        if (position == 0) {
            layoutParams.leftMargin = leftMargin;
        }
        layoutParams.rightMargin = getTabMargin();
        this.mTabContainer.addView(textView, position, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public int getTabMargin() {
        return ViewUtils.dpToPx(24.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    @NotNull
    public int[] getUnderLineRect(int position) {
        if (position >= 0 && position < this.sectionListData.size() && this.sectionListData.get(position).getSectionInfo().getType() == 2) {
            return h();
        }
        int[] underLineRect = super.getUnderLineRect(position);
        Intrinsics.checkNotNullExpressionValue(underLineRect, "super.getUnderLineRect(position)");
        return underLineRect;
    }

    @NotNull
    public final List<com.tencent.mobileqq.guild.feed.feedsquare.data.l> i() {
        return this.sectionListData;
    }

    public final void j() {
        Fragment fragment = this.hostFragment;
        if (fragment != null) {
            if (bw.x()) {
                g();
                return;
            }
            FragmentManager childFragmentManager = fragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "it.childFragmentManager");
            l(childFragmentManager);
            bw.b1();
        }
    }

    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public void notifyDataSetChanged() {
        boolean z16;
        String[] mTabTexts = this.mTabTexts;
        if (mTabTexts != null) {
            Intrinsics.checkNotNullExpressionValue(mTabTexts, "mTabTexts");
            if (mTabTexts.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                ViewPager2 viewPager2 = this.mViewPager2;
                if (viewPager2 != null && viewPager2.getAdapter() == null) {
                    QLog.e("GuildFeedSquareTabBar", 1, "tabTexts size not match viewPager2's size");
                    return;
                }
                this.mTabContainer.removeAllViews();
                int length = this.mTabTexts.length;
                this.mTabCount = length;
                for (int i3 = 0; i3 < length; i3++) {
                    addTab(i3, this.mTabTexts[i3]);
                }
                this.mAnimationStartX = 0;
                return;
            }
        }
        QLog.e("GuildFeedSquareTabBar", 1, "tabTexts is empty!");
    }

    public final void setData(@NotNull List<com.tencent.mobileqq.guild.feed.feedsquare.data.l> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.sectionListData.clear();
        this.sectionListData.addAll(list);
        ArrayList arrayList = new ArrayList();
        Iterator<com.tencent.mobileqq.guild.feed.feedsquare.data.l> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getSectionInfo().getName());
        }
        Object[] array = arrayList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        setTabData((String[]) array);
    }

    public final void setGuildId(@Nullable String str) {
        this.guildId = str;
    }

    public final void setParam(@Nullable String curGuildId, @NotNull Fragment fragment, long squareCategoryId) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.hostFragment = fragment;
        this.guildId = curGuildId;
        this.categoryId = squareCategoryId;
    }

    public final void setSectionListData(@NotNull List<com.tencent.mobileqq.guild.feed.feedsquare.data.l> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.sectionListData = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public void updateTextColor(int currentPos) {
        int childCount = this.mTabContainer.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (this.sectionListData.get(i3).getSectionInfo().getType() == 2) {
                m(i3, currentPos);
            } else {
                n(i3, currentPos);
            }
        }
    }
}
