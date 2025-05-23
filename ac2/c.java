package ac2;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto$RcmdAnchor;
import com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto$RecommendItem;
import com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto$RecommendPageReq;
import com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto$RecommendPageRsp;
import com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto$UserExtraInfo;
import com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto$UserMsgInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager;
import com.tencent.mobileqq.qqlive.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.qqlive.callback.sso.IQQLiveProxySsoObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.o;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes9.dex */
public class c {

    /* renamed from: m, reason: collision with root package name */
    private static int f25810m;

    /* renamed from: a, reason: collision with root package name */
    private final String f25811a = c.class.getSimpleName();

    /* renamed from: b, reason: collision with root package name */
    public final int f25812b = 2;

    /* renamed from: c, reason: collision with root package name */
    private final String f25813c = "78711";

    /* renamed from: d, reason: collision with root package name */
    private Set<String> f25814d = new HashSet();

    /* renamed from: e, reason: collision with root package name */
    private int f25815e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f25816f = 0;

    /* renamed from: g, reason: collision with root package name */
    private final int f25817g = 60000;

    /* renamed from: h, reason: collision with root package name */
    private long f25818h = 0;

    /* renamed from: i, reason: collision with root package name */
    private int f25819i = 0;

    /* renamed from: j, reason: collision with root package name */
    protected boolean f25820j = false;

    /* renamed from: k, reason: collision with root package name */
    private volatile boolean f25821k = false;

