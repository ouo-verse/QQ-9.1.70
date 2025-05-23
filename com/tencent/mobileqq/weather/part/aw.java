package com.tencent.mobileqq.weather.part;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 :2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001;B\u0007\u00a2\u0006\u0004\b8\u00109J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0014J\u0012\u0010\r\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014J*\u0010\u0013\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u00032\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010 R\u0018\u0010'\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010\u001aR\u0018\u0010)\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010\u001aR\u0018\u0010+\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010\u001aR\u0018\u0010-\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010\u001aR\u0018\u0010/\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010\u001aR\u0018\u00101\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010\u001aR\u0016\u00103\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/weather/part/aw;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/mobileqq/weather/data/k;", "", "index", "Lcom/tencent/mobileqq/weather/data/s;", "itemData", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "position", "", "", "payload", "p", "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", "mContainer", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "mWeatherText", "f", "mDateText", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "mLifeIndexIcon1", "i", "mLifeIndexIcon2", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mLifeIndexIcon3", BdhLogUtil.LogTag.Tag_Conn, "mLifeIndexContent1", "D", "mLifeIndexContent2", "E", "mLifeIndexContent3", UserInfo.SEX_FEMALE, "mLifeIndexName1", "G", "mLifeIndexName2", "H", "mLifeIndexName3", "I", "mPagePos", "Lcom/tencent/mobileqq/weather/data/r;", "J", "Lcom/tencent/mobileqq/weather/data/r;", "mNightCareData", "<init>", "()V", "K", "a", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class aw extends Section<com.tencent.mobileqq.weather.data.k> {
    static IPatchRedirector $redirector_;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TextView mLifeIndexContent1;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private TextView mLifeIndexContent2;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private TextView mLifeIndexContent3;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private TextView mLifeIndexName1;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private TextView mLifeIndexName2;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private TextView mLifeIndexName3;

    /* renamed from: I, reason: from kotlin metadata */
    private int mPagePos;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.weather.data.r mNightCareData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout mContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mWeatherText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mDateText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mLifeIndexIcon1;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mLifeIndexIcon2;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mLifeIndexIcon3;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/weather/part/aw$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.weather.part.aw$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43690);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public aw() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void q(int index, com.tencent.mobileqq.weather.data.s itemData) {
        if (index != 0) {
            if (index != 1) {
                if (index == 2) {
                    ImageView imageView = this.mLifeIndexIcon3;
                    if (imageView != null) {
                        imageView.setImageDrawable(com.tencent.mobileqq.weather.util.b.e(itemData.b()));
                    }
                    TextView textView = this.mLifeIndexContent3;
                    if (textView != null) {
                        textView.setText(itemData.a());
                    }
                    TextView textView2 = this.mLifeIndexName3;
                    if (textView2 != null) {
                        textView2.setText(itemData.c());
                        return;
                    }
                    return;
                }
                return;
            }
            ImageView imageView2 = this.mLifeIndexIcon2;
            if (imageView2 != null) {
                imageView2.setImageDrawable(com.tencent.mobileqq.weather.util.b.e(itemData.b()));
            }
            TextView textView3 = this.mLifeIndexContent2;
            if (textView3 != null) {
                textView3.setText(itemData.a());
            }
            TextView textView4 = this.mLifeIndexName2;
            if (textView4 != null) {
                textView4.setText(itemData.c());
                return;
            }
            return;
        }
        ImageView imageView3 = this.mLifeIndexIcon1;
        if (imageView3 != null) {
            imageView3.setImageDrawable(com.tencent.mobileqq.weather.util.b.e(itemData.b()));
        }
        TextView textView5 = this.mLifeIndexContent1;
        if (textView5 != null) {
            textView5.setText(itemData.a());
        }
        TextView textView6 = this.mLifeIndexName1;
        if (textView6 != null) {
            textView6.setText(itemData.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new int[]{R.id.f1193576m};
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
            this.mContainer = (FrameLayout) containerView.findViewById(R.id.f121807c9);
            this.mWeatherText = (TextView) containerView.findViewById(R.id.f121927ck);
            this.mDateText = (TextView) containerView.findViewById(R.id.f121817c_);
            this.mLifeIndexIcon1 = (ImageView) containerView.findViewById(R.id.f121867ce);
            this.mLifeIndexIcon2 = (ImageView) containerView.findViewById(R.id.f121877cf);
            this.mLifeIndexIcon3 = (ImageView) containerView.findViewById(R.id.f121887cg);
            this.mLifeIndexContent1 = (TextView) containerView.findViewById(R.id.f121837cb);
            this.mLifeIndexContent2 = (TextView) containerView.findViewById(R.id.f121847cc);
            this.mLifeIndexContent3 = (TextView) containerView.findViewById(R.id.f121857cd);
            this.mLifeIndexName1 = (TextView) containerView.findViewById(R.id.f121897ch);
            this.mLifeIndexName2 = (TextView) containerView.findViewById(R.id.f121907ci);
            this.mLifeIndexName3 = (TextView) containerView.findViewById(R.id.f121917cj);
        }
        com.tencent.mobileqq.weather.util.b.j(this.mContainer, 8.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable com.tencent.mobileqq.weather.data.k data, int position, @Nullable List<Object> payload) {
        FrameLayout frameLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, data, Integer.valueOf(position), payload);
            return;
        }
        if (!(data instanceof com.tencent.mobileqq.weather.data.q)) {
            return;
        }
        com.tencent.mobileqq.weather.data.q qVar = (com.tencent.mobileqq.weather.data.q) data;
        int a16 = qVar.a();
        this.mPagePos = a16;
        if (a16 != 0) {
            FrameLayout frameLayout2 = this.mContainer;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(8);
                return;
            }
            return;
        }
        com.tencent.mobileqq.weather.data.r e16 = qVar.e();
        this.mNightCareData = e16;
        if (e16 != null) {
            TextView textView = this.mWeatherText;
            if (textView != null) {
                textView.setText(e16.d());
            }
            TextView textView2 = this.mDateText;
            if (textView2 != null) {
                textView2.setText(e16.b());
            }
            if (!TextUtils.isEmpty(e16.d()) && !e16.c().isEmpty()) {
                if (!TextUtils.isEmpty(e16.a()) && (frameLayout = this.mContainer) != null) {
                    frameLayout.setBackgroundDrawable(com.tencent.mobileqq.weather.util.b.e(e16.a()));
                }
                Iterator<com.tencent.mobileqq.weather.data.s> it = e16.c().iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    q(i3, it.next());
                    i3++;
                }
                QLog.d("WeatherTomorrowCareSection", 1, "show");
                FrameLayout frameLayout3 = this.mContainer;
                if (frameLayout3 != null) {
                    frameLayout3.setVisibility(0);
                }
                com.tencent.mobileqq.weather.util.report.q.f313693a.c();
                return;
            }
            FrameLayout frameLayout4 = this.mContainer;
            if (frameLayout4 != null) {
                frameLayout4.setVisibility(8);
            }
        }
    }
}
