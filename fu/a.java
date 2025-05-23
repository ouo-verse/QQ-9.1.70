package fu;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.av.ManageConfig.QAVConfig;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.av.business.manager.filter.FilterItem;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.n;
import com.tencent.av.opengl.effects.j;
import com.tencent.av.opengl.effects.m;
import com.tencent.av.utils.e;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a extends EffectConfigBase<FilterItem> {
    static boolean H = false;
    private FilterDesc F;
    FilterItem G;

    /* compiled from: P */
    /* renamed from: fu.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C10338a {

        /* renamed from: a, reason: collision with root package name */
        static String f400625a = "EffectFilterTools";

        /* renamed from: b, reason: collision with root package name */
        static long f400626b = 0;

        /* renamed from: c, reason: collision with root package name */
        static boolean f400627c = false;

        static void a(FilterItem filterItem) {
            long currentTimeMillis = System.currentTimeMillis();
            AVCoreLog.printColorLog(f400625a, "DataReport onUserdFilter:" + filterItem + "|" + f400626b);
            if (filterItem != null && !filterItem.isEmptyFilter()) {
                long j3 = f400626b;
                if (j3 != 0) {
                    long j16 = currentTimeMillis - j3;
                    AVCoreLog.printColorLog(f400625a, "DataReport onUserdFilter:" + j16);
                    if (j16 > 5000) {
                        f400627c = true;
                        b(filterItem, j16 / 1000);
                    }
                }
                AVCoreLog.printColorLog(f400625a, "DataReport onUserdFilter 33:" + f400626b);
            }
            f400626b = currentTimeMillis;
        }

        public static void b(FilterItem filterItem, long j3) {
            String id5 = filterItem.getId();
            AVCoreLog.printColorLog(f400625a, "DataReport onStateReport:" + id5 + "|" + j3);
            HashMap hashMap = new HashMap();
            hashMap.put("filterName", id5);
            hashMap.put("duration", String.valueOf(j3));
            UserAction.onUserAction("actAVFunChatFilter", true, -1L, -1L, hashMap, true);
            try {
                UserAction.flushObjectsToDB(true);
            } catch (Exception e16) {
                AVCoreLog.printErrorLog(f400625a, e16.getMessage());
            }
        }

        public static void c(boolean z16) {
            String str;
            AVCoreLog.printColorLog(f400625a, "DataReport onSupport:" + z16);
            if (z16) {
                str = "0X80076AF";
            } else {
                str = "0X80076B0";
            }
            e(str);
        }

        public static void d(VideoAppInterface videoAppInterface) {
            String str;
            if (videoAppInterface.Y(1)) {
                FilterItem u16 = ((a) videoAppInterface.B(1)).u();
                a(u16);
                AVCoreLog.printColorLog(f400625a, "DataReport onUserdFilter:" + u16 + "|" + f400627c);
                if (f400627c) {
                    str = "0X80076B2";
                } else {
                    str = "0X80076B1";
                }
                e(str);
            }
        }

        public static void e(String str) {
            ReportController.o(null, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
        }
    }

    public a(VideoAppInterface videoAppInterface) {
        super(videoAppInterface);
        this.G = null;
    }

    public static String R(String str) {
        if (str != null && !str.equals("")) {
            int lastIndexOf = str.lastIndexOf(".");
            int lastIndexOf2 = str.lastIndexOf(File.separator);
            if (lastIndexOf2 == -1) {
                if (lastIndexOf != -1) {
                    return str.substring(0, lastIndexOf);
                }
                return str;
            }
            if (lastIndexOf == -1) {
                return str.substring(lastIndexOf2 + 1);
            }
            if (lastIndexOf2 < lastIndexOf) {
                return str.substring(lastIndexOf2 + 1, lastIndexOf);
            }
            return str.substring(lastIndexOf2 + 1);
        }
        return str;
    }

    public static boolean V(Context context) {
        boolean z16 = H;
        if (z16) {
            return z16;
        }
        if (!m.K()) {
            AVCoreLog.printColorLog("EffectFilterTools", "isSupport Error: 1");
            return false;
        }
        if (!j.F(4, 1400000L)) {
            return false;
        }
        if (context != null && TextUtils.isEmpty(QAVConfig.e(132).f448490b)) {
            return false;
        }
        mv.a a16 = mv.a.a();
        if (a16 != null && !a16.d()) {
            AVCoreLog.printColorLog("EffectFilterTools", "  isSupportFilter false");
            return false;
        }
        H = true;
        return true;
    }

    public FilterDesc S() {
        return this.F;
    }

    public String T(FilterItem filterItem) {
        if (filterItem != null && !TextUtils.isEmpty(filterItem.getResUrl()) && !TextUtils.isEmpty(filterItem.getId())) {
            return y(filterItem) + R(filterItem.getResUrl());
        }
        return null;
    }

    boolean U(long j3, FilterItem filterItem) {
        boolean L = super.L(j3, filterItem);
        SessionInfo f16 = n.e().f();
        if (TextUtils.isEmpty(T(filterItem))) {
            f16.I1.clear(2);
            this.F = null;
        } else if (filterItem != null) {
            f16.I1.set(2);
            FilterDesc filterDesc = new FilterDesc(Integer.valueOf(filterItem.getFilterId()).intValue(), filterItem.getPredownload(), filterItem.getResUrl(), filterItem.getMd5(), filterItem.getIconUrl(), filterItem.getIconMd5(), filterItem.getId(), 0, y(filterItem));
            this.F = filterDesc;
            filterDesc.type = filterItem.getFiltertype();
        }
        if (filterItem != null) {
            C10338a.a(u());
        }
        return L;
    }

    public void X(long j3, PendantItem pendantItem) {
        if (pendantItem != null && !TextUtils.isEmpty(pendantItem.getFilterName())) {
            U(j3, w(pendantItem.getFilterName()));
        } else {
            U(j3, this.G);
        }
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public boolean L(long j3, FilterItem filterItem) {
        this.G = filterItem;
        return U(j3, filterItem);
    }

    @Override // com.tencent.av.business.manager.a
    protected boolean i(String str) {
        super.G();
        List<T> list = this.f73303i;
        if (list == 0) {
            return false;
        }
        int i3 = 0;
        int i16 = 0;
        for (T t16 : list) {
            long d16 = e.d();
            if (e.k()) {
                QLog.w("EffectFilterTools", 1, "preDownloadResource, seq[" + d16 + "], res[" + t16.getResUrl() + "], icon[" + t16.getIconUrl() + "]");
            }
            if (t16.getPredownload() == 1) {
                i16++;
                if (!TextUtils.isEmpty(t16.getResUrl()) && !t16.isUsable()) {
                    N(d16, t16);
                } else {
                    i3++;
                }
            }
        }
        if (i3 != i16) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.av.business.manager.a
    protected void j(long j3, int i3, String str, String str2) {
        if (i3 == 2 || i3 == 3) {
            L(j3, null);
        }
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase
    public List<FilterItem> q(String str) {
        List q16 = super.q(str);
        ArrayList arrayList = new ArrayList();
        if (q16 != null) {
            arrayList.addAll(q16);
        }
        return arrayList;
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase
    public int r() {
        return 132;
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase
    protected Class<?> x() {
        return FilterItem.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.business.manager.EffectConfigBase
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public void D(FilterItem filterItem) {
    }
}
