package com.qzone.component;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.qzone.proxy.feedcomponent.model.PolymorphicPraiseData;
import com.qzone.proxy.feedcomponent.model.PolymorphicPraiseEmotionData;
import com.qzone.video.service.QZoneVideoCheckService;
import com.qzone.widget.util.ZipLoadBitmapGenerator;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.report.lp.LpReportInfo_dc00321;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes39.dex */
public class PokeLikeWizard {
    public static final int ANIM_SPEED = 25;
    public static final PokeLikeWizard INSTANCE = new PokeLikeWizard();
    public static final int RES_CANCEL = 5;
    public static final int RES_CLICK = 3;
    public static final int RES_EXPOSED = 1;
    public static final int RES_RETRACT = 4;
    public static final int RES_SLIDE_CLICK = 2;

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, ZipLoadBitmapGenerator> f46217a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final SparseArray<String> f46218b = new SparseArray<>();

    /* renamed from: c, reason: collision with root package name */
    private Typeface f46219c;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f46220d;

    /* renamed from: e, reason: collision with root package name */
    private PolymorphicPraiseData f46221e;

    PokeLikeWizard() {
    }

    private boolean b() {
        if (isGlobalPokeItemDataEmpty()) {
            return false;
        }
        Iterator<PolymorphicPraiseEmotionData> it = this.f46221e.emotionDatas.iterator();
        while (it.hasNext()) {
            ZipLoadBitmapGenerator zipLoadBitmapGenerator = this.f46217a.get(it.next().strPraiseZip);
            if (!zipLoadBitmapGenerator.isDownload()) {
                return false;
            }
            List<String> bitmapIdList = zipLoadBitmapGenerator.getBitmapIdList();
            if (bitmapIdList == null || bitmapIdList.isEmpty()) {
                zipLoadBitmapGenerator.reLoad();
                return false;
            }
        }
        return true;
    }

    private void d(int i3, int i16, int i17) {
        HashMap hashMap = new HashMap();
        hashMap.put("reporttime", String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("actiontype", String.valueOf(36));
        hashMap.put("subactiontype", String.valueOf(42));
        hashMap.put("reserves", String.valueOf(i3));
        hashMap.put("str8", Integer.toString(i16));
        hashMap.put("str6", Integer.toString(i17));
        ArrayList<Map<String, String>> arrayList = new ArrayList<>();
        arrayList.add(hashMap);
        QZoneVideoCheckService.get().sendVideoVisibilityReport(arrayList, null, true);
    }

    private void e(int i3, int i16, int i17) {
        HashMap hashMap = new HashMap();
        hashMap.put("like_id", Integer.toString(i16));
        hashMap.put("reserves3", Integer.toString(i17));
        LpReportInfo_dc00321.report(36, 42, i3, hashMap, null);
    }

    public void addPokeLikeAnimItem(final int i3, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f46218b.put(i3, str);
            getPokeLikeAnimItem(str);
        } else {
            QzoneHandlerThreadFactory.getMainHandler().post(new Runnable() { // from class: com.qzone.component.PokeLikeWizard.1
                @Override // java.lang.Runnable
                public void run() {
                    PokeLikeWizard.this.f46218b.put(i3, str);
                    PokeLikeWizard.this.getPokeLikeAnimItem(str);
                }
            });
        }
    }

    public PolymorphicPraiseData getGlobalPokeData() {
        return this.f46221e;
    }

    public ZipLoadBitmapGenerator getPokeLikeAnimItem(String str) {
        if (!TextUtils.isEmpty(str)) {
            ZipLoadBitmapGenerator zipLoadBitmapGenerator = this.f46217a.get(str);
            if (zipLoadBitmapGenerator != null) {
                return zipLoadBitmapGenerator;
            }
            ZipLoadBitmapGenerator zipLoadBitmapGenerator2 = new ZipLoadBitmapGenerator(str);
            this.f46217a.put(str, zipLoadBitmapGenerator2);
            return zipLoadBitmapGenerator2;
        }
        throw new NullPointerException("poke url cannot be null");
    }

    public String getPokeLikeUrl(int i3) {
        return this.f46218b.get(i3);
    }

    public boolean isGlobalPokeItemDataEmpty() {
        return c(this.f46221e);
    }

    public boolean isLoadingGlobalData() {
        return this.f46220d;
    }

    public Typeface loadTypeFace() {
        if (this.f46219c == null) {
            this.f46219c = Typeface.createFromAsset(BaseApplication.getContext().getAssets(), "qzone_feeds_poke_num.ttf");
        }
        return this.f46219c;
    }

    public void recordGuideAnimShow(Context context, boolean z16) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("qzone_poke", 0);
        sharedPreferences.edit().putInt("poke_guide_show_cnt", z16 ? Integer.MAX_VALUE : sharedPreferences.getInt("poke_guide_show_cnt", 0) + 1).putLong("poke_guide_last_show_time", System.currentTimeMillis()).apply();
    }

    public void recycleAllAnimImg() {
        Iterator<String> it = this.f46217a.keySet().iterator();
        while (it.hasNext()) {
            ZipLoadBitmapGenerator zipLoadBitmapGenerator = this.f46217a.get(it.next());
            if (zipLoadBitmapGenerator != null) {
                zipLoadBitmapGenerator.recycle();
            }
        }
    }

    public void report(boolean z16, int i3, int i16, int i17) {
        report(z16, i3, i16, i17, 0L);
    }

    public boolean shouldPopWindowShowGuideImg(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("qzone_poke", 0);
        boolean z16 = sharedPreferences.getBoolean("poke_guide_bar_show_", true);
        if (z16) {
            sharedPreferences.edit().putBoolean("poke_guide_bar_show_", false).apply();
        }
        return z16;
    }

    public boolean shouldShowFeedsGuideAnim(Context context) {
        if (!b()) {
            return false;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("qzone_poke", 0);
        return sharedPreferences.getInt("poke_guide_show_cnt", 0) <= 2 && System.currentTimeMillis() - sharedPreferences.getLong("poke_guide_last_show_time", 0L) > 86400000;
    }

    public void report(boolean z16, int i3, int i16, int i17, long j3) {
        QZLog.i("PokeLikeWizard", 4, "report: " + z16 + " " + i3 + " " + i16 + " " + i17 + " " + j3);
        if (z16) {
            f(i3, i16, i17, j3);
        } else {
            e(i3, i16, i17);
            d(i3, i16, i17);
        }
    }

    private static boolean c(PolymorphicPraiseData polymorphicPraiseData) {
        ArrayList<PolymorphicPraiseEmotionData> arrayList;
        return polymorphicPraiseData == null || (arrayList = polymorphicPraiseData.emotionDatas) == null || arrayList.isEmpty();
    }

    private void f(int i3, int i16, int i17, long j3) {
        LpReportInfo_pf00064.allReport(228, 1, i3, Integer.toString(i17), Integer.toString(i16), (String) null, j3);
    }
}