    /* renamed from: l, reason: collision with root package name */
    private final List<d> f25822l = new CopyOnWriteArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements IQQLiveProxySsoObserver {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f25823a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f25824b;

        a(int i3, b bVar) {
            this.f25823a = i3;
            this.f25824b = bVar;
        }

        @Override // com.tencent.mobileqq.qqlive.callback.sso.IQQLiveProxySsoObserver
        public void onFail(int i3, String str) {
            c.this.f25821k = false;
            if (c.this.f25822l.size() == 0) {
                c.this.j(this.f25823a, this.f25824b, true);
            }
            if (QLog.isColorLevel()) {
                QLog.d(c.this.f25811a, 2, "Focus cmd:1718 sub cmd:100 errCode:" + i3 + " msg:" + str);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.sso.IQQLiveProxySsoObserver
        public void onReceive(byte[] bArr) {
            c.this.f25821k = false;
            try {
                c.this.f25819i = 0;
                if (c.this.i(this.f25823a, bArr) == -1 && c.this.f25822l.size() == 0) {
                    c.this.j(this.f25823a, this.f25824b, true);
                }
                this.f25824b.onSuccess(c.this.f25822l);
                c.this.f25818h = System.currentTimeMillis();
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(c.this.f25811a, 2, "Focus cmd:1718 sub cmd:100 Exception:" + e16.getMessage());
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface b {
        void onFailed();

        void onSuccess(List<d> list);
    }

    private d h(NowQQLiveHomepageProto$RcmdAnchor nowQQLiveHomepageProto$RcmdAnchor) {
        boolean z16;
        d dVar = new d();
        dVar.f25845t = nowQQLiveHomepageProto$RcmdAnchor.string_head_img_url.get();
        dVar.f25829d = nowQQLiveHomepageProto$RcmdAnchor.string_room_img_url.get();
        dVar.f25828c = nowQQLiveHomepageProto$RcmdAnchor.hall_room_id.get();
        dVar.f25830e = nowQQLiveHomepageProto$RcmdAnchor.string_name.get();
        dVar.f25834i = nowQQLiveHomepageProto$RcmdAnchor.uint32_watch_count.get();
        dVar.f25831f = nowQQLiveHomepageProto$RcmdAnchor.string_location.get();
        dVar.f25833h = nowQQLiveHomepageProto$RcmdAnchor.string_id.get();
        dVar.f25846u = nowQQLiveHomepageProto$RcmdAnchor.imsdk_tiny_id.get();
        dVar.A = nowQQLiveHomepageProto$RcmdAnchor.rtmp_url.get();
        boolean z17 = true;
        if (nowQQLiveHomepageProto$RcmdAnchor.allow_play.get() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        dVar.C = z16;
        if (nowQQLiveHomepageProto$RcmdAnchor.video_preview.get() != 1) {
            z17 = false;
        }
        dVar.E = z17;
        dVar.f25837l = nowQQLiveHomepageProto$RcmdAnchor.microphone_flag.get();
        dVar.f25838m = nowQQLiveHomepageProto$RcmdAnchor.icon_url.get();
        dVar.f25841p = nowQQLiveHomepageProto$RcmdAnchor.rich_title.elements.get();
        dVar.f25844s = nowQQLiveHomepageProto$RcmdAnchor.string_description.get();
        dVar.f25843r = nowQQLiveHomepageProto$RcmdAnchor.award_pendant_url.get();
        if (nowQQLiveHomepageProto$RcmdAnchor.extra_info.has()) {
            NowQQLiveHomepageProto$UserExtraInfo nowQQLiveHomepageProto$UserExtraInfo = nowQQLiveHomepageProto$RcmdAnchor.extra_info.get();
            if (nowQQLiveHomepageProto$UserExtraInfo.medal_info_list.has() && nowQQLiveHomepageProto$UserExtraInfo.medal_info_list.get() != null && nowQQLiveHomepageProto$UserExtraInfo.medal_info_list.size() > 0) {
                dVar.c(nowQQLiveHomepageProto$UserExtraInfo.medal_info_list.get());
            }
        }
        dVar.f25847v = nowQQLiveHomepageProto$RcmdAnchor.user_tag.color.get();
        try {
            if (!TextUtils.isEmpty(nowQQLiveHomepageProto$RcmdAnchor.user_tag.change_color.get())) {
                dVar.f25848w = Integer.parseInt(nowQQLiveHomepageProto$RcmdAnchor.user_tag.change_color.get(), 16);
            }
        } catch (NumberFormatException e16) {
            QLog.e(this.f25811a, 2, e16, new Object[0]);
        }
        dVar.f25849x = nowQQLiveHomepageProto$RcmdAnchor.user_tag.pic_url.get();
        dVar.f25850y = nowQQLiveHomepageProto$RcmdAnchor.user_tag.wording.get();
        dVar.f25832g = nowQQLiveHomepageProto$RcmdAnchor.string_jump_url.get();
        dVar.f25851z = nowQQLiveHomepageProto$RcmdAnchor.user_tag.type.get();
        dVar.B = nowQQLiveHomepageProto$RcmdAnchor.advertising_sign.get();
        return dVar;
    }

    public List<d> f() {
        return this.f25822l;
    }

    public void g(b bVar) {
        if (System.currentTimeMillis() > this.f25818h + 60000) {
            j(0, bVar, false);
        }
    }

    public int i(int i3, byte[] bArr) {
        if (bArr == null) {
            return -1;
        }
        QLog.d(this.f25811a, 2, "parse data");
        if (i3 <= 0) {
            this.f25814d.clear();
            this.f25822l.clear();
            this.f25815e = 0;
            QLog.d(this.f25811a, 2, "clear state");
        }
        try {
            NowQQLiveHomepageProto$RecommendPageRsp nowQQLiveHomepageProto$RecommendPageRsp = new NowQQLiveHomepageProto$RecommendPageRsp();
            nowQQLiveHomepageProto$RecommendPageRsp.mergeFrom(bArr);
            this.f25816f = nowQQLiveHomepageProto$RecommendPageRsp.uint32_new_timestamp.get();
            f25810m = nowQQLiveHomepageProto$RecommendPageRsp.rcmd_col_mode.get();
            for (NowQQLiveHomepageProto$RecommendItem nowQQLiveHomepageProto$RecommendItem : nowQQLiveHomepageProto$RecommendPageRsp.rpt_msg_rcmd.get()) {
                if (this.f25814d.contains(nowQQLiveHomepageProto$RecommendItem.string_key.get())) {
                    QLog.d(this.f25811a, 2, "\u53bb\u91cd\uff1a " + nowQQLiveHomepageProto$RecommendItem.string_key.get());
                } else {
                    this.f25814d.add(nowQQLiveHomepageProto$RecommendItem.string_key.get());
                    int i16 = nowQQLiveHomepageProto$RecommendItem.uint32_type.get();
                    if (i16 != 0) {
                        if (i16 == 5) {
                            NowQQLiveHomepageProto$RcmdAnchor nowQQLiveHomepageProto$RcmdAnchor = nowQQLiveHomepageProto$RecommendItem.msg_anchor.get();
                            String str = nowQQLiveHomepageProto$RcmdAnchor.string_id.get();
                            if (str != null && str.equals(BaseApplicationImpl.getApplication().getRuntime().getAccount())) {
                                QLog.d(this.f25811a, 2, "\u4e3b\u9875\u8fc7\u6ee4\u81ea\u5df1");
                            } else {
                                d h16 = h(nowQQLiveHomepageProto$RcmdAnchor);
                                h16.f25826a = nowQQLiveHomepageProto$RecommendItem.string_key.get();
                                int i17 = this.f25815e;
                                this.f25815e = i17 + 1;
                                h16.f25827b = i17;
                                h16.D = nowQQLiveHomepageProto$RcmdAnchor.union_channel_sign.get();
                                QLog.d(this.f25811a, 2, "NewRcmdDataMgr, parseData()  Double----anchor_union_channel_sign = " + h16.D);
                                this.f25822l.add(h16);
                            }
                        }
                    } else {
                        NowQQLiveHomepageProto$RcmdAnchor nowQQLiveHomepageProto$RcmdAnchor2 = nowQQLiveHomepageProto$RecommendItem.msg_anchor.get();
                        String str2 = nowQQLiveHomepageProto$RcmdAnchor2.string_id.get();
                        if (str2 != null && str2.equals(BaseApplicationImpl.getApplication().getRuntime().getAccount())) {
                            QLog.d(this.f25811a, 2, "\u4e3b\u9875\u8fc7\u6ee4\u81ea\u5df1");
                        } else {
                            d h17 = h(nowQQLiveHomepageProto$RcmdAnchor2);
                            h17.f25826a = nowQQLiveHomepageProto$RecommendItem.string_key.get();
                            int i18 = this.f25815e;
                            this.f25815e = i18 + 1;
                            h17.f25827b = i18;
                            h17.D = nowQQLiveHomepageProto$RcmdAnchor2.union_channel_sign.get();
                            this.f25822l.add(h17);
                        }
                    }
                }
            }
            QLog.d(this.f25811a, 2, "\u7b2c" + i3 + "\u5f00\u59cb\u62c9\u53d6:" + nowQQLiveHomepageProto$RecommendPageRsp.rpt_msg_rcmd.get().size() + "\u4e2a\u6570\u636e;" + this.f25822l.size() + "\u884c");
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return -1;
    }

    public void j(int i3, b bVar, boolean z16) {
        if (this.f25821k) {
            return;
        }
        if (z16) {
            int i16 = this.f25819i + 1;
            this.f25819i = i16;
            if (i16 >= 3) {
                bVar.onFailed();
                return;
            }
        }
        this.f25821k = true;
        NowQQLiveHomepageProto$RecommendPageReq nowQQLiveHomepageProto$RecommendPageReq = new NowQQLiveHomepageProto$RecommendPageReq();
        String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        if (TextUtils.isEmpty(account)) {
            return;
        }
        nowQQLiveHomepageProto$RecommendPageReq.uint32_last_update.set(this.f25816f);
        nowQQLiveHomepageProto$RecommendPageReq.uint32_index.set(i3);
        NowQQLiveHomepageProto$UserMsgInfo nowQQLiveHomepageProto$UserMsgInfo = new NowQQLiveHomepageProto$UserMsgInfo();
        nowQQLiveHomepageProto$UserMsgInfo.type.set(1);
        nowQQLiveHomepageProto$UserMsgInfo.desc.set(String.valueOf(2));
        ArrayList arrayList = new ArrayList();
        arrayList.add(nowQQLiveHomepageProto$UserMsgInfo);
        nowQQLiveHomepageProto$RecommendPageReq.user_msg_info.set(arrayList);
        nowQQLiveHomepageProto$RecommendPageReq.channel.set("78711");
        nowQQLiveHomepageProto$RecommendPageReq.rcmd_col_mode.set(f25810m);
        nowQQLiveHomepageProto$RecommendPageReq.device_id.set("");
        nowQQLiveHomepageProto$RecommendPageReq.qimei.set(o.b());
        nowQQLiveHomepageProto$RecommendPageReq.uin.set(Long.parseLong(account));
        nowQQLiveHomepageProto$RecommendPageReq.uint32_count.set(30);
        IQQLiveSDK sDKImpl = ((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).getSDKImpl(QQLiveSDKConfigHelper.getQQLiveAppId());
        if (sDKImpl == null) {
            QLog.e(this.f25811a, 2, "get liveSdk error, null");
            bVar.onFailed();
        } else {
            if (!sDKImpl.isInited()) {
                sDKImpl.init(MobileQQ.sMobileQQ.waitAppRuntime(null), QQLiveSDKConfigHelper.getDefIQQLiveSDK());
            }
            sDKImpl.getProxySsoService().sendQQLiveProxyReq("trpc.qlive.trpc_qlive_homepage.trpc_qlive_homepage", "cmd_get_home_page_data", nowQQLiveHomepageProto$RecommendPageReq.toByteArray(), new a(i3, bVar));
        }
    }
}
