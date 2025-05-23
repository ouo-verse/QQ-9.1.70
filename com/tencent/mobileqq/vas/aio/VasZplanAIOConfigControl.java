package com.tencent.mobileqq.vas.aio;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.ApngDrawable;
import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import com.tencent.mobileqq.lyric.common.TimerTaskManager;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\bE\u0010FJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\nH\u0002J!\u0010\u0010\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J \u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J \u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\fH\u0016J\u001a\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\fH\u0016J\b\u0010&\u001a\u00020\u0006H\u0016J\u0010\u0010'\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(H\u0016J\b\u0010+\u001a\u00020\u0004H\u0016J\u0006\u0010,\u001a\u00020\nJ\b\u0010-\u001a\u00020\fH\u0016J\u0010\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\fH\u0016J\u0010\u00100\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u00101\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u00102\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u00103\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u00106\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u00105R \u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u00108R \u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u00108R \u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00108R\u0016\u0010.\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010<R\u001c\u0010@\u001a\n >*\u0004\u0018\u00010=0=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010?R&\u0010B\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0A078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u00108R\u0018\u0010D\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010C\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/vas/aio/VasZplanAIOConfigControl;", "Lcom/tencent/mobileqq/vas/aio/a;", "", "friendUin", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/vas/aio/c;", "data", HippyTKDListViewAdapter.X, "y", "", "u", "", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND, "v", "w", "o", "(Ljava/lang/Long;Lcom/tencent/mobileqq/vas/aio/c;)V", "r", "a", "Landroid/graphics/drawable/Drawable;", "loadingDrawable", "", "url", "Lcom/tencent/image/GifDrawable$OnGIFPlayOnceListener;", "gifLisenter", "j", "Lcom/tencent/image/ApngDrawable$OnPlayRepeatListener;", "apngListener", "k", "getDrawable", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "type", "i", "uin", "themeStyle", "Lcom/tencent/mobileqq/vas/aio/f;", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "c", "Ljava/lang/Runnable;", "runnable", tl.h.F, "b", "t", "p", "hasShowStatus", "d", "l", DomainData.DOMAIN_NAME, "e", "f", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "entity", "", "Ljava/util/Map;", "timeMap", "isOnlineMap", "oldIsOnline", "I", "Lcom/tencent/mobileqq/lyric/common/TimerTaskManager;", "kotlin.jvm.PlatformType", "Lcom/tencent/mobileqq/lyric/common/TimerTaskManager;", "taskManager", "", "onlineUrlMap", "Lcom/tencent/mobileqq/vas/aio/c;", "aioData", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class VasZplanAIOConfigControl implements a {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: j, reason: collision with root package name */
    private static final Lazy<VasZplanAIOConfigControl> f308341j;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final MMKVOptionEntity entity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Map<Long, Long> timeMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Map<Long, Boolean> isOnlineMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Map<Long, Boolean> oldIsOnline;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int hasShowStatus;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final TimerTaskManager taskManager;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Map<Long, List<VasZplanAvatarIcon>> onlineUrlMap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private VasZplanAIOData aioData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/vas/aio/VasZplanAIOConfigControl$a;", "", "Lcom/tencent/mobileqq/vas/aio/VasZplanAIOConfigControl;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/vas/aio/VasZplanAIOConfigControl;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.aio.VasZplanAIOConfigControl$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VasZplanAIOConfigControl a() {
            return (VasZplanAIOConfigControl) VasZplanAIOConfigControl.f308341j.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<VasZplanAIOConfigControl> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<VasZplanAIOConfigControl>() { // from class: com.tencent.mobileqq.vas.aio.VasZplanAIOConfigControl$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final VasZplanAIOConfigControl invoke() {
                return new VasZplanAIOConfigControl();
            }
        });
        f308341j = lazy;
    }

    public VasZplanAIOConfigControl() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_VAS)");
        this.entity = from;
        this.timeMap = new LinkedHashMap();
        this.isOnlineMap = new LinkedHashMap();
        this.oldIsOnline = new LinkedHashMap();
        this.hasShowStatus = 4;
        this.taskManager = com.tencent.mobileqq.lyric.util.a.b();
        this.onlineUrlMap = new LinkedHashMap();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean u() {
        boolean z16;
        VasZplanAdvIcon advIcon;
        String url;
        if (this.hasShowStatus != 4) {
            return false;
        }
        VasZplanAIOData vasZplanAIOData = this.aioData;
        if (vasZplanAIOData != null && (advIcon = vasZplanAIOData.getAdvIcon()) != null && (url = advIcon.getUrl()) != null) {
            if (url.length() > 0) {
                z16 = true;
                return !z16;
            }
        }
        z16 = false;
        if (!z16) {
        }
    }

    private final long v(int second) {
        return second * 1000;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0022 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0023 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean w() {
        boolean z16;
        VasZplanBubble bubble;
        String text;
        VasZplanAIOData vasZplanAIOData = this.aioData;
        if (vasZplanAIOData != null && (bubble = vasZplanAIOData.getBubble()) != null && (text = bubble.getText()) != null) {
            if (text.length() > 0) {
                z16 = true;
                return !z16;
            }
        }
        z16 = false;
        if (!z16) {
        }
    }

    private final void x(VasZplanAIOData data) {
        if (this.aioData == null) {
            this.aioData = data;
            return;
        }
        int configType = data.getConfigType();
        VasZplanAIOData vasZplanAIOData = this.aioData;
        if (vasZplanAIOData != null) {
            if (configType == 1) {
                vasZplanAIOData.i(data.getBubble());
            } else if (configType == 2) {
                vasZplanAIOData.g(data.getAdvIcon());
            } else if (configType == 3) {
                vasZplanAIOData.j(data.getCycleIcon());
            }
            vasZplanAIOData.k(data.getInfo());
            vasZplanAIOData.h(data.getAvatarInfo());
        }
        if (configType == 3) {
            i(3);
        }
    }

    private final void y() {
        long serverTime = NetConnInfoCenter.getServerTime();
        if (serverTime - this.entity.decodeLong("sp_key_aio_vas_zplan_btn_bubble_show_time", serverTime) > JoinTimeType.SEVEN_DAY) {
            this.entity.encodeLong("sp_key_aio_vas_zplan_btn_bubble_show_time", serverTime);
            this.entity.encodeInt("sp_key_aio_vas_zplan_btn_bubble_nums", 0);
        }
    }

    private final void z(long friendUin) {
        List<VasZplanAvatarIcon> arrayList;
        VasZplanAvatarInfo avatarInfo;
        VasZplanAvatarInfo avatarInfo2;
        Map<Long, Boolean> map = this.oldIsOnline;
        Long valueOf = Long.valueOf(friendUin);
        Boolean bool = this.isOnlineMap.get(Long.valueOf(friendUin));
        boolean z16 = false;
        map.put(valueOf, Boolean.valueOf(bool != null ? bool.booleanValue() : false));
        Map<Long, Boolean> map2 = this.isOnlineMap;
        Long valueOf2 = Long.valueOf(friendUin);
        VasZplanAIOData vasZplanAIOData = this.aioData;
        if (vasZplanAIOData != null && (avatarInfo2 = vasZplanAIOData.getAvatarInfo()) != null) {
            z16 = avatarInfo2.getIsOnline();
        }
        map2.put(valueOf2, Boolean.valueOf(z16));
        Map<Long, List<VasZplanAvatarIcon>> map3 = this.onlineUrlMap;
        Long valueOf3 = Long.valueOf(friendUin);
        VasZplanAIOData vasZplanAIOData2 = this.aioData;
        if (vasZplanAIOData2 == null || (avatarInfo = vasZplanAIOData2.getAvatarInfo()) == null || (arrayList = avatarInfo.a()) == null) {
            arrayList = new ArrayList<>();
        }
        map3.put(valueOf3, arrayList);
        this.timeMap.put(Long.valueOf(friendUin), Long.valueOf(NetConnInfoCenter.getServerTime()));
    }

    @Override // com.tencent.mobileqq.vas.aio.a
    public boolean a() {
        if (!w()) {
            return false;
        }
        if (s03.a.f433066a.b()) {
            return true;
        }
        if (this.hasShowStatus != 4) {
            return false;
        }
        y();
        return this.entity.decodeInt("sp_key_aio_vas_zplan_btn_bubble_nums", 0) < 1;
    }

    @Override // com.tencent.mobileqq.vas.aio.a
    public int c(long friendUin) {
        VasZplanInfo info;
        String backgroundIconUrl;
        if (Intrinsics.areEqual(this.isOnlineMap.get(Long.valueOf(friendUin)), Boolean.TRUE)) {
            return 5;
        }
        if (u()) {
            return 2;
        }
        if (t()) {
            return 3;
        }
        VasZplanAIOData vasZplanAIOData = this.aioData;
        boolean z16 = false;
        if (vasZplanAIOData != null && (info = vasZplanAIOData.getInfo()) != null && (backgroundIconUrl = info.getBackgroundIconUrl()) != null) {
            if (backgroundIconUrl.length() > 0) {
                z16 = true;
            }
        }
        return z16 ? 6 : 4;
    }

    @Override // com.tencent.mobileqq.vas.aio.a
    public void d(int hasShowStatus) {
        this.hasShowStatus = hasShowStatus;
        QLog.i("ZplanVasAIOConfigControl", 1, " show config status: " + hasShowStatus);
    }

    @Override // com.tencent.mobileqq.vas.aio.a
    public boolean e(long friendUin) {
        Boolean bool = this.isOnlineMap.get(Long.valueOf(friendUin));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.vas.aio.a
    /* renamed from: f, reason: from getter */
    public VasZplanAIOData getAioData() {
        return this.aioData;
    }

    @Override // com.tencent.mobileqq.vas.aio.a
    public VasZplanAvatarIcon g(long uin, int themeStyle) {
        List<VasZplanAvatarIcon> list = this.onlineUrlMap.get(Long.valueOf(uin));
        Object obj = null;
        if (list == null) {
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((VasZplanAvatarIcon) next).getModel() == themeStyle) {
                obj = next;
                break;
            }
        }
        return (VasZplanAvatarIcon) obj;
    }

    @Override // com.tencent.mobileqq.vas.aio.a
    public Drawable getDrawable(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return j.f308385a.a(url);
    }

    @Override // com.tencent.mobileqq.vas.aio.a
    public void h(Runnable runnable) {
        VasZplanInfo info;
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        VasZplanAIOData vasZplanAIOData = this.aioData;
        int i3 = 600;
        int aioInterval = (vasZplanAIOData == null || (info = vasZplanAIOData.getInfo()) == null) ? 600 : info.getAioInterval();
        if (aioInterval <= 0) {
            QLog.d("ZplanVasAIOConfigControl", 1, "startTimerTask, fix delay:" + aioInterval);
        } else {
            i3 = aioInterval;
        }
        b();
        QLog.d("ZplanVasAIOConfigControl", 1, "startTimerTask, " + i3);
        this.taskManager.c("zplan_vas_aio_smallhome_task", v(i3), v(i3), (TimerTaskManager.TimerTaskRunnable) runnable);
    }

    @Override // com.tencent.mobileqq.vas.aio.a
    public void i(int type) {
        long longAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getLongAccountUin();
        VasZplanAIOData vasZplanAIOData = this.aioData;
        if (vasZplanAIOData != null) {
            d.f308368a.d(longAccountUin, type, vasZplanAIOData);
            if (type == 1) {
                vasZplanAIOData.i(null);
            } else {
                if (type != 2) {
                    return;
                }
                vasZplanAIOData.g(null);
            }
        }
    }

    @Override // com.tencent.mobileqq.vas.aio.a
    public Drawable j(Drawable loadingDrawable, String url, GifDrawable.OnGIFPlayOnceListener gifLisenter) {
        Intrinsics.checkNotNullParameter(loadingDrawable, "loadingDrawable");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(gifLisenter, "gifLisenter");
        return j.f308385a.c(loadingDrawable, url, gifLisenter);
    }

    @Override // com.tencent.mobileqq.vas.aio.a
    public Drawable k(Drawable loadingDrawable, String url, ApngDrawable.OnPlayRepeatListener apngListener) {
        Intrinsics.checkNotNullParameter(loadingDrawable, "loadingDrawable");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(apngListener, "apngListener");
        Drawable b16 = j.f308385a.b(loadingDrawable, url, apngListener);
        return b16 == null ? loadingDrawable : b16;
    }

    @Override // com.tencent.mobileqq.vas.aio.a
    public boolean l(long friendUin) {
        int i3 = this.hasShowStatus;
        return (i3 == 4 || i3 == 7) && Intrinsics.areEqual(this.isOnlineMap.get(Long.valueOf(friendUin)), Boolean.FALSE);
    }

    @Override // com.tencent.mobileqq.vas.aio.a
    public VasZplanAIOData m() {
        return d.f308368a.a(MobileQQ.sMobileQQ.peekAppRuntime().getLongAccountUin());
    }

    @Override // com.tencent.mobileqq.vas.aio.a
    public boolean n(long friendUin) {
        Boolean bool = this.isOnlineMap.get(Long.valueOf(friendUin));
        Boolean bool2 = Boolean.TRUE;
        if (Intrinsics.areEqual(bool, bool2) || Intrinsics.areEqual(this.oldIsOnline.get(Long.valueOf(friendUin)), bool2)) {
            return true;
        }
        if (this.hasShowStatus != 4) {
            return false;
        }
        int c16 = c(friendUin);
        return c16 == 2 || c16 == 3;
    }

    @Override // com.tencent.mobileqq.vas.aio.a
    public void o(Long friendUin, VasZplanAIOData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        x(data);
        if (friendUin != null) {
            z(friendUin.longValue());
        }
    }

    @Override // com.tencent.mobileqq.vas.aio.a
    /* renamed from: p, reason: from getter */
    public int getHasShowStatus() {
        return this.hasShowStatus;
    }

    @Override // com.tencent.mobileqq.vas.aio.a
    public void q() {
        int decodeInt = this.entity.decodeInt("sp_key_aio_vas_zplan_btn_bubble_nums", 0);
        if (decodeInt == 0) {
            this.entity.encodeLong("sp_key_aio_vas_zplan_btn_bubble_show_time", NetConnInfoCenter.getServerTime());
        }
        this.entity.encodeInt("sp_key_aio_vas_zplan_btn_bubble_nums", decodeInt + 1);
        i(1);
        this.hasShowStatus = 1;
        QLog.e("ZplanVasAIOConfigControl", 1, " show config status: 1");
    }

    @Override // com.tencent.mobileqq.vas.aio.a
    public boolean r(long friendUin) {
        VasZplanInfo info;
        Long l3 = this.timeMap.get(Long.valueOf(friendUin));
        Long valueOf = l3 != null ? Long.valueOf(NetConnInfoCenter.getServerTime() - l3.longValue()) : null;
        if (valueOf != null) {
            VasZplanAIOData vasZplanAIOData = this.aioData;
            if (valueOf.longValue() < ((vasZplanAIOData == null || (info = vasZplanAIOData.getInfo()) == null) ? 30 : info.getDefaultInterval())) {
                QLog.i("ZplanVasAIOConfigControl", 1, " aio stay time: " + valueOf);
                return false;
            }
        }
        return true;
    }

    public final boolean t() {
        VasZplanCycleIcon cycleIcon;
        VasZplanCycleIcon cycleIcon2;
        VasZplanCycleIcon cycleIcon3;
        VasZplanAIOData vasZplanAIOData = this.aioData;
        if (TextUtils.isEmpty((vasZplanAIOData == null || (cycleIcon3 = vasZplanAIOData.getCycleIcon()) == null) ? null : cycleIcon3.getUrl())) {
            return false;
        }
        int i3 = this.hasShowStatus;
        if (i3 == 4 || i3 == 3) {
            long serverTime = NetConnInfoCenter.getServerTime();
            VasZplanAIOData vasZplanAIOData2 = this.aioData;
            int startTime = (vasZplanAIOData2 == null || (cycleIcon2 = vasZplanAIOData2.getCycleIcon()) == null) ? 0 : cycleIcon2.getStartTime();
            VasZplanAIOData vasZplanAIOData3 = this.aioData;
            if (((long) (startTime + 1)) <= serverTime && serverTime < ((long) ((vasZplanAIOData3 == null || (cycleIcon = vasZplanAIOData3.getCycleIcon()) == null) ? 0 : cycleIcon.getEndTime()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.vas.aio.a
    public void b() {
        QLog.d("ZplanVasAIOConfigControl", 1, "cancelTimerTask");
        this.taskManager.a("zplan_vas_aio_smallhome_task");
    }
}
