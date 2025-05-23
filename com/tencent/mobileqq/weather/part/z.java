package com.tencent.mobileqq.weather.part;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.weather.event.WeatherScrollStateChanged;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 92\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001FB\u0007\u00a2\u0006\u0004\bD\u0010EJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\u0012\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014J*\u0010\u001a\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0014J\u0012\u0010\u001c\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001e0\u001dH\u0016J\b\u0010 \u001a\u00020\u0005H\u0016R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u0016\u00102\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u0010'R\u0016\u00103\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010'R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R&\u0010>\u001a\u0012\u0012\u0004\u0012\u0002040\u001dj\b\u0012\u0004\u0012\u000204`;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u00109R\u0016\u0010C\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010B\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/weather/part/z;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/mobileqq/weather/data/k;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "v", "", "isClick", "B", BdhLogUtil.LogTag.Tag_Conn, "like", "Landroid/graphics/drawable/Drawable;", "u", "t", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", "w", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroidx/cardview/widget/CardView;", "d", "Landroidx/cardview/widget/CardView;", "mCardContainer", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "mDesc", "f", "mAuthor", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "mLike", "i", "mRefreshIcon", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mRefreshText", "mLikeNum", "Lcom/tencent/mobileqq/weather/data/m;", "D", "Lcom/tencent/mobileqq/weather/data/m;", "mCurrentData", "E", "I", "mIndex", "Lkotlin/collections/ArrayList;", UserInfo.SEX_FEMALE, "Ljava/util/ArrayList;", "mDataList", "G", "mPagePos", "H", "Z", "mHasBindData", "<init>", "()V", "a", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class z extends Section<com.tencent.mobileqq.weather.data.k> implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private TextView mLikeNum;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.weather.data.m mCurrentData;

    /* renamed from: E, reason: from kotlin metadata */
    private int mIndex;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private ArrayList<com.tencent.mobileqq.weather.data.m> mDataList;

    /* renamed from: G, reason: from kotlin metadata */
    private int mPagePos;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean mHasBindData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private CardView mCardContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView mDesc;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mAuthor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView mLike;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView mRefreshIcon;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView mRefreshText;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/weather/part/z$a;", "", "", "AUTHOR_PART", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.weather.part.z$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42860);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mIndex = -1;
            this.mDataList = new ArrayList<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(z this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void B(boolean isClick) {
        com.tencent.mobileqq.weather.data.m mVar;
        if (!isClick && this.mHasBindData) {
            return;
        }
        this.mHasBindData = true;
        if (this.mDataList.size() == 0) {
            return;
        }
        if (this.mIndex == this.mDataList.size() - 1) {
            this.mIndex = -1;
        }
        int i3 = this.mIndex + 1;
        this.mIndex = i3;
        this.mCurrentData = this.mDataList.get(i3);
        C();
        if (isClick && (mVar = this.mCurrentData) != null) {
            com.tencent.mobileqq.weather.util.report.n.f313689a.c(String.valueOf(mVar.d()), mVar.g(), mVar.a(), this.mPagePos);
        }
    }

    private final void C() {
        com.tencent.mobileqq.weather.data.m mVar = this.mCurrentData;
        if (mVar != null) {
            TextView textView = this.mDesc;
            ImageView imageView = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDesc");
                textView = null;
            }
            textView.setText(mVar.b());
            TextView textView2 = this.mAuthor;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAuthor");
                textView2 = null;
            }
            textView2.setText("-" + mVar.a() + "-");
            TextView textView3 = this.mLikeNum;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLikeNum");
                textView3 = null;
            }
            textView3.setText(String.valueOf(mVar.f()));
            ImageView imageView2 = this.mLike;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLike");
            } else {
                imageView = imageView2;
            }
            imageView.setImageDrawable(u(mVar.c()));
        }
    }

    private final void t() {
        if (com.tencent.mobileqq.weather.util.b.g()) {
            TextView textView = this.mDesc;
            CardView cardView = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDesc");
                textView = null;
            }
            textView.setTextColor(-1);
            TextView textView2 = this.mAuthor;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAuthor");
                textView2 = null;
            }
            textView2.setTextColor(-1);
            CardView cardView2 = this.mCardContainer;
            if (cardView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCardContainer");
            } else {
                cardView = cardView2;
            }
            cardView.setCardBackgroundColor(Color.parseColor("#1A1A1A"));
        }
    }

    private final Drawable u(boolean like) {
        int i3;
        Context context = this.mRootView.getContext();
        if (like) {
            i3 = R.drawable.nix;
        } else {
            i3 = R.drawable.nj7;
        }
        return context.getDrawable(i3);
    }

    private final void v() {
        com.tencent.mobileqq.weather.data.m mVar = this.mCurrentData;
        if (mVar != null) {
            if (mVar.c()) {
                mVar.h(false);
                mVar.i(mVar.f() - 1);
                com.tencent.mobileqq.weather.util.report.n.f313689a.e(String.valueOf(mVar.d()), mVar.g(), mVar.a(), false, this.mPagePos);
            } else {
                mVar.h(true);
                mVar.i(mVar.f() + 1);
                com.tencent.mobileqq.weather.util.report.n.f313689a.e(String.valueOf(mVar.d()), mVar.g(), mVar.a(), true, this.mPagePos);
            }
            C();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(z this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.B(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(z this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.B(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(z this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(WeatherScrollStateChanged.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 6, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new int[]{R.id.f11912760};
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            SimpleEventBus.getInstance().unRegisterReceiver(this);
            super.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) containerView);
            return;
        }
        if (containerView != null) {
            View findViewById = containerView.findViewById(R.id.f121397b5);
            Intrinsics.checkNotNullExpressionValue(findViewById, "it.findViewById(R.id.weather_quote_card_container)");
            this.mCardContainer = (CardView) findViewById;
            View findViewById2 = containerView.findViewById(R.id.f121417b7);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "it.findViewById(R.id.weather_quote_desc)");
            this.mDesc = (TextView) findViewById2;
            View findViewById3 = containerView.findViewById(R.id.f121387b4);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "it.findViewById(R.id.weather_quote_author)");
            this.mAuthor = (TextView) findViewById3;
            View findViewById4 = containerView.findViewById(R.id.f121447b_);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "it.findViewById(R.id.weather_quote_like_num)");
            this.mLikeNum = (TextView) findViewById4;
            View findViewById5 = containerView.findViewById(R.id.f121437b9);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "it.findViewById(R.id.weather_quote_like_img)");
            this.mLike = (ImageView) findViewById5;
            View findViewById6 = containerView.findViewById(R.id.f121467bb);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "it.findViewById(R.id.weather_quote_refresh_img)");
            this.mRefreshIcon = (ImageView) findViewById6;
            View findViewById7 = containerView.findViewById(R.id.f121457ba);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "it.findViewById(R.id.weather_quote_refresh)");
            this.mRefreshText = (TextView) findViewById7;
        }
        t();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        com.tencent.mobileqq.weather.data.m mVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) event);
            return;
        }
        if (!(event instanceof WeatherScrollStateChanged) || ((WeatherScrollStateChanged) event).getPagePosition() != this.mPagePos) {
            return;
        }
        QLog.d("WeatherQuoteSection", 1, "WeatherScrollStateChanged");
        CardView cardView = this.mCardContainer;
        if (cardView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardContainer");
            cardView = null;
        }
        if (GdtUIUtils.getPercentageOfGlobalVisibleRect(cardView) > 0.10000000149011612d && (mVar = this.mCurrentData) != null) {
            com.tencent.mobileqq.weather.util.report.n.f313689a.d(String.valueOf(mVar.d()), mVar.g(), mVar.a(), this.mPagePos);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable com.tencent.mobileqq.weather.data.k data, int position, @Nullable List<Object> payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, data, Integer.valueOf(position), payload);
            return;
        }
        if (data instanceof com.tencent.mobileqq.weather.data.l) {
            com.tencent.mobileqq.weather.data.l lVar = (com.tencent.mobileqq.weather.data.l) data;
            this.mPagePos = lVar.a();
            this.mDataList = lVar.e();
            B(false);
            ImageView imageView = this.mRefreshIcon;
            TextView textView = null;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRefreshIcon");
                imageView = null;
            }
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.weather.part.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    z.x(z.this, view);
                }
            });
            TextView textView2 = this.mRefreshText;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRefreshText");
                textView2 = null;
            }
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.weather.part.w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    z.y(z.this, view);
                }
            });
            ImageView imageView2 = this.mLike;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLike");
                imageView2 = null;
            }
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.weather.part.x
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    z.z(z.this, view);
                }
            });
            TextView textView3 = this.mLikeNum;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLikeNum");
            } else {
                textView = textView3;
            }
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.weather.part.y
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    z.A(z.this, view);
                }
            });
        }
    }
}
