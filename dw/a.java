package dw;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.heytap.databaseengine.type.DataTableNameType;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.api.LaunchScene;
import com.tencent.mobileqq.mini.servlet.MiniAppObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tbs.reader.IReaderConstants;
import com.tencent.tbs.reader.ITbsReader;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: dw.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class ViewOnClickListenerC10203a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ VideoAppInterface f395057d;

        ViewOnClickListenerC10203a(VideoAppInterface videoAppInterface) {
            this.f395057d = videoAppInterface;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QLog.isColorLevel()) {
                QLog.i("AVTipsItemFactory", 2, "use cellular for quality tips click");
            }
            this.f395057d.k0(new Object[]{528});
            ReportController.o(null, "dc00898", "", "", "0X800C2AD", "0X800C2AD", 0, 0, "", "", "", "");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x001b. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x000f. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0015. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0018. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    public static b a(int i3, VideoAppInterface videoAppInterface) {
        d dVar;
        c cVar;
        e eVar;
        d dVar2;
        if (videoAppInterface == null) {
            return null;
        }
        Resources resources = videoAppInterface.getApp().getResources();
        switch (i3) {
            case 1001:
            case 1002:
            case 1003:
            case 1004:
            case 1005:
            case 1006:
            case 1007:
            case 1009:
            case 1014:
            case 1027:
            case 1038:
                return null;
            case 1008:
                dVar = new d(i3, 12, 4, 0, "");
                return dVar;
            case 1010:
                dVar2 = new d(i3, 15, 3, 0, "", 1, "");
                return dVar2;
            case 1011:
                dVar2 = new d(i3, 15, 3, 0, videoAppInterface.getApp().getString(R.string.d9x), 1, "");
                return dVar2;
            case 1012:
                dVar2 = new d(i3, 15, 3, 0, "", 1, "");
                return dVar2;
            case 1013:
                dVar = new d(i3, 99, 3, 0, videoAppInterface.getApp().getString(R.string.dll));
                return dVar;
            case 1015:
                dVar = new d(i3, 19, 3, 0, videoAppInterface.getApp().getString(R.string.dko));
                return dVar;
            case 1016:
                dVar = new d(i3, 13, 0, 0, "");
                return dVar;
            case 1017:
                dVar = new d(i3, 9, 5, 0, videoAppInterface.getApp().getString(R.string.dmm));
                return dVar;
            case 1018:
                dVar = new d(i3, 6, 4, 0, videoAppInterface.getApp().getString(R.string.djg));
                return dVar;
            case 1019:
                dVar2 = new d(i3, 6, 0, 0, videoAppInterface.getApp().getString(R.string.iec), 1, "");
                return dVar2;
            case 1020:
                dVar2 = new d(i3, 3, 0, 0, videoAppInterface.getApp().getString(R.string.dg6), 1, "");
                return dVar2;
            case 1021:
                dVar2 = new d(i3, 3, 3, 0, videoAppInterface.getApp().getString(R.string.dkz), 1, "");
                return dVar2;
            case 1022:
                dVar2 = new d(i3, 9, 3, 0, "", 1, "");
                return dVar2;
            case 1023:
                dVar2 = new d(i3, 9, 3, 0, "", 1, "");
                return dVar2;
            case 1024:
                dVar2 = new d(i3, 4, 4, 0, videoAppInterface.getApp().getString(R.string.d__), 1, "");
                return dVar2;
            case 1025:
                dVar = new d(i3, 12, 3, 0, "");
                return dVar;
            case 1026:
                dVar = new d(i3, 12, 5, 0, "");
                return dVar;
            case 1028:
                dVar2 = new d(i3, 16, 3, 0, videoAppInterface.getApp().getString(R.string.ido), 1, "");
                return dVar2;
            case 1029:
                dVar2 = new d(i3, 16, 3, 0, videoAppInterface.getApp().getString(R.string.f171249dg1), 1, "");
                return dVar2;
            case 1030:
                dVar2 = new d(i3, 22, 0, 0, videoAppInterface.getApp().getString(R.string.f173251ie4), 1, "");
                return dVar2;
            case 1031:
                dVar = new d(i3, 16, 3, 0, videoAppInterface.getApp().getString(R.string.f171250dg2));
                return dVar;
            case 1032:
                dVar2 = new d(i3, 16, 3, 0, videoAppInterface.getApp().getString(R.string.f171236dd4), 1, "");
                return dVar2;
            case 1033:
                dVar = new d(i3, 18, 5, 0, "");
                return dVar;
            case 1034:
                dVar = new d(i3, 18, 0, 0, "");
                return dVar;
            case 1035:
                cVar = new c(i3, 17, 0, 0, "", 0, -1, null);
                cVar.f395065l = 14;
                return cVar;
            case 1036:
                eVar = new e(i3, 2, 0, 0, videoAppInterface.getApp().getString(R.string.dbn), true);
                return eVar;
            case 1037:
                eVar = new e(i3, 2, 0, 0, "", true);
                return eVar;
            case 1039:
                dVar2 = new d(i3, 22, 0, 0, videoAppInterface.getApp().getString(R.string.d_u), 1, "");
                return dVar2;
            case 1040:
                e eVar2 = new e(i3, 14, 0, 0, videoAppInterface.getApp().getString(R.string.f171269dm3), true);
                eVar2.m(true);
                dVar2 = eVar2;
                return dVar2;
            case 1041:
                eVar = new e(i3, 14, 3, 0, "", true);
                return eVar;
            case 1042:
                dVar2 = new d(i3, 12, 3, 0, "", 1, "");
                return dVar2;
            case 1043:
                dVar = new d(i3, 12, 3, 0, resources.getString(R.string.d_x));
                return dVar;
            case 1044:
                cVar = new c(i3, 12, 3, 0, resources.getString(R.string.d_y), 9, 5, null);
                cVar.f395065l = 14;
                return cVar;
            case 1045:
                dVar = new d(i3, 12, 5, 0, "");
                return dVar;
            default:
                switch (i3) {
                    case 1047:
                        dVar = new d(i3, 2, 0, 0, videoAppInterface.getApp().getString(R.string.dks));
                        return dVar;
                    case 1048:
                        dVar = new d(i3, 14, 3, 0, "");
                        return dVar;
                    case 1049:
                        dVar = new d(i3, 15, 10, 0, HardCodeUtil.qqStr(R.string.jvh));
                        return dVar;
                    case 1050:
                        dVar = new d(i3, 14, 5, 0, HardCodeUtil.qqStr(R.string.jvi));
                        return dVar;
                    case 1051:
                        dVar2 = new d(i3, 99, 3, 0, HardCodeUtil.qqStr(R.string.jvg), 1, "");
                        return dVar2;
                    case 1052:
                        dVar2 = new d(i3, 99, 3, 0, HardCodeUtil.qqStr(R.string.jve), 1, "");
                        return dVar2;
                    case 1053:
                        dVar2 = new d(i3, 99, 3, 0, HardCodeUtil.qqStr(R.string.jvk), 1, "");
                        return dVar2;
                    case 1054:
                        dVar2 = new d(i3, 99, 3, 0, HardCodeUtil.qqStr(R.string.jvj), 1, "");
                        return dVar2;
                    case 1055:
                        dVar2 = new d(i3, 99, 3, 0, HardCodeUtil.qqStr(R.string.jvf), 1, "");
                        return dVar2;
                    case 1056:
                        dVar2 = new d(i3, 6, 3, 0, "", 1, "");
                        return dVar2;
                    case 1057:
                        dVar2 = new d(i3, 6, 3, 0, "", 1, "");
                        return dVar2;
                    case 1058:
                        dVar2 = new d(i3, 6, 3, 0, "", 1, "");
                        return dVar2;
                    case 1059:
                        dVar = new d(i3, 2, 3, 0, "");
                        return dVar;
                    case 1060:
                        dVar = new d(i3, 2, 3, 0, "");
                        return dVar;
                    case 1061:
                        dVar = new d(i3, 19, 3, 0, videoAppInterface.getApp().getString(R.string.f1784236m));
                        return dVar;
                    case 1062:
                        dVar = new d(i3, 8, 3, 0, videoAppInterface.getApp().getString(R.string.f170485z74));
                        return dVar;
                    case 1063:
                        dVar = new d(i3, 8, 3, 0, videoAppInterface.getApp().getString(R.string.z6r));
                        return dVar;
                    case DataTableNameType.TABLE_WRIST_TEMPERATURE_STAT /* 1064 */:
                        dVar = new d(i3, 8, 3, 0, videoAppInterface.getApp().getString(R.string.z75));
                        return dVar;
                    case DataTableNameType.TABLE_SPORT_METADATA /* 1065 */:
                        dVar = new d(i3, 8, 3, 0, videoAppInterface.getApp().getString(R.string.z6s));
                        return dVar;
                    case DataTableNameType.TABLE_SNORE_OSA_MODEL /* 1066 */:
                        dVar = new d(i3, 8, 3, 0, videoAppInterface.getApp().getString(R.string.d_t));
                        return dVar;
                    case 1067:
                        dVar = new d(i3, 8, 3, 0, videoAppInterface.getApp().getString(R.string.z6t));
                        return dVar;
                    case DataTableNameType.TABLE_DATA_COLLECTION /* 1068 */:
                        dVar = new d(i3, 8, 3, 0, videoAppInterface.getApp().getString(R.string.z6z));
                        return dVar;
                    case 1069:
                        dVar = new d(i3, 8, 3, 0, videoAppInterface.getApp().getString(R.string.z6u));
                        return dVar;
                    case 1070:
                        dVar = new d(i3, 6, 3, 0, videoAppInterface.getApp().getString(R.string.z6y));
                        return dVar;
                    case 1071:
                        dVar = new d(i3, 8, 3, 0, videoAppInterface.getApp().getString(R.string.z6v));
                        return dVar;
                    case 1072:
                        dVar = new d(i3, 8, 3, 0, videoAppInterface.getApp().getString(R.string.z6w));
                        return dVar;
                    case 1073:
                        dVar = new d(i3, 8, 3, 0, videoAppInterface.getApp().getString(R.string.f1780435l));
                        return dVar;
                    case 1074:
                        dVar = new d(i3, 8, 3, 0, videoAppInterface.getApp().getString(R.string.f1779235_));
                        return dVar;
                    case 1075:
                        dVar = new d(i3, 99, 3, 0, "");
                        return dVar;
                    case MiniAppObserver.MINI_APP_CREATE_UPDATABLE_MSG /* 1076 */:
                        dVar = new d(i3, 6, 3, 0, videoAppInterface.getApp().getString(R.string.f17753348));
                        return dVar;
                    case 1077:
                        dVar = new d(i3, 15, 3, 0, videoAppInterface.getApp().getString(R.string.f1780535m));
                        return dVar;
                    case 1078:
                        dVar = new d(i3, 15, 3, 0, videoAppInterface.getApp().getString(R.string.f1779335a));
                        return dVar;
                    default:
                        switch (i3) {
                            case 3001:
                                dVar = new d(i3, 22, 0, 0, "");
                                return dVar;
                            case 3002:
                                dVar2 = new d(i3, 19, 3, 0, videoAppInterface.getApp().getString(R.string.ato), 1, "");
                                return dVar2;
                            case 3003:
                                dVar2 = new d(i3, 19, 3, 0, videoAppInterface.getApp().getString(R.string.d9y), 1, "");
                                return dVar2;
                            case 3004:
                                dVar = new d(i3, 20, 3, 0, videoAppInterface.getApp().getString(R.string.f171264dl1));
                                return dVar;
                            case 3005:
                                dVar2 = new d(i3, 14, 0, 0, videoAppInterface.getApp().getString(R.string.d98), 1, "");
                                return dVar2;
                            case 3006:
                                dVar = new d(i3, 7, 0, 0, videoAppInterface.getApp().getString(R.string.f1781735y));
                                return dVar;
                            case 3007:
                                dVar = new d(i3, 7, 0, 0, videoAppInterface.getApp().getString(R.string.f1781835z));
                                return dVar;
                            case 3008:
                                dVar2 = new d(i3, 18, 3, 0, "", 1, "");
                                return dVar2;
                            case 3009:
                                dVar = new d(i3, 15, 3, 0, videoAppInterface.getApp().getString(R.string.dlp));
                                return dVar;
                            case 3010:
                                dVar = new d(i3, 15, 0, 0, videoAppInterface.getApp().getString(R.string.dky));
                                return dVar;
                            case 3011:
                                dVar = new d(i3, 19, 3, 0, "");
                                return dVar;
                            case 3012:
                                dVar = new d(i3, 19, 5, 0, "");
                                return dVar;
                            case 3013:
                                dVar = new d(i3, 14, 0, 0, videoAppInterface.getApp().getString(R.string.d_v));
                                return dVar;
                            case 3014:
                                eVar = new e(i3, 20, 0, 0, videoAppInterface.getApp().getString(R.string.d_t), true);
                                return eVar;
                            case 3015:
                                dVar2 = new d(i3, 14, 0, 0, videoAppInterface.getApp().getString(R.string.dku), 1, "");
                                return dVar2;
                            case 3016:
                                dVar = new d(i3, 20, 3, 0, videoAppInterface.getApp().getString(R.string.f1784436o));
                                return dVar;
                            case 3017:
                                dVar = new d(i3, 20, 3, 0, videoAppInterface.getApp().getString(R.string.f1784536p));
                                return dVar;
                            case ITbsReader.READER_EVENT_NIGHT_MODE_CHANGED /* 3018 */:
                                dVar = new d(i3, 20, 3, 0, videoAppInterface.getApp().getString(R.string.f1784336n));
                                return dVar;
                            default:
                                switch (i3) {
                                    case 3020:
                                        dVar = new d(i3, 6, 3, 0, videoAppInterface.getApp().getString(R.string.f1774433z));
                                        return dVar;
                                    case 3021:
                                        dVar = new d(i3, 1, 3, 0, "");
                                        return dVar;
                                    case 3022:
                                        eVar = new e(i3, 6, 0, 0, videoAppInterface.getApp().getString(R.string.f1779935g), true);
                                        return eVar;
                                    case 3023:
                                        eVar = new e(i3, 14, 3, 0, "", false);
                                        return eVar;
                                    case 3024:
                                        cVar = new c(i3, 1, 5, 0, resources.getString(R.string.f1784736r), 15, 3, new ViewOnClickListenerC10203a(videoAppInterface));
                                        cVar.f395065l = 14;
                                        return cVar;
                                    case IReaderConstants.READER_CB_ENTER_FIND_DONE /* 3025 */:
                                        dVar = new d(i3, 8, 3, 0, videoAppInterface.getApp().getString(R.string.f228166t0));
                                        return dVar;
                                    case 3026:
                                        dVar2 = new d(i3, 23, 0, 0, videoAppInterface.getApp().getString(R.string.f17862376), 1, R.drawable.n7s);
                                        return dVar2;
                                    case 3027:
                                        dVar2 = new d(i3, 23, 5, 0, videoAppInterface.getApp().getString(R.string.f17865379), 1, R.drawable.n7s);
                                        return dVar2;
                                    case 3028:
                                        dVar = new d(i3, 23, 5, 0, videoAppInterface.getApp().getString(R.string.f1785236w));
                                        return dVar;
                                    case 3029:
                                        cVar = new c(i3, 15, 5, 0, videoAppInterface.getApp().getString(R.string.f17864378), 1, R.drawable.n7s, 10, 4);
                                        return cVar;
                                    case 3030:
                                        dVar = new d(i3, 23, 3, 0, videoAppInterface.getApp().getString(R.string.f1786637_));
                                        return dVar;
                                    case 3031:
                                        dVar = new d(i3, 23, 3, 0, videoAppInterface.getApp().getString(R.string.f17861375));
                                        return dVar;
                                    case 3032:
                                        dVar = new d(i3, 15, 3, 0, videoAppInterface.getApp().getString(R.string.f17860374));
                                        return dVar;
                                    case LaunchScene.LAUNCH_SCENE_BOTTOM_GUID /* 3033 */:
                                        dVar2 = new d(i3, 23, 0, 0, videoAppInterface.getApp().getString(R.string.f1786737a), 1, R.drawable.n7s);
                                        return dVar2;
                                    case LaunchScene.LAUNCH_SCENE_GAME_CENTER_QA /* 3034 */:
                                        dVar2 = new d(i3, 15, 5, 0, videoAppInterface.getApp().getString(R.string.f1785436y), 1, R.drawable.n7s);
                                        return dVar2;
                                    case LaunchScene.LAUNCH_SCENE_GAME_CENTER_FROM_GUILD /* 3035 */:
                                        dVar2 = new d(i3, 15, 5, 0, videoAppInterface.getApp().getString(R.string.f1785536z), 1, R.drawable.n7s);
                                        return dVar2;
                                    case 3036:
                                        dVar2 = new d(i3, 15, 5, 0, videoAppInterface.getApp().getString(R.string.f17856370), 1, R.drawable.n7s);
                                        return dVar2;
                                    default:
                                        if (!com.tencent.av.utils.e.j()) {
                                            return null;
                                        }
                                        String str = "CreatAvTipsItem,  \u672a\u5904\u7406\u7684tips\u7c7b\u522b\uff0ctipsID[" + i3 + "]";
                                        QLog.d("AVTipsItemFactory", 1, str);
                                        throw new IllegalArgumentException(str);
                                }
                        }
                }
        }
    }

    public static b b(int i3, VideoAppInterface videoAppInterface, int i16) {
        b a16 = a(i3, videoAppInterface);
        if (a16 == null) {
            return null;
        }
        a16.i(i16);
        return a16;
    }

    public static b c(int i3, VideoAppInterface videoAppInterface, String str) {
        b a16 = a(i3, videoAppInterface);
        if (a16 == null) {
            return null;
        }
        a16.j(str);
        return a16;
    }

    public static b d(int i3, VideoAppInterface videoAppInterface, String str, int i16) {
        b a16 = a(i3, videoAppInterface);
        if (a16 == null) {
            return null;
        }
        a16.j(str);
        a16.i(i16);
        return a16;
    }

    public static b e(int i3, VideoAppInterface videoAppInterface, String str, int i16, Drawable drawable, int i17, View.OnClickListener onClickListener) {
        b a16 = a(i3, videoAppInterface);
        if (a16 == null) {
            return null;
        }
        a16.j(str);
        if (i17 > 0) {
            a16.i(i17);
        }
        if (a16.h() == 1) {
            d dVar = (d) a16;
            dVar.p(i16);
            dVar.o(drawable);
        }
        if (a16.h() == 3) {
            ((c) a16).x(onClickListener);
        }
        return a16;
    }

    public static b f(int i3, VideoAppInterface videoAppInterface, String str, String str2, int i16, Drawable drawable, int i17, View.OnClickListener onClickListener) {
        b a16 = a(i3, videoAppInterface);
        if (a16 == null) {
            return null;
        }
        if (i17 > 0) {
            a16.i(i17);
        }
        if (a16.h() == 1) {
            d dVar = (d) a16;
            dVar.p(i16);
            dVar.o(drawable);
        }
        if (a16.h() == 3) {
            c cVar = (c) a16;
            cVar.x(onClickListener);
            cVar.j(str + " " + str2);
            cVar.f395065l = 14;
            cVar.f395064k = str2.length();
            cVar.f395063j = str.length() + 1;
        }
        return a16;
    }
}
