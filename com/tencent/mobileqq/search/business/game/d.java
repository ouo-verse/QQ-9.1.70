package com.tencent.mobileqq.search.business.game;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ams.fusion.widget.downloadcard.DownloadCardView;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.util.aq;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.URLUtil;
import java.util.List;
import lo2.s;
import sn2.g;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static DownloadParams.DecodeHandler f283035a = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f283036d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ s f283037e;

        a(String str, s sVar) {
            this.f283036d = str;
            this.f283037e = sVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intent intent = new Intent(view.getContext(), (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", this.f283036d);
            view.getContext().startActivity(intent);
            d.k(this.f283037e);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements DownloadParams.DecodeHandler {
        b() {
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            if (bitmap == null) {
                return null;
            }
            Object obj = downloadParams.tag;
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                if (iArr.length == 3) {
                    if (iArr[0] == 0) {
                        iArr[0] = bitmap.getWidth();
                    }
                    if (iArr[1] == 0) {
                        iArr[1] = bitmap.getHeight();
                    }
                    bitmap = BaseImageUtil.getRoundedCornerBitmap3(bitmap, iArr[2], iArr[0], iArr[1]);
                    if (bitmap == null && QLog.isDevelopLevel()) {
                        QLog.w("GameSearchViewBind", 2, "ROUND_CORNER_DECODER bitmap == null");
                    }
                }
            }
            return bitmap;
        }
    }

    public static void b(s sVar, e eVar) {
        LinearLayout linearLayout = (LinearLayout) eVar.p();
        if (sVar != null && linearLayout != null) {
            Context context = eVar.getView().getContext();
            g d16 = d(context, sVar);
            g(linearLayout);
            linearLayout.addView(d16.getView());
            i(context, d16, sVar.f415272e0);
            j(sVar, d16, sVar.f415270c0);
            f(context, d16, sVar.f415271d0);
            h(sVar, d16);
            d16.getView().setOnClickListener(new a(sVar.f415273f0, sVar));
            l(sVar);
        }
    }

    public static int[] c(int i3, int i16, int i17) {
        return new int[]{i3, i16, i17};
    }

    private static g d(Context context, s sVar) {
        int i3;
        View inflate = LayoutInflater.from(context).inflate(R.layout.hpq, (ViewGroup) null);
        g gVar = new g(inflate);
        View findViewById = inflate.findViewById(R.id.dpr);
        if (sVar.f415274g0) {
            i3 = 10;
        } else {
            i3 = 6;
        }
        int dip2px = ViewUtils.dip2px(i3);
        findViewById.setPadding(0, dip2px, 0, dip2px);
        if (aq.a()) {
            findViewById.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
        }
        return gVar;
    }

    private static TextView e(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        TextView textView = new TextView(context);
        textView.setText(str);
        textView.setTextColor(DownloadCardView.COLOR_APP_VERSION);
        textView.setGravity(17);
        int dip2px = ViewUtils.dip2px(1.0f);
        textView.setPadding(dip2px, dip2px, dip2px, dip2px);
        textView.setTextSize(1, 10.0f);
        Resources resources = textView.getResources();
        GradientDrawable gradientDrawable = (GradientDrawable) resources.getDrawable(R.drawable.jof);
        if (aq.a()) {
            gradientDrawable.setColor(resources.getColor(R.color.qui_common_bg_bottom_standard));
            textView.setTextColor(resources.getColor(R.color.qui_common_text_secondary));
        }
        textView.setBackgroundDrawable(gradientDrawable);
        return textView;
    }

    private static void f(Context context, g gVar, String str) {
        if (context != null && gVar != null) {
            ColorDrawable colorDrawable = new ColorDrawable(-1579033);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            int c16 = x.c(context, 50.0f);
            obtain.mRequestWidth = c16;
            obtain.mRequestHeight = c16;
            obtain.mFailedDrawable = colorDrawable;
            obtain.mLoadingDrawable = colorDrawable;
            if (URLUtil.isValidUrl(str)) {
                URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
                drawable.setTag(c(c16, c16, x.c(context, 3.0f)));
                drawable.setDecodeHandler(f283035a);
                gVar.f().setImageDrawable(drawable);
                if (drawable.getStatus() != 1 && drawable.getStatus() != 0) {
                    drawable.restartDownload();
                    return;
                }
                return;
            }
            gVar.f().setImageDrawable(colorDrawable);
        }
    }

    private static void g(LinearLayout linearLayout) {
        linearLayout.removeAllViews();
        if (linearLayout.getParent() != null) {
            ((View) linearLayout.getParent()).setPadding(0, 0, 0, 0);
        }
    }

    private static void h(s sVar, g gVar) {
        int i3;
        View findViewById = gVar.getView().findViewById(R.id.tjv);
        if (sVar.f415274g0) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        findViewById.setVisibility(i3);
    }

    private static void i(Context context, g gVar, List<String> list) {
        LinearLayout linearLayout = (LinearLayout) gVar.getView().findViewById(R.id.yfo);
        if (list != null && list.size() > 0) {
            linearLayout.setVisibility(0);
            for (int i3 = 0; i3 < list.size(); i3++) {
                TextView e16 = e(context, list.get(i3));
                if (e16 != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, ViewUtils.dip2px(16.0f));
                    layoutParams.rightMargin = ViewUtils.dip2px(4.0f);
                    linearLayout.addView(e16, layoutParams);
                }
            }
            return;
        }
        linearLayout.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [android.text.SpannableString] */
    private static void j(s sVar, g gVar, String str) {
        String str2;
        if (gVar.b() != null && str != null) {
            com.tencent.mobileqq.search.util.e eVar = sVar.P;
            if (eVar != null) {
                str2 = eVar.a(str);
            } else {
                str2 = null;
            }
            gVar.b().setTextColor(gVar.b().getResources().getColor(R.color.qui_common_text_primary));
            TextView b16 = gVar.b();
            if (str2 != null) {
                str = str2;
            }
            b16.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(s sVar) {
        if (sVar == null) {
            return;
        }
        if (sVar.f415274g0) {
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(sVar.f415269b0, "1", "982", "9075", "907801", "907222", "", "", "20", "");
        } else {
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(sVar.f415269b0, "1", "982", "9075", "907501", "907219", "", "", "20", "");
        }
    }

    private static void l(s sVar) {
        if (sVar == null) {
            return;
        }
        if (sVar.f415274g0) {
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(sVar.f415269b0, "1", "982", "9075", "907801", "907221", "", "", "8", "");
        } else {
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(sVar.f415269b0, "1", "982", "9075", "907501", "907215", "", "", "8", "");
        }
    }
}
