package com.tencent.mobileqq.activity.aio.intimate;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipConfProcessor;
import com.tencent.mobileqq.config.business.q;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.friends.intimate.IntimateInfoHandler;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageWrapper;
import com.tencent.widget.URLThemeImageView;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes10.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private LinearLayout f179141a;

    /* renamed from: b, reason: collision with root package name */
    public Context f179142b;

    /* renamed from: c, reason: collision with root package name */
    private String f179143c;

    /* renamed from: d, reason: collision with root package name */
    public String f179144d;

    /* renamed from: e, reason: collision with root package name */
    public String f179145e;

    /* renamed from: f, reason: collision with root package name */
    private c f179146f = new a();

    /* renamed from: g, reason: collision with root package name */
    private d f179147g = null;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements c {
        a() {
        }

        @Override // com.tencent.mobileqq.activity.aio.intimate.k.c
        public void a(View view, IntimateInfo.MemoryDayInfo memoryDayInfo) {
            if (k.this.f179141a != null) {
                int childCount = k.this.f179141a.getChildCount();
                if (childCount > 0) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= childCount) {
                            break;
                        }
                        Object tag = k.this.f179141a.getChildAt(i3).getTag();
                        if ((tag instanceof IntimateInfo.MemoryDayInfo) && ((IntimateInfo.MemoryDayInfo) tag).dateType == memoryDayInfo.dateType) {
                            k.this.f179141a.removeViewAt(i3);
                            break;
                        }
                        i3++;
                    }
                }
                if (k.this.f179141a.getChildCount() <= 0) {
                    k.this.f179141a.setVisibility(8);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        private View f179149a;

        /* renamed from: b, reason: collision with root package name */
        private IntimateInfo.MemoryDayInfo f179150b = null;

        /* renamed from: c, reason: collision with root package name */
        private c f179151c = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes10.dex */
        public class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long j3;
                EventCollector.getInstance().onViewClickedBefore(view);
                if (b.this.f179150b != null) {
                    QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                    int i3 = b.this.f179150b.jumpType;
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ReportController.o(null, "dc00898", "", "", "0X800A208 ", "0X800A208 ", b.this.f179150b.dateType, 0, "", "", "", "");
                            QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A208");
                            if (k.this.f179147g != null) {
                                k.this.f179147g.a(b.this.f179150b);
                            }
                        }
                    } else {
                        if (b.this.f179150b.linkUrl != null) {
                            b bVar = b.this;
                            if (k.this.f179142b != null) {
                                ReportController.o(null, "dc00898", "", "", "0X800A208 ", "0X800A208 ", bVar.f179150b.dateType, 0, "", "", "", "");
                                QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A208");
                                b bVar2 = b.this;
                                ax c16 = bi.c(qQAppInterface, k.this.f179142b, bVar2.f179150b.linkUrl);
                                if (c16 != null) {
                                    c16.b();
                                } else if (b.this.f179150b.linkUrl.toLowerCase().startsWith("mqzone://")) {
                                    b bVar3 = b.this;
                                    QZoneHelper.onMQzoneSchema(k.this.f179142b, bVar3.f179150b.linkUrl);
                                } else {
                                    b bVar4 = b.this;
                                    k.h(k.this.f179142b, bVar4.f179150b.linkUrl);
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.d("intimate_relationship", 2, "click  scheme: " + b.this.f179150b.linkUrl);
                                }
                            }
                        }
                        QLog.e("intimate_relationship", 2, "click  scheme: linkUrl or context is null");
                    }
                    ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_clck", "pg_aio_swipleft", "em_bas_special_day_entry", ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getPgTagDetailData(), null);
                    QLog.d("MainIntimateView", 1, "reportEM_BAS_SPECIAL_DAY_ENTRYClick");
                    if (qQAppInterface != null) {
                        IntimateInfoHandler intimateInfoHandler = (IntimateInfoHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.INTIMATE_INFO_HANDLER);
                        try {
                            j3 = Long.valueOf(k.this.f179143c).longValue();
                        } catch (NumberFormatException unused) {
                            QLog.e("intimate_relationship", 2, "valueOf string err");
                            j3 = 0;
                        }
                        intimateInfoHandler.W2(j3, b.this.f179150b.dateType);
                    }
                } else {
                    QLog.e("intimate_relationship", 2, "click  mInfo is null");
                }
                if (b.this.f179151c != null) {
                    b.this.f179151c.a(view, b.this.f179150b);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public b(Context context) {
            this.f179149a = null;
            this.f179149a = LayoutInflater.from(context).inflate(R.layout.c8k, (ViewGroup) null);
        }

        public View c() {
            return this.f179149a;
        }

        public void d(c cVar) {
            this.f179151c = cVar;
        }

        public void e(IntimateInfo.MemoryDayInfo memoryDayInfo) {
            String str;
            String str2;
            String str3;
            if (memoryDayInfo != null) {
                this.f179150b = memoryDayInfo;
                View view = this.f179149a;
                if (view == null) {
                    return;
                }
                view.setTag(memoryDayInfo);
                URLThemeImageView uRLThemeImageView = (URLThemeImageView) this.f179149a.findViewById(R.id.icon);
                TextView textView = (TextView) this.f179149a.findViewById(R.id.l4u);
                TextView textView2 = (TextView) this.f179149a.findViewById(R.id.eab);
                RelativeLayout relativeLayout = (RelativeLayout) this.f179149a.findViewById(R.id.f166226ls3);
                ImageView imageView = (ImageView) this.f179149a.findViewById(R.id.l_m);
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mRequestWidth = LpReportInfoConfig.ACTION_TYPE_DAWANG;
                obtain.mRequestHeight = 124;
                obtain.mRetryCount = 3;
                obtain.mPlayGifImage = true;
                String str4 = k.this.f179144d;
                if (uRLThemeImageView != null) {
                    ThemeImageWrapper themeImageWrapper = uRLThemeImageView.themeImageWrapper;
                    if (themeImageWrapper != null) {
                        themeImageWrapper.setMaskShape(ThemeImageWrapper.MODE_OTHER);
                    }
                    String str5 = memoryDayInfo.iconUrl;
                    if (str5 != null) {
                        uRLThemeImageView.setBackgroundURL(str5);
                    }
                }
                if (relativeLayout != null && ThemeUtil.isNowThemeIsNight(null, false, null)) {
                    str4 = k.this.f179145e;
                }
                if (!TextUtils.isEmpty(str4) && imageView != null) {
                    imageView.setImageDrawable(URLDrawable.getDrawable(str4, obtain));
                } else {
                    QLog.e("intimate_relationship", 2, " url is empty");
                }
                if (textView != null && (str2 = memoryDayInfo.wording) != null) {
                    textView.setText(str2);
                    if (textView2 == null || (str3 = memoryDayInfo.linkWording) == null) {
                        str3 = "";
                    }
                    int f16 = k.this.f(str3, 14.0f, BaseAIOUtils.f(95.0f, k.this.f179142b.getResources()) + 80);
                    if (f16 > 200) {
                        textView.setMaxWidth(f16);
                    } else {
                        textView.setMaxWidth(200);
                    }
                }
                if (textView2 != null && (str = memoryDayInfo.linkWording) != null) {
                    textView2.setText(str);
                    if (!TextUtils.isEmpty(memoryDayInfo.linkColor)) {
                        try {
                            textView2.setTextColor(Color.parseColor(memoryDayInfo.linkColor));
                        } catch (IllegalArgumentException unused) {
                            QLog.e("intimate_relationship", 2, " color parse err");
                        }
                    }
                    textView2.setOnClickListener(new a());
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface c {
        void a(View view, IntimateInfo.MemoryDayInfo memoryDayInfo);
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface d {
        void a(IntimateInfo.MemoryDayInfo memoryDayInfo);
    }

    public k(Context context, String str) {
        this.f179141a = null;
        this.f179142b = context;
        this.f179143c = str;
        this.f179141a = new LinearLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        this.f179141a.setOrientation(1);
        this.f179141a.setLayoutParams(layoutParams);
        q a16 = FriendIntimateRelationshipConfProcessor.a();
        this.f179144d = a16.f202717m0;
        this.f179145e = a16.f202718n0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(String str, float f16, int i3) {
        int i16;
        int i17 = 0;
        if (!TextUtils.isEmpty(str)) {
            Paint paint = new Paint();
            paint.setTextSize(TypedValue.applyDimension(2, f16, this.f179142b.getResources().getDisplayMetrics()));
            i16 = (int) paint.measureText(str, 0, str.length());
        } else {
            i16 = 0;
        }
        WindowManager windowManager = (WindowManager) this.f179142b.getSystemService("window");
        if (windowManager != null) {
            i17 = windowManager.getDefaultDisplay().getWidth();
        }
        return (i17 - i3) - i16;
    }

    public static void h(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("intimate_relationship", 2, "jumph5Url strUrl Empty");
            return;
        }
        if (!str.toLowerCase().startsWith("http://") && !str.toLowerCase().startsWith("https://")) {
            QLog.e("intimate_relationship", 2, "jumph5Url strUrl unRecognized " + str);
            return;
        }
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str);
        intent.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, HardCodeUtil.qqStr(R.string.f171898lr0));
        context.startActivity(intent);
    }

    public void e() {
        LinearLayout linearLayout = this.f179141a;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        this.f179141a = null;
        this.f179146f = null;
        this.f179142b = null;
    }

    public LinearLayout g() {
        return this.f179141a;
    }

    public void i(Context context, ArrayList<IntimateInfo.MemoryDayInfo> arrayList) {
        LinearLayout linearLayout = this.f179141a;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            ArrayList arrayList2 = new ArrayList();
            if (arrayList != null && arrayList.size() > 0) {
                Date date = new Date(NetConnInfoCenter.getServerTimeMillis());
                Iterator<IntimateInfo.MemoryDayInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    IntimateInfo.MemoryDayInfo next = it.next();
                    if (next != null && next.date != 0) {
                        Date date2 = new Date(next.date);
                        if (date.getDay() == date2.getDay() && date.getMonth() == date2.getMonth() && date.getYear() == date2.getYear()) {
                            arrayList2.add(next);
                        }
                    }
                }
            }
            if (arrayList2.size() > 0) {
                this.f179141a.setVisibility(0);
                for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                    IntimateInfo.MemoryDayInfo memoryDayInfo = (IntimateInfo.MemoryDayInfo) arrayList2.get(i3);
                    b bVar = new b(context);
                    bVar.e(memoryDayInfo);
                    bVar.d(this.f179146f);
                    if (bVar.c() != null) {
                        this.f179141a.addView(bVar.c());
                    }
                }
                return;
            }
            this.f179141a.setVisibility(8);
        }
    }

    public void j(String str) {
        this.f179143c = str;
    }

    public void k(d dVar) {
        this.f179147g = dVar;
    }
}
