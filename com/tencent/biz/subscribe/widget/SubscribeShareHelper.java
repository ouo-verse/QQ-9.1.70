package com.tencent.biz.subscribe.widget;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StShare;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite$StDelFeedRsp;
import NS_COMM.COMM;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qrcode.util.h;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.event.SharePanelShowStateEvent;
import com.tencent.biz.subscribe.event.SubscribeFeedsEvent;
import com.tencent.biz.subscribe.network.SubscribeDeleteFeedRequest;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.data.SerializableMap;
import com.tencent.mobileqq.search.config.SearchConfig;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.i;
import com.tencent.mobileqq.utils.QQCustomArkDialog;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.util.QQCustomArkDialogUtil;
import common.config.service.QzoneConfig;
import cooperation.qqfav.QfavBuilder;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SubscribeShareHelper {

    /* renamed from: j, reason: collision with root package name */
    public static String f96434j = "certified_account=1";

    /* renamed from: a, reason: collision with root package name */
    public Activity f96435a;

    /* renamed from: b, reason: collision with root package name */
    private WXShareHelper.a f96436b;

    /* renamed from: c, reason: collision with root package name */
    private String f96437c;

    /* renamed from: d, reason: collision with root package name */
    private QQProgressDialog f96438d;

    /* renamed from: e, reason: collision with root package name */
    private ve0.b f96439e;

    /* renamed from: f, reason: collision with root package name */
    private SubscribeQRCodeShareHelper f96440f;

    /* renamed from: g, reason: collision with root package name */
    private IColorNoteController f96441g;

    /* renamed from: h, reason: collision with root package name */
    private ShareActionSheet f96442h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f96443i;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements DialogInterface.OnDismissListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            SimpleEventBus.getInstance().dispatchEvent(new SharePanelShowStateEvent(false));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c implements VSDispatchObserver.OnVSRspCallBack<CertifiedAccountWrite$StDelFeedRsp> {
        c() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, CertifiedAccountWrite$StDelFeedRsp certifiedAccountWrite$StDelFeedRsp) {
            Activity activity = SubscribeShareHelper.this.f96435a;
            if (activity == null) {
                return;
            }
            if (z16 && j3 == 0) {
                SimpleEventBus.getInstance().dispatchEvent(new SubscribeFeedsEvent(SubscribeShareHelper.this.f96439e.f441502b.f24925id.get(), 3));
                SubscribeShareHelper.this.f96435a.finish();
                QQToast.makeText(SubscribeShareHelper.this.f96435a, HardCodeUtil.qqStr(R.string.tx8), 0).show();
                return;
            }
            QQToast.makeText(activity, 1, HardCodeUtil.qqStr(R.string.txb), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class d implements WXShareHelper.a {
        d() {
        }

        @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
        public void onWXShareResp(BaseResp baseResp) {
            int i3;
            if (SubscribeShareHelper.this.f96437c != null && SubscribeShareHelper.this.f96437c.equals(baseResp.transaction) && (i3 = baseResp.errCode) != -2) {
                if (i3 != 0) {
                    QQToast.makeText(SubscribeShareHelper.this.f96435a, 1, HardCodeUtil.qqStr(R.string.txa), 0).show();
                } else {
                    QQToast.makeText(SubscribeShareHelper.this.f96435a, 2, HardCodeUtil.qqStr(R.string.txc), 0).show();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface e {
        void onClick(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class f implements ShareActionSheet.OnItemClickListener {

        /* renamed from: d, reason: collision with root package name */
        private final e f96455d;

        public f(e eVar) {
            this.f96455d = eVar;
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
        public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            SubscribeShareHelper.this.q();
            if (SubscribeShareHelper.this.f96439e != null && SubscribeShareHelper.this.f96435a != null) {
                int i3 = actionSheetItem.action;
                e eVar = this.f96455d;
                if (eVar != null) {
                    eVar.onClick(i3);
                }
                if (i3 == 2) {
                    SubscribeShareHelper.this.P();
                } else if (i3 == 3) {
                    SubscribeShareHelper.this.Q();
                } else if (i3 == 6) {
                    SubscribeShareHelper.this.n();
                } else if (i3 == 40) {
                    SubscribeShareHelper.this.p();
                } else if (i3 != 70) {
                    if (i3 != 82) {
                        if (i3 != 157) {
                            switch (i3) {
                                case 9:
                                case 10:
                                    SubscribeShareHelper.this.S(i3);
                                    break;
                                case 11:
                                    SubscribeShareHelper.this.R();
                                    break;
                                default:
                                    switch (i3) {
                                        case 152:
                                            if (SubscribeShareHelper.this.f96439e != null && SubscribeShareHelper.this.f96439e.f441502b != null) {
                                                com.tencent.biz.subscribe.d.l(QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QQ_SUBSCRIBE_SETTING, QzoneConfig.SECONDARY_FANS_GROUP_CONFIG_ENTRANCE_URL, QzoneConfig.DEFAULT_SUBSCRIBE_PERSONAL_SHARE_FAN_GROUP_URL).replace("{uin}", SubscribeShareHelper.this.f96439e.f441502b.poster.f24929id.get()));
                                                VSReporter.n(SubscribeShareHelper.this.f96439e.f441502b.poster.f24929id.get(), "auth_share", "clk_fan", 0, 0, new String[0]);
                                                break;
                                            }
                                            break;
                                        case 153:
                                            SubscribeShareHelper.this.f96440f.B(SubscribeShareHelper.this.f96439e);
                                            if (SubscribeShareHelper.this.f96439e != null && SubscribeShareHelper.this.f96439e.f441502b != null) {
                                                VSReporter.n(SubscribeShareHelper.this.f96439e.f441502b.poster.f24929id.get(), "auth_share", "clk_pic", 0, 0, null, null, SubscribeShareHelper.this.f96439e.f(), SubscribeShareHelper.this.f96439e.h());
                                                break;
                                            }
                                            break;
                                        case 154:
                                            com.tencent.biz.subscribe.d.l("https://h5.qzone.qq.com/subscription/syncFeeds/{uin}?_proxy=1&_wv=3".replace("{uin}", SubscribeShareHelper.this.f96439e.f441502b.poster.f24929id.get()));
                                            VSReporter.p(SubscribeShareHelper.this.f96439e.f441502b.poster.f24929id.get(), "auth_share", "sync_qzone", 0, 0, new String[0]);
                                            break;
                                        case 155:
                                            if (SubscribeShareHelper.this.f96439e != null && SubscribeShareHelper.this.f96439e.f441502b != null) {
                                                com.tencent.biz.subscribe.d.l(SubscribeShareHelper.this.f96439e.f441502b.poster.yzOrderPage.get());
                                                VSReporter.p(SubscribeShareHelper.this.f96439e.f441502b.poster.f24929id.get(), "auth_share", "clk_shoplist", 0, 0, new String[0]);
                                                break;
                                            }
                                            break;
                                    }
                            }
                        } else if (SubscribeShareHelper.this.f96439e != null && SubscribeShareHelper.this.f96439e.f441502b != null) {
                            VSReporter.n(SubscribeShareHelper.this.f96439e.f441502b.poster.f24929id.get(), "auth_share", "clk_shop", 0, 0, new String[0]);
                            com.tencent.biz.subscribe.d.l(com.tencent.biz.subscribe.b.c(SubscribeShareHelper.this.f96439e.f441502b.poster.f24929id.get()));
                        }
                    } else if (SubscribeShareHelper.this.f96441g != null && SubscribeShareHelper.this.f96441g.isColorNoteExist()) {
                        QQToast.makeText(BaseApplication.getContext(), 2, BaseApplication.getContext().getResources().getString(R.string.imc), 5000).show();
                        SubscribeShareHelper.this.f96441g.deleteColorNote();
                        QLog.d("SubscribeShareHelper", 2, "mColorNoteController \uff1a delete colorNote");
                    }
                } else if (SubscribeShareHelper.this.f96441g != null) {
                    if (SubscribeShareHelper.this.f96441g.canAddColorNote()) {
                        QLog.d("SubscribeShareHelper", 2, "mColorNoteController \uff1aadd colorNote");
                        SubscribeShareHelper.this.f96441g.insertColorNote();
                    } else {
                        SubscribeShareHelper.this.f96441g.onCannotAdd();
                    }
                }
                if (i3 != 11 && i3 != 40 && SubscribeShareHelper.this.f96439e != null) {
                    SubscribeShareHelper subscribeShareHelper = SubscribeShareHelper.this;
                    subscribeShareHelper.N(subscribeShareHelper.f96439e.f441502b, i3 - 1, SubscribeShareHelper.this.f96439e.f441505e);
                }
            }
        }
    }

    public SubscribeShareHelper(Activity activity) {
        this(activity, null);
    }

    public static String A(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        return "mqqapi://qsubscribe/" + QCircleScheme.Q_CIRCLE_ACTION_OPEN_CIRCLE_CONTENT_DETAIL + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + "src_type=internal&version=1&uin=" + certifiedAccountMeta$StFeed.poster.f24929id.get() + "&feedId=" + certifiedAccountMeta$StFeed.f24925id.get() + "&type=" + certifiedAccountMeta$StFeed.type.get() + "&width=" + certifiedAccountMeta$StFeed.video.width.get() + "&height=" + certifiedAccountMeta$StFeed.video.height.get() + "&createtime=" + certifiedAccountMeta$StFeed.createTime.get();
    }

    public static String B(String str, String str2, String str3) {
        return "mqqapi://qsubscribe/openhomepage" + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + "src_type=internal&version=1&uid=" + str + "&nick=" + str2 + "&icon=" + str3;
    }

    public static String C(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        return String.format("https://h5.qzone.qq.com/subscription/carousel/%s?_proxy=1&_wv=16777217&_wwv=4&userid=%s&time=%d", certifiedAccountMeta$StFeed.f24925id.get(), certifiedAccountMeta$StFeed.poster.f24929id.get(), Long.valueOf(certifiedAccountMeta$StFeed.createTime.get()));
    }

    public static String D(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        return E(certifiedAccountMeta$StFeed.poster.f24929id.get());
    }

    public static String E(String str) {
        return String.format("https://h5.qzone.qq.com/subscription/homepage/%s?_proxy=1&_wv=16777217&_wwv=4", str);
    }

    public static String F(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        return String.format("https://h5.qzone.qq.com/subscription/imagedetail/%s?_proxy=1&_wv=16777217&_wwv=4&userid=%s&time=%d", certifiedAccountMeta$StFeed.f24925id.get(), certifiedAccountMeta$StFeed.poster.f24929id.get(), Long.valueOf(certifiedAccountMeta$StFeed.createTime.get()));
    }

    public static String G(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        return String.format("https://h5.qzone.qq.com/subscription/videodetail/%s?_proxy=1&_wv=16777217&_wwv=4&userid=%s&time=%d", certifiedAccountMeta$StFeed.f24925id.get(), certifiedAccountMeta$StFeed.poster.f24929id.get(), Long.valueOf(certifiedAccountMeta$StFeed.createTime.get()));
    }

    private void H(Activity activity) {
        if (this.f96438d == null) {
            this.f96438d = new QQProgressDialog(activity);
        }
    }

    private void I() {
        if (this.f96436b != null) {
            return;
        }
        this.f96436b = new d();
        WXShareHelper.b0().A(this.f96436b);
    }

    private boolean J() {
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed;
        ve0.b bVar = this.f96439e;
        if (bVar != null && (certifiedAccountMeta$StFeed = bVar.f441502b) != null) {
            return SubscribeUtils.o(certifiedAccountMeta$StFeed.poster.attr.get());
        }
        return false;
    }

    private void K(ArrayList<Integer> arrayList) {
        ve0.b bVar = this.f96439e;
        if (bVar != null && bVar.f441505e != null && J()) {
            int i3 = this.f96439e.f441505e.pageType;
            if (i3 == 7000 || i3 == 7001 || i3 == 8001) {
                arrayList.add(40);
            }
        }
    }

    private boolean L() {
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed;
        ve0.b bVar = this.f96439e;
        if (bVar != null && (certifiedAccountMeta$StFeed = bVar.f441502b) != null) {
            return SubscribeUtils.q(certifiedAccountMeta$StFeed.poster.attr.get());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed, int i3, ExtraTypeInfo extraTypeInfo) {
        if (certifiedAccountMeta$StFeed != null && !StringUtil.isEmpty(certifiedAccountMeta$StFeed.poster.f24929id.get()) && !StringUtil.isEmpty(certifiedAccountMeta$StFeed.f24925id.get()) && extraTypeInfo != null) {
            VSReporter.n(certifiedAccountMeta$StFeed.poster.f24929id.get(), "auth_share", "clk_" + s(extraTypeInfo), i3, 0, "", "", certifiedAccountMeta$StFeed.f24925id.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void P() {
        Intent intent;
        ExtraTypeInfo extraTypeInfo = this.f96439e.f441505e;
        int i3 = 21;
        if (extraTypeInfo != null) {
            int i16 = extraTypeInfo.pageType;
            if (i16 != 8001) {
                switch (i16) {
                    case 7000:
                        intent = w();
                        break;
                    case 7002:
                        intent = t();
                        i3 = 1;
                        break;
                }
                if (intent == null) {
                    Activity activity = this.f96435a;
                    if (activity != null) {
                        QQToast.makeText(activity, HardCodeUtil.qqStr(R.string.tx7), 0).show();
                        return;
                    }
                    return;
                }
                Activity activity2 = this.f96435a;
                if (activity2 != null) {
                    activity2.startActivityForResult(intent, i3);
                    return;
                }
                return;
            }
            intent = w();
            i3 = 1;
            if (intent == null) {
            }
        }
        intent = null;
        if (intent == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        SerializableMap serializableMap;
        List<COMM.Entry> list;
        Bundle bundle = new Bundle();
        bundle.putString("title", this.f96439e.h());
        bundle.putString("desc", x(this.f96439e));
        bundle.putString("detail_url", this.f96439e.d() + "&source=qzone");
        ArrayList<String> arrayList = new ArrayList<>(1);
        arrayList.add(this.f96439e.b());
        bundle.putStringArrayList("image_url", arrayList);
        bundle.putLong("req_share_id", 0L);
        CertifiedAccountMeta$StShare certifiedAccountMeta$StShare = this.f96439e.f441504d;
        if (certifiedAccountMeta$StShare != null && (list = certifiedAccountMeta$StShare.shareQzoneInfo.entrys.get()) != null && list.size() > 0) {
            serializableMap = new SerializableMap();
            HashMap hashMap = new HashMap();
            for (COMM.Entry entry : list) {
                hashMap.put(entry.key.get(), entry.value.get());
            }
            serializableMap.setMap(hashMap);
        } else {
            serializableMap = null;
        }
        bundle.putSerializable("share_qzone_info", serializableMap);
        QZoneShareManager.jumpToQzoneShare(String.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()), this.f96435a, bundle, (DialogInterface.OnDismissListener) null, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        ve0.b bVar = this.f96439e;
        com.tencent.biz.subscribe.d.l(u(bVar.f441502b, bVar.f441505e));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(final int i3) {
        int i16;
        ve0.b bVar = this.f96439e;
        if (bVar != null && this.f96435a != null) {
            final String d16 = bVar.d();
            final String o16 = o(this.f96439e.h());
            final String o17 = o(this.f96439e.c());
            final HashMap hashMap = new HashMap(1);
            if (d16 != null && !d16.isEmpty()) {
                if (!WXShareHelper.b0().e0()) {
                    i16 = R.string.f173257ih1;
                } else if (!WXShareHelper.b0().f0()) {
                    i16 = R.string.f173258ih2;
                } else {
                    i16 = -1;
                }
                if (i16 != -1) {
                    h.T(0, i16);
                    return;
                }
                I();
                final Runnable runnable = new Runnable() { // from class: com.tencent.biz.subscribe.widget.SubscribeShareHelper.4
                    @Override // java.lang.Runnable
                    public void run() {
                        int i17;
                        if (SubscribeShareHelper.this.f96438d != null && SubscribeShareHelper.this.f96438d.isShowing()) {
                            SubscribeShareHelper.this.f96438d.dismiss();
                        }
                        SubscribeShareHelper.this.f96437c = String.valueOf(System.currentTimeMillis());
                        Bitmap bitmap = (Bitmap) hashMap.remove("image");
                        WXShareHelper b06 = WXShareHelper.b0();
                        String str = SubscribeShareHelper.this.f96437c;
                        String str2 = o16;
                        String str3 = o17;
                        String str4 = d16;
                        if (i3 == 9) {
                            i17 = 0;
                        } else {
                            i17 = 1;
                        }
                        b06.L0(str, str2, bitmap, str3, str4, i17);
                    }
                };
                if (TextUtils.isEmpty(this.f96439e.b())) {
                    runnable.run();
                    return;
                }
                H(this.f96435a);
                this.f96438d.setMessage(R.string.c7z);
                this.f96438d.show();
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.subscribe.widget.SubscribeShareHelper.5
                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap decodeByteArray;
                        if (SubscribeShareHelper.this.f96439e == null) {
                            return;
                        }
                        byte[] openUrlForByte = HttpUtil.openUrlForByte(BaseApplication.getContext(), SubscribeShareHelper.this.f96439e.b(), "GET", null, null);
                        if (openUrlForByte != null && (decodeByteArray = BitmapFactory.decodeByteArray(openUrlForByte, 0, openUrlForByte.length)) != null) {
                            int width = decodeByteArray.getWidth();
                            int height = decodeByteArray.getHeight();
                            int i17 = width * height;
                            if (i17 > 8000) {
                                double sqrt = Math.sqrt(8000.0d / i17);
                                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, (int) (width * sqrt), (int) (height * sqrt), true);
                                decodeByteArray.recycle();
                                decodeByteArray = createScaledBitmap;
                            }
                            hashMap.put("image", decodeByteArray);
                        }
                        Activity activity = SubscribeShareHelper.this.f96435a;
                        if (activity != null) {
                            activity.runOnUiThread(runnable);
                        }
                    }
                }, 8, null, false);
                return;
            }
            QQToast.makeText(this.f96435a, 1, HardCodeUtil.qqStr(R.string.f172748tx4), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        String A;
        String str;
        ve0.b bVar = this.f96439e;
        if (bVar != null && bVar.f441502b != null && bVar.f441505e != null) {
            String h16 = bVar.h();
            this.f96439e.c();
            String b16 = this.f96439e.b();
            String i3 = this.f96439e.i();
            ve0.b bVar2 = this.f96439e;
            int i16 = bVar2.f441505e.pageType;
            if (i16 != 8001) {
                switch (i16) {
                    case 7000:
                    case 7001:
                        break;
                    case 7002:
                        A = bVar2.d();
                        str = A;
                        break;
                    default:
                        str = null;
                        break;
                }
                String f16 = this.f96439e.f();
                QfavBuilder.Z(3, h16, str, null, null, b16, null, null, false, -1L).F(i3).T("lCategory", 10L).m0("sUin", f16).m0("sName", f16).t(this.f96435a, BaseApplicationImpl.getApplication().getRuntime().getAccount(), 2, null);
            }
            A = A(bVar2.f441502b);
            str = A;
            String f162 = this.f96439e.f();
            QfavBuilder.Z(3, h16, str, null, null, b16, null, null, false, -1L).F(i3).T("lCategory", 10L).m0("sUin", f162).m0("sName", f162).t(this.f96435a, BaseApplicationImpl.getApplication().getRuntime().getAccount(), 2, null);
        }
    }

    public static String o(String str) {
        if (str == null) {
            return "";
        }
        if (str.length() <= 30 && str.getBytes().length <= 100) {
            return str;
        }
        if (str.length() > 30) {
            str = str.substring(0, 30);
        }
        if (Math.min(str.getBytes().length, 100) == 100) {
            int length = str.length() / 2;
            StringBuilder sb5 = new StringBuilder(str.substring(0, length));
            while (sb5.toString().getBytes().length < 100) {
                sb5.append(str.charAt(length));
                length++;
            }
            str = sb5.toString();
        }
        return str + MiniBoxNoticeInfo.APPNAME_SUFFIX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        ve0.b bVar = this.f96439e;
        if (bVar != null && bVar.f441502b != null) {
            VSNetworkHelper.getInstance().sendRequest(new SubscribeDeleteFeedRequest(this.f96439e.f441502b), new c());
            try {
                VSReporter.n(this.f96439e.i(), "auth_share", "delete", 0, 0, "", "", this.f96439e.f441504d.author.get().nick.get(), this.f96439e.h());
            } catch (Exception unused) {
            }
        }
    }

    private List<ShareActionSheetBuilder.ActionSheetItem>[] r(List<Integer>[] listArr) {
        List<ShareActionSheetBuilder.ActionSheetItem>[] listArr2 = new List[listArr.length];
        for (int i3 = 0; i3 < listArr.length; i3++) {
            ArrayList arrayList = new ArrayList();
            Iterator<Integer> it = listArr[i3].iterator();
            while (it.hasNext()) {
                arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(it.next().intValue()));
            }
            listArr2[i3] = arrayList;
        }
        return listArr2;
    }

    public static String s(ExtraTypeInfo extraTypeInfo) {
        if (extraTypeInfo == null) {
            return "";
        }
        int i3 = extraTypeInfo.pageType;
        if (i3 != 8001) {
            switch (i3) {
                case 7000:
                    return "video";
                case 7001:
                    return "multi_pic";
                case 7002:
                    return "person";
                default:
                    return "";
            }
        }
        return "image";
    }

    private Intent t() {
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed;
        ve0.b bVar = this.f96439e;
        if (bVar != null && (certifiedAccountMeta$StFeed = bVar.f441502b) != null && !TextUtils.isEmpty(certifiedAccountMeta$StFeed.poster.nick.get())) {
            Intent intent = new Intent();
            if (QLog.isColorLevel()) {
                QLog.d("forward", 2, "ShareActionSheet shareToFriend");
            }
            intent.putExtra("isWebCompShare", true);
            intent.setClass(this.f96435a.getApplicationContext(), ForwardRecentActivity.class);
            intent.putExtra("key_flag_from_plugin", true);
            intent.putExtra("category", this.f96435a.getString(R.string.d7f));
            intent.putExtra("forward_type", 1001);
            intent.putExtra("detail_url", this.f96439e.d());
            intent.putExtra("title", this.f96439e.f());
            intent.putExtra("forward _key_nojump", true);
            intent.putExtra(AppConstants.Key.SHARE_BRIEF, BaseApplication.getContext().getString(R.string.f171308dy0, this.f96439e.f()));
            intent.putExtra("desc", o(this.f96439e.e()));
            intent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 1);
            intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_CONTENT_ACTION, "plugin");
            intent.putExtra(IPublicAccountJavascriptInterface.KEY_PUB_UIN, this.f96439e.f441502b.poster.f24929id.get());
            intent.putExtra("pluginName", SearchConfig.ENGINE_PUBLIC_ACCOUNT);
            intent.putExtra(IPublicAccountJavascriptInterface.KEY_PUB_UIN, this.f96439e.f441502b.poster.f24929id.get());
            intent.putExtra(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL, this.f96439e.f441502b.poster.icon.get());
            intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_CONTENT_ACTION_DATA, B(this.f96439e.f441502b.poster.f24929id.get(), this.f96439e.f441502b.poster.nick.get(), this.f96439e.f441502b.poster.icon.get()));
            AbsStructMsg e16 = i.e(intent.getExtras());
            if (e16 != null) {
                e16.mMsgServiceID = 152;
                intent.putExtra(AppConstants.Key.STRUCT_MSG_BYTES, e16.getBytes());
                intent.putExtra(IPublicAccountDetailActivity.FROMADCARD, true);
                return intent;
            }
        }
        return null;
    }

    private static String u(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed, ExtraTypeInfo extraTypeInfo) {
        if (extraTypeInfo != null && extraTypeInfo.pageType == 7002) {
            return String.format("https://h5.qzone.qq.com/subscription/report/%s?_proxy=1&_wv=3&usertype=%s", certifiedAccountMeta$StFeed.poster.f24929id.get(), Integer.valueOf(certifiedAccountMeta$StFeed.poster.type.get()));
        }
        return String.format("https://h5.qzone.qq.com/subscription/report/%s?_proxy=1&_wv=3&userid=%s&usertype=%s", certifiedAccountMeta$StFeed.f24925id.get(), certifiedAccountMeta$StFeed.poster.f24929id.get(), Integer.valueOf(certifiedAccountMeta$StFeed.poster.type.get()));
    }

    private List<Integer> v(ve0.b bVar) {
        int i3;
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed;
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed2;
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed3;
        IColorNoteController iColorNoteController;
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (bVar != null && (certifiedAccountMeta$StFeed = bVar.f441502b) != null && bVar.f441505e != null) {
            certifiedAccountMeta$StFeed.type.get();
            int i16 = bVar.f441505e.pageType;
            if (this.f96435a != null && (iColorNoteController = this.f96441g) != null && iColorNoteController.shouldDisplayColorNote()) {
                if (this.f96441g.isColorNoteExist()) {
                    arrayList.add(82);
                } else {
                    arrayList.add(70);
                }
            }
            K(arrayList);
            if (i16 == 7002) {
                if (J()) {
                    Activity activity = this.f96435a;
                    if (activity != null) {
                        activity.getIntent().putExtra("big_brother_source_key", "biz_src_jc_dyh_mainhp");
                    }
                    if (L()) {
                        arrayList.add(155);
                        ve0.b bVar2 = this.f96439e;
                        if (bVar2 != null && (certifiedAccountMeta$StFeed3 = bVar2.f441502b) != null) {
                            VSReporter.p(certifiedAccountMeta$StFeed3.poster.f24929id.get(), "auth_share", "exp_shoplist", 0, 0, new String[0]);
                        }
                    }
                    if (this.f96443i) {
                        arrayList.add(157);
                        ve0.b bVar3 = this.f96439e;
                        if (bVar3 != null && (certifiedAccountMeta$StFeed2 = bVar3.f441502b) != null) {
                            VSReporter.n(certifiedAccountMeta$StFeed2.poster.f24929id.get(), "auth_share", "exp_shop", 0, 0, new String[0]);
                        }
                    }
                } else {
                    Activity activity2 = this.f96435a;
                    if (activity2 != null) {
                        activity2.getIntent().putExtra("big_brother_source_key", "biz_src_jc_dyh_guesthp");
                    }
                }
            } else if (this.f96435a != null) {
                if (J()) {
                    this.f96435a.getIntent().putExtra("big_brother_source_key", "biz_src_jc_dyh_main");
                } else {
                    this.f96435a.getIntent().putExtra("big_brother_source_key", "biz_src_jc_dyh_guest");
                }
            }
            if (bVar.f441506f && !J()) {
                arrayList.add(11);
            }
            int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QQ_SUBSCRIBE_SETTING, QzoneConfig.SECONDARY_FANS_GROUP_CONFIG_ENTRANCE, 1);
            if (i16 == 7002 && J() && config == 1) {
                arrayList.add(152);
            }
            if (i16 == 7002 && bVar.f441507g) {
                arrayList.add(154);
            }
        }
        ve0.b bVar4 = this.f96439e;
        if (bVar4 != null && bVar4.f441508h && ((i3 = bVar4.f441505e.pageType) == 7001 || i3 == 7002 || i3 == 7005 || i3 == 7000)) {
            arrayList.add(153);
        }
        return arrayList;
    }

    private Intent w() {
        CertifiedAccountMeta$StShare certifiedAccountMeta$StShare;
        ve0.b bVar = this.f96439e;
        if (bVar != null && (certifiedAccountMeta$StShare = bVar.f441504d) != null && !TextUtils.isEmpty(certifiedAccountMeta$StShare.shareCardInfo.get())) {
            Intent intent = new Intent(this.f96435a.getApplicationContext(), (Class<?>) ForwardRecentActivity.class);
            try {
                JSONObject jSONObject = new JSONObject(this.f96439e.f441504d.shareCardInfo.get());
                JSONObject jSONObject2 = jSONObject.getJSONObject("aio");
                JSONObject jSONObject3 = jSONObject.getJSONObject("popUp");
                String string = jSONObject2.getString("app");
                String string2 = jSONObject2.getString("ver");
                String string3 = jSONObject2.getString("view");
                String optString = jSONObject2.optString(QQCustomArkDialogUtil.BIZ_SRC);
                String string4 = jSONObject2.getString(PublicAccountMessageUtilImpl.META_NAME);
                String string5 = jSONObject2.getString("prompt");
                intent.putExtra("forward_type", 27);
                intent.putExtra("is_ark_display_share", true);
                intent.putExtra("forward_ark_app_name", string);
                intent.putExtra("forward_ark_app_view", string3);
                intent.putExtra("forward_ark_biz_src", optString);
                intent.putExtra("forward_ark_app_ver", string2);
                intent.putExtra("forward_ark_app_prompt", string5);
                intent.putExtra("forward_ark_app_meta", string4);
                String string6 = jSONObject3.getString("app");
                String string7 = jSONObject3.getString("ver");
                String string8 = jSONObject3.getString("view");
                String optString2 = jSONObject3.optString(QQCustomArkDialogUtil.BIZ_SRC);
                String string9 = jSONObject3.getString(PublicAccountMessageUtilImpl.META_NAME);
                jSONObject3.getString("prompt");
                intent.putExtras(QQCustomArkDialog.b.a(string6, string8, optString2, string7, string9, com.tencent.mobileqq.ark.f.c(), null, null));
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            return intent;
        }
        return null;
    }

    public static String x(ve0.b bVar) {
        if (bVar != null) {
            String c16 = bVar.c();
            ExtraTypeInfo extraTypeInfo = bVar.f441505e;
            if (extraTypeInfo != null) {
                int i3 = extraTypeInfo.pageType;
                if (i3 == 7002 || i3 == 7005) {
                    String str = bVar.a().poster.desc.get();
                    if (TextUtils.isEmpty(str) || str.equals(HardCodeUtil.qqStr(R.string.w8b)) || TextUtils.isEmpty(str.trim())) {
                        return HardCodeUtil.qqStr(R.string.w8a);
                    }
                    return str;
                }
                return c16;
            }
            return c16;
        }
        return "";
    }

    private List<Integer> y(ve0.b bVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(9);
        arrayList.add(10);
        ExtraTypeInfo extraTypeInfo = bVar.f441505e;
        if (extraTypeInfo == null) {
            return arrayList;
        }
        int i3 = extraTypeInfo.pageType;
        if (i3 == 7000 || i3 == 8001) {
            arrayList.add(6);
        }
        return arrayList;
    }

    @NotNull
    private List[] z(ve0.b bVar) {
        boolean z16;
        ve0.b bVar2;
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed;
        List<Integer> y16 = y(bVar);
        List<Integer> v3 = v(bVar);
        if (((String) VSConfigManager.c().e("is_open_sharing", "1")).equals("1") && (bVar2 = this.f96439e) != null && (certifiedAccountMeta$StFeed = bVar2.f441502b) != null && SubscribeUtils.r(certifiedAccountMeta$StFeed.status.get())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return new List[]{y16, v3};
        }
        return new List[]{v3};
    }

    public void M() {
        ShareActionSheet shareActionSheet = this.f96442h;
        if (shareActionSheet != null && shareActionSheet.isShowing()) {
            this.f96442h.dismiss();
        }
        WXShareHelper.b0().q0(this.f96436b);
        SubscribeQRCodeShareHelper subscribeQRCodeShareHelper = this.f96440f;
        if (subscribeQRCodeShareHelper != null) {
            subscribeQRCodeShareHelper.L();
        }
    }

    public void O(boolean z16) {
        ShareActionSheet shareActionSheet = this.f96442h;
        if (shareActionSheet != null) {
            shareActionSheet.setEnableNotTriggerVirtualNavigationBar(z16);
        }
    }

    public void T(ve0.b bVar, IColorNoteController iColorNoteController) {
        if (this.f96442h == null) {
            return;
        }
        if (bVar == null) {
            bVar = new ve0.b();
        }
        this.f96439e = bVar;
        this.f96441g = iColorNoteController;
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = bVar.f441502b;
        if (certifiedAccountMeta$StFeed != null && !TextUtils.isEmpty(certifiedAccountMeta$StFeed.poster.nick.get())) {
            List[] z16 = z(bVar);
            this.f96435a.getIntent().putExtra("big_brother_source_key", "biz_src_feeds_kandian");
            this.f96442h.setActionSheetItems(r(z16));
            this.f96442h.setRowVisibility(8, 0, 0);
            this.f96442h.show();
            SimpleEventBus.getInstance().dispatchEvent(new SharePanelShowStateEvent(true));
            return;
        }
        QQToast.makeText(this.f96435a, HardCodeUtil.qqStr(R.string.txh), 0).show();
    }

    public void q() {
        ShareActionSheet shareActionSheet = this.f96442h;
        if (shareActionSheet != null && shareActionSheet.isShowing()) {
            this.f96442h.dismiss();
        }
    }

    public SubscribeShareHelper(Activity activity, e eVar) {
        this.f96443i = Integer.parseInt(QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QQ_SUBSCRIBE_SETTING, QzoneConfig.SECONDARY_SHOW_SHOP_ENTRANCE, "0")) > 0;
        this.f96435a = activity;
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        param.context = activity;
        ShareActionSheet create = ShareActionSheetFactory.create(param);
        this.f96442h = create;
        create.setOnDismissListener(new a());
        this.f96442h.setCancelListener(new b());
        this.f96442h.setItemClickListenerV2(new f(eVar));
        if (this.f96440f == null) {
            this.f96440f = new SubscribeQRCodeShareHelper(this.f96435a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class b implements DialogInterface.OnCancelListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
        }
    }
}
