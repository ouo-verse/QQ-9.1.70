package id;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.album.protocol.QZoneOptAlbumRequest;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.qzone.bean.init.QZoneAlbumxExpicPicInitBean;
import com.qzone.reborn.albumx.qzone.bean.init.QZoneAlbumxMediaListInitBean;
import com.qzone.reborn.intimate.bean.init.QZIntimateHistoryCalendarCardInitBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateAlbumDetailInitBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateAlbumSyncInitBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateMainPageInitBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateSelectAlbumInitBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateTaskDetailInitBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateUploadAlbumInitBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateWriteMoodInitBean;
import com.qzone.reborn.intimate.bean.init.Source;
import com.qzone.reborn.intimate.fragment.QZoneIntimateMessageFragment;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import com.tencent.upload.network.route.DebugServerRoute;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import nj.b;
import qzone.QZoneBaseAlbumMeta$AlbumInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b\u00a8\u0006\r"}, d2 = {"Lid/al;", "Lid/b;", "Landroid/content/Context;", "context", "", "Lhd/b;", "a", "d", "", "", ExifInterface.LATITUDE_SOUTH, "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class al extends b {

    /* renamed from: a, reason: collision with root package name */
    public static final al f407474a = new al();

    al() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        QZoneAlbumxExpicPicInitBean qZoneAlbumxExpicPicInitBean = new QZoneAlbumxExpicPicInitBean();
        qZoneAlbumxExpicPicInitBean.setPhotoStatus(1);
        ho.i.y().b(context, qZoneAlbumxExpicPicInitBean);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        QZoneIntimateAlbumDetailInitBean qZoneIntimateAlbumDetailInitBean = new QZoneIntimateAlbumDetailInitBean();
        qZoneIntimateAlbumDetailInitBean.setSpaceId("B_AERmqFvNVoSsbPSytMN9Ks");
        qZoneIntimateAlbumDetailInitBean.setAlbumId("V52V0QR72kaSvR3ztefQ3WYJQg0xvoKk");
        ho.i.o().i(context, qZoneIntimateAlbumDetailInitBean);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        ho.i.o().m(context, LoginData.getInstance().getUin());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        String str = f407474a.S().get(LoginData.getInstance().getUinString());
        ck.c o16 = ho.i.o();
        QZoneIntimateAlbumSyncInitBean qZoneIntimateAlbumSyncInitBean = new QZoneIntimateAlbumSyncInitBean();
        if (str == null) {
            str = "";
        }
        qZoneIntimateAlbumSyncInitBean.setSpaceId(str);
        String a16 = com.qzone.util.l.a(R.string.v7g);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qzone_int\u2026te_album_sync_title_text)");
        qZoneIntimateAlbumSyncInitBean.setTitle(a16);
        Unit unit = Unit.INSTANCE;
        o16.l(context, qZoneIntimateAlbumSyncInitBean);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        QZoneIntimateAlbumDetailInitBean qZoneIntimateAlbumDetailInitBean = new QZoneIntimateAlbumDetailInitBean();
        qZoneIntimateAlbumDetailInitBean.setSpaceId("B_TLExyMD5qKSVyQcA2gvoam");
        qZoneIntimateAlbumDetailInitBean.setAlbumId("V50Dkges2fHvlh1GREGA06HTeX441GcW");
        qZoneIntimateAlbumDetailInitBean.setBatchId(1686729774387L);
        qZoneIntimateAlbumDetailInitBean.setSearchType(2);
        ho.i.o().q(context, qZoneIntimateAlbumDetailInitBean);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        nj.b bVar = new nj.b(context);
        bVar.q0(new a());
        bVar.show();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        new nj.e(context, new com.qzone.reborn.intimate.bean.init.a()).show();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        ho.i.d(context, "/qzone/holder_page").withString("public_fragment_class", QZoneIntimateMessageFragment.class.getName()).request();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        ho.i.o().n(context, new QZoneIntimateSelectAlbumInitBean("B_AERmqFvNVoSsbPSytMN9Ks", Source.DISSOLUTION_RELATIONSHIP, null, 4, null));
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.qzone.reborn.util.i.b().l("CAN_SHOW_INTIMATE_AT_SYNC_GUIDE", true);
        com.qzone.reborn.util.i.b().l("CAN_SHOW_INTIMATE_TRANSFER_DATA_UNDERWAY", true);
        com.qzone.reborn.util.i.b().p("INTIMATE_TRANSFER_DATA_GUIDE_CLOSE_TIMES", 0L);
        com.qzone.reborn.util.i.b().l("CAN_SHOW_INTIMATE_CHECK_IN_REMIND", true);
        com.qzone.reborn.util.i.b().l("key_enable_show_check_in_remind_dialog", true);
        QQToastUtil.showQQToastInUiThread(5, "\u91cd\u7f6e\u6210\u529f");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        ho.i.y().d(context, new QZoneAlbumxMediaListInitBean());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        QZIntimateHistoryCalendarCardInitBean qZIntimateHistoryCalendarCardInitBean = new QZIntimateHistoryCalendarCardInitBean();
        qZIntimateHistoryCalendarCardInitBean.setSpaceId("L_42MFgAEn6Kx1FT1A459rf4");
        qZIntimateHistoryCalendarCardInitBean.setCheckDate("2024-09-12");
        ho.i.o().b(context, qZIntimateHistoryCalendarCardInitBean);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        String str = f407474a.S().get(LoginData.getInstance().getUinString());
        if (str == null) {
            str = "";
        }
        QZoneIntimateMainPageInitBean qZoneIntimateMainPageInitBean = new QZoneIntimateMainPageInitBean();
        qZoneIntimateMainPageInitBean.setSpaceId(str);
        qZoneIntimateMainPageInitBean.setFrom("0");
        ho.i.o().r(context, qZoneIntimateMainPageInitBean);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(Context context, View view) {
        Object obj;
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        Iterator<T> it = f407474a.S().entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (!Intrinsics.areEqual(((Map.Entry) obj).getKey(), LoginData.getInstance().getUinString())) {
                    break;
                }
            }
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry == null || (str = (String) entry.getValue()) == null) {
            str = "";
        }
        QZoneIntimateMainPageInitBean qZoneIntimateMainPageInitBean = new QZoneIntimateMainPageInitBean();
        qZoneIntimateMainPageInitBean.setSpaceId(str);
        qZoneIntimateMainPageInitBean.setFrom("0");
        ho.i.o().r(context, qZoneIntimateMainPageInitBean);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(String debugUploadSpaceId, Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(debugUploadSpaceId, "$debugUploadSpaceId");
        Intrinsics.checkNotNullParameter(context, "$context");
        QZoneIntimateWriteMoodInitBean qZoneIntimateWriteMoodInitBean = new QZoneIntimateWriteMoodInitBean();
        qZoneIntimateWriteMoodInitBean.setSpaceId(debugUploadSpaceId);
        qZoneIntimateWriteMoodInitBean.setSpaceType(0);
        ho.i.o().u(context, qZoneIntimateWriteMoodInitBean);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(Context context, String debugUploadSpaceId, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(debugUploadSpaceId, "$debugUploadSpaceId");
        ho.i.o().y(context, new QZoneIntimateUploadAlbumInitBean(debugUploadSpaceId, 0, false, null, 14, null));
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(Context context, String debugUploadSpaceId, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(debugUploadSpaceId, "$debugUploadSpaceId");
        ho.i.o().x(context, new QZoneIntimateTaskDetailInitBean(debugUploadSpaceId, null, null, 6, null));
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        QZoneIntimateAlbumDetailInitBean qZoneIntimateAlbumDetailInitBean = new QZoneIntimateAlbumDetailInitBean();
        qZoneIntimateAlbumDetailInitBean.setSpaceId("B_AERmqFvNVoSsbPSytMN9Ks");
        qZoneIntimateAlbumDetailInitBean.setAlbumId("V52V0QR72kaSvR3ztefQ3WYJQg0xvoKk");
        qZoneIntimateAlbumDetailInitBean.setSpaceType(0);
        ho.i.o().j(context, qZoneIntimateAlbumDetailInitBean);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        if (z16) {
            IUploadService uploadServiceBuilder = UploadServiceBuilder.getInstance();
            DebugServerRoute debugServerRoute = DebugServerRoute.CUSTOM;
            debugServerRoute.setServerIp("106.53.137.23");
            debugServerRoute.setServerPort(TVKEventId.PLAYER_STATE_SPEED_RATIO_CHANGED);
            uploadServiceBuilder.setDebugServerRoute(debugServerRoute);
        } else {
            UploadServiceBuilder.getInstance().setDebugServerRoute(null);
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        ho.i.y().g(context, new QZoneAlbumxMediaListInitBean());
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // id.b
    public List<hd.b> a(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new hd.a("\u7a7a\u95f4\u76f8\u518cX\u5a92\u4f53\u5c55\u793a\u9875", new View.OnClickListener() { // from class: id.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                al.z(context, view);
            }
        }));
        arrayList.add(new hd.a("\u7a7a\u95f4\u8fc7\u671f\u76f8\u518c\u9875", new View.OnClickListener() { // from class: id.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                al.A(context, view);
            }
        }));
        arrayList.add(new hd.a("\u4e3a\u4f60\u63a8\u8350\u5a92\u4f53\u9875", new View.OnClickListener() { // from class: id.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                al.K(context, view);
            }
        }));
        arrayList.add(new hd.a("\u4e3b\u9875(\u4e3b\u6001)", new View.OnClickListener() { // from class: id.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                al.M(context, view);
            }
        }));
        arrayList.add(new hd.a("\u4e3b\u9875(\u5ba2\u6001)", new View.OnClickListener() { // from class: id.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                al.N(context, view);
            }
        }));
        final String str = "B_Kr4muMGsN7bViqfSevUDEo";
        arrayList.add(new hd.a("\u53d1\u8bf4\u8bf4", new View.OnClickListener() { // from class: id.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                al.O(str, context, view);
            }
        }));
        arrayList.add(new hd.a("\u4e0a\u4f20\u76f8\u518c", new View.OnClickListener() { // from class: id.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                al.P(context, str, view);
            }
        }));
        arrayList.add(new hd.a("\u4efb\u52a1\u8be6\u60c5\u9875", new View.OnClickListener() { // from class: id.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                al.Q(context, str, view);
            }
        }));
        arrayList.add(new hd.a("\u76f8\u518c\u8be6\u60c5\u9875", new View.OnClickListener() { // from class: id.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                al.R(context, view);
            }
        }));
        arrayList.add(new hd.a("\u76f8\u518c\u6279\u91cf\u4e0b\u8f7d\u9875", new View.OnClickListener() { // from class: id.aa
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                al.B(context, view);
            }
        }));
        arrayList.add(new hd.a("\u5bc6\u53cb\u76f8\u518ctab", new View.OnClickListener() { // from class: id.ac
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                al.C(context, view);
            }
        }));
        arrayList.add(new hd.a("\u5bc6\u53cb\u76f8\u518c\u540c\u6b65\u9875", new View.OnClickListener() { // from class: id.ad
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                al.D(context, view);
            }
        }));
        arrayList.add(new hd.a("Feed\u591a\u56fe/\u591a\u89c6\u9891\u5c55\u793a\u9875", new View.OnClickListener() { // from class: id.ae
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                al.E(context, view);
            }
        }));
        arrayList.add(new hd.a("\u521b\u5efa\u76f8\u518c\u5f39\u7a97", new View.OnClickListener() { // from class: id.af
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                al.F(context, view);
            }
        }));
        arrayList.add(new hd.a("\u8001\u7528\u6237\u8fdb\u60c5\u4fa3\u7a7a\u95f4\u5f15\u5bfc\u5f39\u7a97", new View.OnClickListener() { // from class: id.ag
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                al.G(context, view);
            }
        }));
        arrayList.add(new hd.a("\u6d88\u606f\u9875", new View.OnClickListener() { // from class: id.ah
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                al.H(context, view);
            }
        }));
        arrayList.add(new hd.a("\u89e3\u6563\u5173\u7cfb\u9009\u62e9\u76f8\u518c\u9875", new View.OnClickListener() { // from class: id.ai
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                al.I(context, view);
            }
        }));
        arrayList.add(new hd.a("\u91cd\u7f6e\u9996\u9875\u5f15\u5bfc\u6761\u5c55\u793a\u7f13\u5b58", new View.OnClickListener() { // from class: id.aj
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                al.J(view);
            }
        }));
        arrayList.add(new hd.a("\u6d4b\u8bd5\u65e5\u7b7e\u5386\u53f2\u5361", new View.OnClickListener() { // from class: id.ak
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                al.L(context, view);
            }
        }));
        return arrayList;
    }

    @Override // id.b
    public List<hd.b> d(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new hd.d("\u4e2a\u4eba\u4e3b\u9875\u5c55\u793a\u5bc6\u53cb\u7a7a\u95f4\u5165\u53e3", "KEY_OPEN_USER_HOME_INTIMATE_ENTRANCE", false, null, 8, null));
        arrayList.add(new hd.d("\u6253\u5f00\u4e0a\u4f20\u6d4b\u8bd5\u73af\u5883", "KEY_OPEN_UPLOAD_DEBUG_ENV", false, new CompoundButton.OnCheckedChangeListener() { // from class: id.ab
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                al.T(compoundButton, z16);
            }
        }));
        arrayList.add(new hd.d("\u4e3b\u6001\u76f8\u518c\u540c\u6b65\u9891\u63a7\u5f00\u5173", "KEY_OPEN_INTIMATE_ALBUM_SYNC_ENABLE", false, null, 8, null));
        arrayList.add(new hd.d("\u4eb2\u5bc6\u7a7a\u95f4h5\u8df3\u534a\u5c4f\u6d6e\u5c42", "KEY_OPEN_INTIMATE_HALF_SCREEN_WEB", false, null, 8, null));
        arrayList.add(new hd.d("\u4eb2\u5bc6\u7a7a\u95f4\u6fc0\u6d3b\u9875\u8df3\u8f6cnative", "KEY_OPEN_NATIVE_ACTIVATE_SPACE_PAGE", false, null, 8, null));
        arrayList.add(new hd.d("\u8fdb\u7a7a\u95f4\u9996\u9875\u81ea\u52a8\u5f39\u661f\u94bb\u9886\u53d6\u5f39\u7a97", "KEY_OPEN_AUTO_VIP_DIALOG_SHOW", false, null, 8, null));
        arrayList.add(new hd.d("\u65e0\u9650\u5c55\u793a\u6253\u5361\u52a8\u753b", "KEY_CHECK_IN_ANIM_REPLACE_LAUNCH_PUNCH_DETAIL", false, null, 8, null));
        arrayList.add(new hd.d("\u65e5\u7b7e\u5206\u4eabark\u5f00\u542f", "KEY_CHECK_IN_ARK_SHARE", false, null, 8, null));
        arrayList.add(new hd.d("\u9996\u9875\u5c55\u793avip\u88c5\u626e", "KEY_MAIN_PAGE_VIP", false, null, 8, null));
        arrayList.add(new hd.d("\u7ba1\u7406\u9875\u5c55\u793avip\u88c5\u626e", "KEY_MANAGE_PAGE_VIP", false, null, 8, null));
        return arrayList;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"id/al$a", "Lnj/b$b;", "", "isSuccess", "Lqzone/QZoneBaseAlbumMeta$AlbumInfo;", "albumInfo", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a implements b.InterfaceC10848b {
        a() {
        }

        @Override // nj.b.InterfaceC10848b
        public void a(boolean isSuccess, QZoneBaseAlbumMeta$AlbumInfo albumInfo) {
            String str;
            if (albumInfo == null) {
                str = "";
            } else {
                str = "name:" + albumInfo.name.get() + ", desc:" + albumInfo.desc.get() + ", spaceId:" + albumInfo.owner.get();
            }
            QLog.d(QZoneOptAlbumRequest.FIELD_CMD_CREATE, 1, "isSuccess" + isSuccess + ", albumInfo -> " + str);
        }
    }

    public final Map<String, String> S() {
        Map<String, String> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("3587745282", "L_9AjxCnJbwRBMqTSXDU2tuc"), TuplesKt.to("610740026", "L_9AjxCnJbwRBMqTSXDU2tuc"), TuplesKt.to("123456", "B_LtvcxeSQvYXzRCUX7htbx4"), TuplesKt.to("2193211782", "u_7xgxdijbOpsy5r3OyWScCg"), TuplesKt.to("1715617521", "B_UwkgnjxQfDHzLtFmaJxvRP"), TuplesKt.to("885697461", "L_NGQ6MAywUbrGPBW2epd4pP"), TuplesKt.to("729147580", "L_TaPWqacErDiiaHNtGq4KzE"), TuplesKt.to("3447981359", "L_TaPWqacErDiiaHNtGq4KzE"), TuplesKt.to("3251200479", "B_EyB5acG2PjoUXTDGz3iebq"), TuplesKt.to("1298870462", "B_7yjBxKvYDPkd9wYyBG6Kp4"), TuplesKt.to("2174635974", "L_XAtEfBAwqFTq7YoL1LW8gM"), TuplesKt.to("729147580", "L_TaPWqacErDiiaHNtGq4KzE"), TuplesKt.to("3562546042", "B_Kr4muMGsN7bViqfSevUDEo"), TuplesKt.to("424445384", "L_BHDaasCS1Cw58K25H3jKzr"), TuplesKt.to("1002000329", "B_UqCcyiWPqT8mt7scdu23xr"), TuplesKt.to("1575000515", "B_M5byHQyr9bf6HZb5T1Wpdf"), TuplesKt.to("2202001853", "B_M5byHQyr9bf6HZb5T1Wpdf"), TuplesKt.to("3098927033", "B_9XjjJtb3W37UuThJbTFBNb"), TuplesKt.to("1774187786", "B_9XjjJtb3W37UuThJbTFBNb"));
        return mutableMapOf;
    }
}
