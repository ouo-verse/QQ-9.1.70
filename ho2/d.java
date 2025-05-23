package ho2;

import android.text.TextUtils;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public int f405455a;

    /* renamed from: b, reason: collision with root package name */
    public String f405456b;

    /* renamed from: c, reason: collision with root package name */
    public String f405457c;

    /* renamed from: d, reason: collision with root package name */
    public String f405458d;

    /* renamed from: e, reason: collision with root package name */
    public String f405459e;

    /* renamed from: f, reason: collision with root package name */
    public String f405460f;

    /* renamed from: g, reason: collision with root package name */
    public String f405461g;

    /* renamed from: i, reason: collision with root package name */
    public String f405463i;

    /* renamed from: m, reason: collision with root package name */
    public String f405467m;

    /* renamed from: n, reason: collision with root package name */
    public String f405468n;

    /* renamed from: o, reason: collision with root package name */
    public String f405469o;

    /* renamed from: h, reason: collision with root package name */
    public int f405462h = 0;

    /* renamed from: j, reason: collision with root package name */
    public c f405464j = new c();

    /* renamed from: k, reason: collision with root package name */
    public b f405465k = new b();

    /* renamed from: l, reason: collision with root package name */
    public List<a> f405466l = new ArrayList();

    /* renamed from: p, reason: collision with root package name */
    public int f405470p = 0;

    /* renamed from: q, reason: collision with root package name */
    public e f405471q = new e();

    /* renamed from: r, reason: collision with root package name */
    public int f405472r = 0;

    public d(int i3, String str, String str2, String str3, String str4, String str5, String str6) {
        this.f405455a = i3;
        this.f405456b = str;
        this.f405457c = str2;
        this.f405458d = str3;
        this.f405459e = str4;
        this.f405460f = str5;
        this.f405461g = str6;
    }

    public String a() {
        boolean z16;
        int i3 = this.f405462h;
        String str = "";
        if (i3 > 0) {
            if (i3 > 99) {
                z16 = true;
            } else {
                z16 = false;
            }
            int min = Math.min(99, i3);
            String string = BaseApplication.getContext().getResources().getString(R.string.f213985ro);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(min);
            if (z16) {
                str = Marker.ANY_NON_NULL_MARKER;
            }
            sb5.append(str);
            sb5.append(string);
            str = sb5.toString();
        }
        if (!TextUtils.isEmpty(this.f405457c)) {
            if (!str.isEmpty()) {
                str = str + APLogFileUtil.SEPARATOR_LOG;
            }
            return str + this.f405457c;
        }
        return str;
    }

    public String toString() {
        return "GuildSearchEntity{joinedGuild=" + this.f405455a + ", name='" + this.f405456b + "', profile='" + this.f405457c + "', coverUrl='" + this.f405458d + "', joinGuildSig='" + this.f405459e + "', guildId='" + this.f405460f + "', headUrl='" + this.f405461g + "', friendNum=" + this.f405462h + ", tag='" + this.f405463i + "', curChannelState=" + this.f405464j + ", authenticate=" + this.f405465k + ", medals=" + this.f405466l + ", channelTagTips='" + this.f405467m + "', channelTagReportKey='" + this.f405468n + "', channelCode='" + this.f405469o + "', searchGuildTotalNum=" + this.f405470p + ", reCallInfo=" + this.f405471q + ", searchType=" + this.f405472r + '}';
    }
}
