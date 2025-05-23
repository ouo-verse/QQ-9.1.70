package o14;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqnt.kernel.nativeinterface.RobotRecommendCardInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotRecommendCardInfoType;
import com.tencent.robot.adelie.homepage.category.viewmodel.HotDelegateData;
import com.tencent.robot.adelie.homepage.utils.n;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u007f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\b*\u0001A\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001GB\u0007\u00a2\u0006\u0004\bE\u0010FJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J\u001a\u0010\u0011\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0014J*\u0010\u001d\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0014J\b\u0010\u001e\u001a\u00020\u0003H\u0016J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\bH\u0016R\u0018\u0010#\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\"R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00108\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u001e\u0010<\u001a\n\u0012\u0004\u0012\u00020:\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010C\u00a8\u0006H"}, d2 = {"Lo14/e;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/robot/adelie/homepage/category/viewmodel/d;", "", "y", "data", "G", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "w", HippyTKDListViewAdapter.X, "M", "K", "H", "Landroid/widget/TextView;", "textView", "select", "J", "L", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "", "position", "", "", "payload", "D", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "attached", "onAttachedChanged", "d", "Landroid/widget/TextView;", "weekHotTab", "e", "friendPlayTab", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "moreImageView", "Landroidx/viewpager2/widget/ViewPager2;", tl.h.F, "Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "Lo14/f;", "i", "Lo14/f;", "adapter", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotRecommendCardInfoType;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/kernel/nativeinterface/RobotRecommendCardInfoType;", "currentTab", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/robot/adelie/homepage/category/viewmodel/d;", "hotData", "Lmqq/util/WeakReference;", "Landroid/content/Context;", "Lmqq/util/WeakReference;", "weakContent", "Landroid/widget/RelativeLayout;", "E", "Landroid/widget/RelativeLayout;", "topBar", "o14/e$b", UserInfo.SEX_FEMALE, "Lo14/e$b;", "viewPageChangeListener", "<init>", "()V", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class e extends Section<HotDelegateData> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private HotDelegateData hotData;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private WeakReference<Context> weakContent;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private RelativeLayout topBar;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView weekHotTab;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView friendPlayTab;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView moreImageView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewPager2 viewPager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private f adapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RobotRecommendCardInfoType currentTab = RobotRecommendCardInfoType.KWEEKHOT;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final b viewPageChangeListener = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"o14/e$b", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b extends ViewPager2.OnPageChangeCallback {
        b() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            int i3;
            f fVar = e.this.adapter;
            if (fVar != null) {
                fVar.n0(Integer.valueOf(position));
            }
            f fVar2 = e.this.adapter;
            if (fVar2 != null) {
                i3 = fVar2.getHotPageCount();
            } else {
                i3 = 0;
            }
            if (position < i3) {
                e.this.K();
            } else {
                e.this.H();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(e this$0, View view) {
        int i3;
        Map mapOf;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("AdelieHomeHotAndFriendCardSection", 1, "friendPlayTab to click");
        RobotRecommendCardInfoType robotRecommendCardInfoType = this$0.currentTab;
        RobotRecommendCardInfoType robotRecommendCardInfoType2 = RobotRecommendCardInfoType.KFRIEDNHOT;
        if (robotRecommendCardInfoType != robotRecommendCardInfoType2) {
            this$0.H();
            f fVar = this$0.adapter;
            if (fVar != null) {
                i3 = fVar.getHotPageCount();
            } else {
                i3 = 0;
            }
            ViewPager2 viewPager2 = this$0.viewPager;
            if (viewPager2 != null) {
                viewPager2.setCurrentItem(i3);
            }
            this$0.currentTab = robotRecommendCardInfoType2;
            TextView textView = this$0.friendPlayTab;
            if (textView != null) {
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("tab_name", textView.getText()));
                VideoReport.reportEvent("clck", textView, mapOf);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0068, code lost:
    
        if (r4 == true) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void B(e this$0, View view) {
        String str;
        Map mapOf;
        Context context;
        int i3;
        boolean z16;
        ArrayList<RobotRecommendCardInfo> b16;
        Object last;
        ArrayList<RobotRecommendCardInfo> b17;
        ArrayList<RobotRecommendCardInfo> b18;
        Object first;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!u64.g.f438512a.g()) {
            HotDelegateData hotDelegateData = this$0.hotData;
            String str2 = null;
            if (hotDelegateData != null && (b18 = hotDelegateData.b()) != null) {
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) b18);
                RobotRecommendCardInfo robotRecommendCardInfo = (RobotRecommendCardInfo) first;
                if (robotRecommendCardInfo != null) {
                    str = robotRecommendCardInfo.jumpUrl;
                    if (this$0.currentTab == RobotRecommendCardInfoType.KFRIEDNHOT) {
                        HotDelegateData hotDelegateData2 = this$0.hotData;
                        boolean z17 = true;
                        if (hotDelegateData2 != null && (b17 = hotDelegateData2.b()) != null) {
                            i3 = b17.size();
                        } else {
                            i3 = 1;
                        }
                        if (i3 >= 2) {
                            HotDelegateData hotDelegateData3 = this$0.hotData;
                            if (hotDelegateData3 != null && (b16 = hotDelegateData3.b()) != null) {
                                last = CollectionsKt___CollectionsKt.last((List<? extends Object>) b16);
                                RobotRecommendCardInfo robotRecommendCardInfo2 = (RobotRecommendCardInfo) last;
                                if (robotRecommendCardInfo2 != null) {
                                    str2 = robotRecommendCardInfo2.jumpUrl;
                                }
                            }
                            if (str2 != null) {
                                if (str2.length() > 0) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                            }
                            z17 = false;
                            if (z17) {
                                str = str2;
                            }
                        }
                    }
                    if (str != null) {
                        WeakReference<Context> weakReference = this$0.weakContent;
                        if (weakReference != null && (context = weakReference.get()) != null) {
                            n nVar = n.f366680a;
                            Intrinsics.checkNotNullExpressionValue(context, "context");
                            nVar.f(context, str);
                        }
                        ImageView imageView = this$0.moreImageView;
                        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(MiniAppDesktopDtReportHelper.DT_MINI_PARENT_EID, "em_bas_top_recommendation_card"));
                        VideoReport.reportEvent("clck", imageView, mapOf);
                    }
                }
            }
            str = null;
            if (this$0.currentTab == RobotRecommendCardInfoType.KFRIEDNHOT) {
            }
            if (str != null) {
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(e this$0, View view) {
        Map mapOf;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("AdelieHomeHotAndFriendCardSection", 1, "weekHotTab to click");
        RobotRecommendCardInfoType robotRecommendCardInfoType = this$0.currentTab;
        RobotRecommendCardInfoType robotRecommendCardInfoType2 = RobotRecommendCardInfoType.KWEEKHOT;
        if (robotRecommendCardInfoType != robotRecommendCardInfoType2) {
            this$0.K();
            ViewPager2 viewPager2 = this$0.viewPager;
            if (viewPager2 != null) {
                viewPager2.setCurrentItem(0);
            }
            this$0.currentTab = robotRecommendCardInfoType2;
            TextView textView = this$0.weekHotTab;
            if (textView != null) {
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("tab_name", textView.getText()));
                VideoReport.reportEvent("clck", textView, mapOf);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(View page, float f16) {
        Intrinsics.checkNotNullParameter(page, "page");
        page.setTranslationX((-ViewUtils.dpToPx(28.0f)) * f16);
    }

    private final void G(HotDelegateData data) {
        ImageView imageView;
        this.hotData = data;
        f fVar = this.adapter;
        if (fVar != null) {
            fVar.o0(data);
        }
        ViewPager2 viewPager2 = this.viewPager;
        if (viewPager2 != null) {
            viewPager2.registerOnPageChangeCallback(this.viewPageChangeListener);
        }
        M();
        ImageView imageView2 = this.moreImageView;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        if (x() && (imageView = this.moreImageView) != null) {
            imageView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H() {
        RobotRecommendCardInfoType robotRecommendCardInfoType = this.currentTab;
        RobotRecommendCardInfoType robotRecommendCardInfoType2 = RobotRecommendCardInfoType.KFRIEDNHOT;
        if (robotRecommendCardInfoType == robotRecommendCardInfoType2) {
            return;
        }
        J(this.weekHotTab, false);
        J(this.friendPlayTab, true);
        this.currentTab = robotRecommendCardInfoType2;
    }

    private final void J(TextView textView, boolean select) {
        Context context;
        int g16;
        Typeface typeface;
        WeakReference<Context> weakReference = this.weakContent;
        if (weakReference != null && (context = weakReference.get()) != null) {
            if (select) {
                g16 = ie0.a.f().g(context, R.color.qui_common_brand_standard, 1000);
            } else {
                g16 = ie0.a.f().g(context, R.color.qui_common_text_primary, 1000);
            }
            if (textView != null) {
                textView.setTextColor(g16);
            }
            if (textView != null) {
                if (select) {
                    typeface = Typeface.DEFAULT_BOLD;
                } else {
                    typeface = Typeface.DEFAULT;
                }
                textView.setTypeface(typeface);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K() {
        RobotRecommendCardInfoType robotRecommendCardInfoType = this.currentTab;
        RobotRecommendCardInfoType robotRecommendCardInfoType2 = RobotRecommendCardInfoType.KWEEKHOT;
        if (robotRecommendCardInfoType == robotRecommendCardInfoType2) {
            return;
        }
        J(this.weekHotTab, true);
        J(this.friendPlayTab, false);
        this.currentTab = robotRecommendCardInfoType2;
    }

    private final void L() {
        Context context;
        WeakReference<Context> weakReference = this.weakContent;
        if (weakReference != null && (context = weakReference.get()) != null) {
            Drawable o16 = ie0.a.f().o(context, R.drawable.qui_chevron_right, R.color.qui_common_icon_primary, 1000);
            ImageView imageView = this.moreImageView;
            if (imageView != null) {
                imageView.setImageDrawable(o16);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void M() {
        String str;
        TextView textView;
        HotDelegateData hotDelegateData;
        TextView textView2;
        ArrayList<RobotRecommendCardInfo> b16;
        Object last;
        RobotRecommendCardInfo robotRecommendCardInfo;
        ArrayList<RobotRecommendCardInfo> b17;
        Object first;
        HotDelegateData hotDelegateData2 = this.hotData;
        String str2 = null;
        if (hotDelegateData2 != null && (b17 = hotDelegateData2.b()) != null) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) b17);
            RobotRecommendCardInfo robotRecommendCardInfo2 = (RobotRecommendCardInfo) first;
            if (robotRecommendCardInfo2 != null) {
                str = robotRecommendCardInfo2.name;
                String str3 = "";
                if (str == null) {
                    str = "";
                }
                textView = this.weekHotTab;
                if (textView != null) {
                    textView.setText(str);
                }
                hotDelegateData = this.hotData;
                if (hotDelegateData != null && (b16 = hotDelegateData.b()) != null) {
                    last = CollectionsKt___CollectionsKt.last((List<? extends Object>) b16);
                    robotRecommendCardInfo = (RobotRecommendCardInfo) last;
                    if (robotRecommendCardInfo != null) {
                        str2 = robotRecommendCardInfo.name;
                    }
                }
                if (str2 != null) {
                    str3 = str2;
                }
                textView2 = this.friendPlayTab;
                if (textView2 != null) {
                    textView2.setText(str3);
                }
                if (w()) {
                    TextView textView3 = this.friendPlayTab;
                    if (textView3 != null) {
                        textView3.setVisibility(8);
                    }
                    J(this.weekHotTab, false);
                    return;
                }
                return;
            }
        }
        str = null;
        String str32 = "";
        if (str == null) {
        }
        textView = this.weekHotTab;
        if (textView != null) {
        }
        hotDelegateData = this.hotData;
        if (hotDelegateData != null) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) b16);
            robotRecommendCardInfo = (RobotRecommendCardInfo) last;
            if (robotRecommendCardInfo != null) {
            }
        }
        if (str2 != null) {
        }
        textView2 = this.friendPlayTab;
        if (textView2 != null) {
        }
        if (w()) {
        }
    }

    private final boolean w() {
        int i3;
        ArrayList<RobotRecommendCardInfo> b16;
        HotDelegateData hotDelegateData = this.hotData;
        if (hotDelegateData != null && (b16 = hotDelegateData.b()) != null) {
            i3 = b16.size();
        } else {
            i3 = 1;
        }
        if (i3 >= 2) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean x() {
        String str;
        boolean z16;
        int i3;
        ArrayList<RobotRecommendCardInfo> b16;
        Object last;
        ArrayList<RobotRecommendCardInfo> b17;
        ArrayList<RobotRecommendCardInfo> b18;
        Object first;
        HotDelegateData hotDelegateData = this.hotData;
        String str2 = null;
        if (hotDelegateData != null && (b18 = hotDelegateData.b()) != null) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) b18);
            RobotRecommendCardInfo robotRecommendCardInfo = (RobotRecommendCardInfo) first;
            if (robotRecommendCardInfo != null) {
                str = robotRecommendCardInfo.jumpUrl;
                String str3 = "";
                if (str == null) {
                    str = "";
                }
                if (str.length() != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    HotDelegateData hotDelegateData2 = this.hotData;
                    if (hotDelegateData2 != null && (b17 = hotDelegateData2.b()) != null) {
                        i3 = b17.size();
                    } else {
                        i3 = 1;
                    }
                    if (i3 >= 2) {
                        HotDelegateData hotDelegateData3 = this.hotData;
                        if (hotDelegateData3 != null && (b16 = hotDelegateData3.b()) != null) {
                            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) b16);
                            RobotRecommendCardInfo robotRecommendCardInfo2 = (RobotRecommendCardInfo) last;
                            if (robotRecommendCardInfo2 != null) {
                                str2 = robotRecommendCardInfo2.jumpUrl;
                            }
                        }
                        if (str2 != null) {
                            str3 = str2;
                        }
                        str = str3;
                    }
                }
                if (str.length() > 0) {
                    return false;
                }
                return true;
            }
        }
        str = null;
        String str32 = "";
        if (str == null) {
        }
        if (str.length() != 0) {
        }
        if (z16) {
        }
        if (str.length() > 0) {
        }
    }

    private final void y() {
        VideoReport.setElementId(this.viewPager, "em_bas_top_recommendation_card");
        ViewPager2 viewPager2 = this.viewPager;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        VideoReport.setElementClickPolicy(viewPager2, clickPolicy);
        TextView textView = this.weekHotTab;
        if (textView != null) {
            VideoReport.setElementId(textView, "em_bas_top_tab");
            VideoReport.setElementClickPolicy(textView, clickPolicy);
        }
        TextView textView2 = this.friendPlayTab;
        if (textView2 != null) {
            VideoReport.setElementId(textView2, "em_bas_top_tab");
            VideoReport.setElementClickPolicy(textView2, clickPolicy);
        }
        ImageView imageView = this.moreImageView;
        if (imageView != null) {
            VideoReport.setElementId(imageView, "em_bas_top_right_arrow");
            VideoReport.setElementClickPolicy(imageView, clickPolicy);
        }
    }

    private final void z() {
        TextView textView = this.weekHotTab;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: o14.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.C(e.this, view);
                }
            });
        }
        TextView textView2 = this.friendPlayTab;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: o14.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.A(e.this, view);
                }
            });
        }
        ImageView imageView = this.moreImageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: o14.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.B(e.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable HotDelegateData data, int position, @Nullable List<Object> payload) {
        if (data != null) {
            G(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean attached) {
        Map mapOf;
        ImageView imageView;
        Map mapOf2;
        if (attached) {
            ViewPager2 viewPager2 = this.viewPager;
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("dt_pgid", "pg_bas_agent_home_page_new"));
            VideoReport.reportEvent("imp", viewPager2, mapOf);
            if (x() && (imageView = this.moreImageView) != null) {
                mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(MiniAppDesktopDtReportHelper.DT_MINI_PARENT_EID, "em_bas_top_recommendation_card"));
                VideoReport.reportEvent("imp", imageView, mapOf2);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        ViewPager2 viewPager2 = this.viewPager;
        if (viewPager2 != null) {
            viewPager2.unregisterOnPageChangeCallback(this.viewPageChangeListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        TextView textView;
        TextView textView2;
        ImageView imageView;
        RelativeLayout relativeLayout;
        Context context;
        if (containerView != null && (context = containerView.getContext()) != null) {
            this.weakContent = new WeakReference<>(context);
            FontSettingManager.resetViewSize2Normal(context, containerView);
        }
        ViewPager2 viewPager2 = null;
        if (containerView != null) {
            textView = (TextView) containerView.findViewById(R.id.f122167d8);
        } else {
            textView = null;
        }
        this.weekHotTab = textView;
        if (containerView != null) {
            textView2 = (TextView) containerView.findViewById(R.id.vfj);
        } else {
            textView2 = null;
        }
        this.friendPlayTab = textView2;
        if (containerView != null) {
            imageView = (ImageView) containerView.findViewById(R.id.f06);
        } else {
            imageView = null;
        }
        this.moreImageView = imageView;
        if (containerView != null) {
            relativeLayout = (RelativeLayout) containerView.findViewById(R.id.xbp);
        } else {
            relativeLayout = null;
        }
        this.topBar = relativeLayout;
        if (containerView != null) {
            viewPager2 = (ViewPager2) containerView.findViewById(R.id.xbx);
        }
        this.viewPager = viewPager2;
        f fVar = new f();
        this.adapter = fVar;
        ViewPager2 viewPager22 = this.viewPager;
        if (viewPager22 != null) {
            viewPager22.setAdapter(fVar);
        }
        ViewPager2 viewPager23 = this.viewPager;
        if (viewPager23 != null) {
            viewPager23.setClipToPadding(false);
        }
        ViewPager2 viewPager24 = this.viewPager;
        if (viewPager24 != null) {
            viewPager24.setClipChildren(false);
        }
        ViewPager2 viewPager25 = this.viewPager;
        if (viewPager25 != null) {
            viewPager25.setOffscreenPageLimit(1);
        }
        ViewPager2 viewPager26 = this.viewPager;
        if (viewPager26 != null) {
            viewPager26.setPageTransformer(new ViewPager2.PageTransformer() { // from class: o14.a
                @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
                public final void transformPage(View view, float f16) {
                    e.F(view, f16);
                }
            });
        }
        L();
        z();
        y();
    }
}
