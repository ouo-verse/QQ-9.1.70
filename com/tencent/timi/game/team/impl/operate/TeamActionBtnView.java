package com.tencent.timi.game.team.impl.operate;

import ag4.h;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.base.TimiGameBaseActivity;
import com.tencent.timi.game.ui.widget.CommonButton;
import com.tencent.timi.game.ui.widget.e;
import com.tencent.timi.game.ui.widget.f;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.utils.o;
import fm4.g;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.LogUtil;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.SmobaDataOuterClass$YoloTeamInfo;
import trpc.yes.common.SmobaDataOuterClass$YoloTeamMemberInfo;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloCommonGameDataInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloCommonGameOneSchema;
import trpc.yes.common.YoloRoomOuterClass$YoloCommonUserGameData;
import trpc.yes.common.YoloRoomOuterClass$YoloGameRouteInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomCmdRsp;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomJoinGameCmdRsp;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomLeaveRsp;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingPosInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomStartGameCmdRsp;
import trpc.yes.common.YoloRoomOuterClass$YoloUserGameData;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TeamActionBtnView extends FrameLayout implements vm4.a {

    /* renamed from: f, reason: collision with root package name */
    private static long f379616f;

    /* renamed from: d, reason: collision with root package name */
    private CommonButton f379617d;

    /* renamed from: e, reason: collision with root package name */
    private long f379618e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            TeamActionBtnView.this.t();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class e implements IResultListener<YoloRoomOuterClass$YoloRoomLeaveRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f379636a;

        e(Activity activity) {
            this.f379636a = activity;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(YoloRoomOuterClass$YoloRoomLeaveRsp yoloRoomOuterClass$YoloRoomLeaveRsp) {
            TeamActionBtnView.u(this.f379636a);
            TeamActionBtnView.this.o();
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            TeamActionBtnView.u(this.f379636a);
            TeamActionBtnView.this.o();
        }
    }

    public TeamActionBtnView(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l() {
        long min = Math.min(15L, (15000 - (System.currentTimeMillis() - f379616f)) / 1000);
        if (min <= 0) {
            return true;
        }
        f.c("\u5df2\u7ecf\u4e3a\u4f60\u75af\u72c2call\u961f\u957f\u5566\uff0c\u7a0d\u7b49" + min + "\u79d2\u540e\u518d\u63d0\u9192\u4ed6\u5427");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(Context context) {
        Activity activity;
        if (((g) mm4.b.b(g.class)).K0(this.f379618e).S()) {
            if (context != null && (context instanceof Activity)) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            if (activity != null && !activity.isFinishing()) {
                new e.a(activity).q("\u65e0\u6cd5\u52a0\u5165\u6e38\u620f\u961f\u4f0d").j("\u7531\u4e8e\u738b\u8005\u961f\u4f0d\u53d8\u66f4\u4e86\u6e38\u620f\u6a21\u5f0f\uff0c\u6682\u65f6\u65e0\u6cd5\u52a0\u5165\u3002\u6211\u4eec\u4e3a\u4f60\u63a8\u8350\u4e86\u5176\u4ed6\u8f66\u961f\u5662\uff01").p("\u53bb\u770b\u770b").o(new d()).n("\u53d6\u6d88").m(new c()).c().show();
            } else {
                f.c("\u7531\u4e8e\u738b\u8005\u961f\u4f0d\u53d8\u66f4\u4e86\u6e38\u620f\u6a21\u5f0f\uff0c\u6682\u65f6\u65e0\u6cd5\u52a0\u5165\u3002\u6211\u4eec\u4e3a\u4f60\u63a8\u8350\u4e86\u5176\u4ed6\u8f66\u961f\u5662\uff01");
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(long j3) {
        ((g) mm4.b.b(g.class)).A(j3).h(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        QBaseActivity b16 = vf4.a.b();
        l.i("GangupActionBtnView", "gotoTeamList-openExpandHall topActivity - " + b16);
        if (b16 != null) {
            ((gh4.f) mm4.b.b(gh4.f.class)).openExpandHall(b16, new ExpandHallLaunchParam());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p(int i3, String str, String str2) {
        if (i3 == 9200107) {
            cn4.a.d((Activity) getContext(), this.f379618e, ((g) mm4.b.b(g.class)).K0(this.f379618e).o1(), "GangupActionBtnView-" + str2 + ", err_" + i3 + "-" + str, 1);
            return true;
        }
        return false;
    }

    private void q(Context context) {
        CommonButton commonButton = new CommonButton(context);
        this.f379617d = commonButton;
        commonButton.setGravity(17);
        this.f379617d.setTextSize(1, 16.0f);
        this.f379617d.setTypeface(Typeface.DEFAULT_BOLD);
        addView(this.f379617d, new FrameLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(YoloRoomOuterClass$YoloCommonGameOneSchema yoloRoomOuterClass$YoloCommonGameOneSchema) {
        if (yoloRoomOuterClass$YoloCommonGameOneSchema != null && !TextUtils.isEmpty(yoloRoomOuterClass$YoloCommonGameOneSchema.schema.get())) {
            ((g) mm4.b.b(g.class)).j2(this.f379618e, "GangupActionBtnView");
            nm4.a.a(yoloRoomOuterClass$YoloCommonGameOneSchema.schema.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        Activity activity;
        Context context = getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        l.i("GangupActionBtnView", "leaveAndJumpOtherRooms - " + context);
        v(activity);
        ((g) mm4.b.b(g.class)).T2(this.f379618e, false, 0, new e(activity), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void u(Activity activity) {
        if ((activity instanceof TimiGameBaseActivity) && !activity.isFinishing()) {
            ((TimiGameBaseActivity) activity).hideLoadingView();
        }
    }

    private static void v(Activity activity) {
        if ((activity instanceof TimiGameBaseActivity) && !activity.isFinishing()) {
            ((TimiGameBaseActivity) activity).showLoadingView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        f379616f = System.currentTimeMillis();
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:0x01f5, code lost:
    
        if (((fm4.g) mm4.b.b(fm4.g.class)).K0(r29.f379618e).s() != null) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0269, code lost:
    
        if (r33 == null) goto L86;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x034c  */
    @Override // vm4.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> list, CommonOuterClass$QQUserId commonOuterClass$QQUserId, int i3, YoloRoomOuterClass$YoloCommonGameOneSchema yoloRoomOuterClass$YoloCommonGameOneSchema, YoloRoomOuterClass$YoloGameRouteInfo yoloRoomOuterClass$YoloGameRouteInfo) {
        YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo;
        String str;
        int i16;
        boolean z16;
        int i17;
        int i18;
        int i19;
        String str2;
        int i26;
        String str3;
        String str4;
        String str5;
        Drawable drawable;
        Drawable drawable2;
        SmobaDataOuterClass$YoloTeamMemberInfo smobaDataOuterClass$YoloTeamMemberInfo;
        CommonOuterClass$QQUserId commonOuterClass$QQUserId2;
        boolean z17;
        YoloRoomOuterClass$YoloUserGameData yoloRoomOuterClass$YoloUserGameData;
        YoloRoomOuterClass$YoloCommonUserGameData yoloRoomOuterClass$YoloCommonUserGameData;
        CommonOuterClass$QQUserId E = ((ll4.a) mm4.b.b(ll4.a.class)).E();
        boolean a16 = ll4.b.a(commonOuterClass$QQUserId, E);
        YoloRoomOuterClass$YoloRoomInfo roomInfo = ((g) mm4.b.b(g.class)).K0(this.f379618e).getRoomInfo();
        int t26 = ((g) mm4.b.b(g.class)).t2(roomInfo);
        YesGameInfoOuterClass$GameConfigInfo l16 = ((h) mm4.b.b(h.class)).l1(t26);
        int i27 = roomInfo != null ? roomInfo.room_data_info.min_player_num.get() : 1;
        YoloRoomOuterClass$YoloCommonGameDataInfo w3 = ((g) mm4.b.b(g.class)).K0(this.f379618e).w();
        int i28 = w3 != null ? w3.game_mode.get() : 0;
        String str6 = w3 != null ? w3.mode_name.get() : "";
        Iterator<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                yoloRoomOuterClass$YoloRoomSpeakingPosInfo = null;
                break;
            } else {
                yoloRoomOuterClass$YoloRoomSpeakingPosInfo = it.next();
                if (ll4.b.a(yoloRoomOuterClass$YoloRoomSpeakingPosInfo.user_id, E)) {
                    break;
                }
            }
        }
        Iterator<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> it5 = list.iterator();
        int i29 = 0;
        while (true) {
            if (!it5.hasNext()) {
                str = str6;
                i16 = i28;
                z16 = true;
                break;
            }
            Iterator<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> it6 = it5;
            YoloRoomOuterClass$YoloRoomSpeakingPosInfo next = it5.next();
            str = str6;
            i16 = i28;
            if (next.ready_status.get() != 1 && !ll4.b.b(next.user_id) && !ll4.b.a(next.user_id, E)) {
                z16 = false;
                break;
            }
            if (next.user_id.yes_uid.get() != 0) {
                i29++;
            }
            str6 = str;
            it5 = it6;
            i28 = i16;
        }
        boolean z18 = i29 >= i27;
        YoloRoomOuterClass$YoloCommonUserGameData yoloRoomOuterClass$YoloCommonUserGameData2 = (yoloRoomOuterClass$YoloRoomSpeakingPosInfo == null || (yoloRoomOuterClass$YoloUserGameData = yoloRoomOuterClass$YoloRoomSpeakingPosInfo.user_game_data) == null || (yoloRoomOuterClass$YoloCommonUserGameData = yoloRoomOuterClass$YoloUserGameData.user_common_game_data) == null || !yoloRoomOuterClass$YoloCommonUserGameData.has()) ? null : yoloRoomOuterClass$YoloRoomSpeakingPosInfo.user_game_data.user_common_game_data;
        int i36 = yoloRoomOuterClass$YoloCommonUserGameData2 != null ? yoloRoomOuterClass$YoloCommonUserGameData2.user_room_status.get() : 0;
        int i37 = yoloRoomOuterClass$YoloCommonUserGameData2 != null ? yoloRoomOuterClass$YoloCommonUserGameData2.user_room_status_button_style.get() : 1;
        if (yoloRoomOuterClass$YoloCommonUserGameData2 != null) {
            i17 = i37;
            i18 = yoloRoomOuterClass$YoloCommonUserGameData2.user_room_status_button_event.get();
        } else {
            i17 = i37;
            i18 = 0;
        }
        String str7 = yoloRoomOuterClass$YoloCommonUserGameData2 != null ? yoloRoomOuterClass$YoloCommonUserGameData2.user_room_status_desc.get() : "\u51c6\u5907\u4e2d";
        int i38 = i18;
        boolean z19 = z18;
        if (t26 == 101) {
            SmobaDataOuterClass$YoloTeamInfo smobaDataOuterClass$YoloTeamInfo = (yoloRoomOuterClass$YoloGameRouteInfo == null || !yoloRoomOuterClass$YoloGameRouteInfo.smoba_game_route_info.has()) ? null : yoloRoomOuterClass$YoloGameRouteInfo.smoba_game_route_info.team_info;
            if (smobaDataOuterClass$YoloTeamInfo != null && smobaDataOuterClass$YoloTeamInfo.memberlist.size() > 0) {
                Iterator<SmobaDataOuterClass$YoloTeamMemberInfo> it7 = smobaDataOuterClass$YoloTeamInfo.memberlist.get().iterator();
                while (it7.hasNext()) {
                    smobaDataOuterClass$YoloTeamMemberInfo = it7.next();
                    if (smobaDataOuterClass$YoloTeamMemberInfo.yes_uid.get() == E.yes_uid.get()) {
                        break;
                    }
                }
            }
            smobaDataOuterClass$YoloTeamMemberInfo = null;
            boolean z26 = (yoloRoomOuterClass$YoloCommonGameOneSchema == null || smobaDataOuterClass$YoloTeamMemberInfo == null) ? false : true;
            l.i("GangupActionBtnView", "updateBtn hostUid=" + LogUtil.getSafePrintUin("" + commonOuterClass$QQUserId) + ", gameStatus=" + i3 + ", speakingPosInfoList=" + list.size() + ", minPlayer=" + i27 + ", isPlayerInSmobaTeam=" + z26);
            if (i3 != 3 || ((yoloRoomOuterClass$YoloCommonGameOneSchema == null || z26) && yoloRoomOuterClass$YoloCommonGameOneSchema != null)) {
                if (yoloRoomOuterClass$YoloCommonGameOneSchema == null) {
                    if (i3 != 2) {
                        commonOuterClass$QQUserId2 = E;
                    }
                    str2 = "\u52a0\u5165\u6e38\u620f";
                    i26 = 3;
                    i19 = 2;
                    l.h("GangupActionBtnView", 1, "updateBtn - gameStatus:" + i3 + " userRoomStatus:" + i36 + " actionBtnStyle:" + i19 + " actionBtnEvent:" + i26);
                    if (i26 != 4) {
                        str4 = "em_yes_game_launch";
                    } else {
                        if (i26 != 1) {
                            str3 = null;
                            if (!TextUtils.isEmpty(str3)) {
                                ConcurrentHashMap<String, String> d16 = com.tencent.timi.game.team.impl.main.f.d(this.f379618e);
                                ((ug4.b) mm4.b.b(ug4.b.class)).c(this.f379617d, true, str2, str3, d16);
                                if (!str2.equals(this.f379617d.getText().toString())) {
                                    ((ug4.b) mm4.b.b(ug4.b.class)).reportEvent("imp", this.f379617d, d16);
                                    ((ug4.b) mm4.b.b(ug4.b.class)).reportEvent("imp_end", this.f379617d, d16);
                                }
                            }
                            this.f379617d.setText(str2);
                            if (i19 != 1) {
                                com.tencent.timi.game.team.impl.b.c(this.f379617d, l16.team_room_info.button_text_hue.get(), Color.parseColor("#FFFFFFFF"));
                                str5 = l16.team_room_info.button_bg_hue.get();
                                if (TextUtils.isEmpty(str5)) {
                                    str5 = "#F5A300";
                                }
                            } else {
                                com.tencent.timi.game.team.impl.b.c(this.f379617d, l16.team_room_info.color_button_disable_text.get(), Color.parseColor("#FFB8B8B8"));
                                str5 = l16.team_room_info.color_button_disable_bg.get();
                                if (TextUtils.isEmpty(str5)) {
                                    str5 = "#EAEAEA";
                                }
                            }
                            StateListDrawable stateListDrawable = new StateListDrawable();
                            drawable = ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.lt7, null);
                            if (drawable != null) {
                                drawable.setColorFilter(new PorterDuffColorFilter(Color.parseColor(str5), PorterDuff.Mode.MULTIPLY));
                                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, drawable);
                            }
                            PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(Color.parseColor(str5), PorterDuff.Mode.SRC);
                            drawable2 = ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.lt7, null);
                            if (drawable2 != null) {
                                drawable2.setColorFilter(porterDuffColorFilter);
                                stateListDrawable.addState(new int[0], drawable2);
                            }
                            this.f379617d.setBackgroundDrawable(stateListDrawable);
                            if (i26 == 0) {
                                this.f379617d.setOnClickListener(null);
                                return;
                            } else {
                                this.f379617d.setOnClickListener(new a(i26, z19, i16, str, i27, yoloRoomOuterClass$YoloCommonGameOneSchema));
                                return;
                            }
                        }
                        str4 = "em_yes_gamelaunch_remind";
                    }
                    str3 = str4;
                    if (!TextUtils.isEmpty(str3)) {
                    }
                    this.f379617d.setText(str2);
                    if (i19 != 1) {
                    }
                    StateListDrawable stateListDrawable2 = new StateListDrawable();
                    drawable = ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.lt7, null);
                    if (drawable != null) {
                    }
                    PorterDuffColorFilter porterDuffColorFilter2 = new PorterDuffColorFilter(Color.parseColor(str5), PorterDuff.Mode.SRC);
                    drawable2 = ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.lt7, null);
                    if (drawable2 != null) {
                    }
                    this.f379617d.setBackgroundDrawable(stateListDrawable2);
                    if (i26 == 0) {
                    }
                } else {
                    commonOuterClass$QQUserId2 = E;
                }
                if (a16) {
                    if (yoloRoomOuterClass$YoloCommonGameOneSchema == null) {
                        if (i3 != 1) {
                            str2 = "\u7acb\u5373\u53d1\u8f66";
                            if (z16) {
                                i26 = 2;
                                i19 = 2;
                            } else {
                                i26 = 2;
                                i19 = 1;
                            }
                        }
                        str2 = "\u7b49\u5f85\u786e\u8ba4";
                        i26 = 0;
                        i19 = 1;
                    }
                    str2 = "\u8fdb\u5165\u6e38\u620f";
                    i26 = 4;
                    i19 = 2;
                } else {
                    Iterator<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> it8 = list.iterator();
                    while (true) {
                        if (!it8.hasNext()) {
                            break;
                        }
                        YoloRoomOuterClass$YoloRoomSpeakingPosInfo next2 = it8.next();
                        if (ll4.b.a(next2.user_id, commonOuterClass$QQUserId2)) {
                            if (next2.ready_status.get() == 1) {
                                z17 = true;
                            }
                        }
                    }
                    z17 = false;
                    if (yoloRoomOuterClass$YoloCommonGameOneSchema == null) {
                        if (((g) mm4.b.b(g.class)).K0(this.f379618e).s() == null) {
                            i19 = 2;
                            if (i3 != 2) {
                                if (i3 == 1) {
                                    if (((g) mm4.b.b(g.class)).K0(this.f379618e).v(commonOuterClass$QQUserId2) == null) {
                                        str2 = "\u961f\u4f0d\u521b\u5efa\u4e2d";
                                        i26 = 0;
                                        i19 = 1;
                                    }
                                    str2 = "\u7b49\u5f85\u786e\u8ba4";
                                    i26 = 0;
                                    i19 = 1;
                                } else if (i3 != 3) {
                                    if (z17) {
                                        str2 = "\u63d0\u9192\u961f\u957f\u53d1\u8f66";
                                        i26 = 1;
                                    } else {
                                        str2 = "\u51c6\u5907";
                                        i26 = 5;
                                    }
                                }
                            }
                        }
                    }
                    str2 = "\u8fdb\u5165\u6e38\u620f";
                    i26 = 4;
                    i19 = 2;
                }
                l.h("GangupActionBtnView", 1, "updateBtn - gameStatus:" + i3 + " userRoomStatus:" + i36 + " actionBtnStyle:" + i19 + " actionBtnEvent:" + i26);
                if (i26 != 4) {
                }
                str3 = str4;
                if (!TextUtils.isEmpty(str3)) {
                }
                this.f379617d.setText(str2);
                if (i19 != 1) {
                }
                StateListDrawable stateListDrawable22 = new StateListDrawable();
                drawable = ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.lt7, null);
                if (drawable != null) {
                }
                PorterDuffColorFilter porterDuffColorFilter22 = new PorterDuffColorFilter(Color.parseColor(str5), PorterDuff.Mode.SRC);
                drawable2 = ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.lt7, null);
                if (drawable2 != null) {
                }
                this.f379617d.setBackgroundDrawable(stateListDrawable22);
                if (i26 == 0) {
                }
            }
            str2 = "\u6e38\u620f\u4e2d";
            i26 = 0;
            i19 = 1;
            l.h("GangupActionBtnView", 1, "updateBtn - gameStatus:" + i3 + " userRoomStatus:" + i36 + " actionBtnStyle:" + i19 + " actionBtnEvent:" + i26);
            if (i26 != 4) {
            }
            str3 = str4;
            if (!TextUtils.isEmpty(str3)) {
            }
            this.f379617d.setText(str2);
            if (i19 != 1) {
            }
            StateListDrawable stateListDrawable222 = new StateListDrawable();
            drawable = ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.lt7, null);
            if (drawable != null) {
            }
            PorterDuffColorFilter porterDuffColorFilter222 = new PorterDuffColorFilter(Color.parseColor(str5), PorterDuff.Mode.SRC);
            drawable2 = ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.lt7, null);
            if (drawable2 != null) {
            }
            this.f379617d.setBackgroundDrawable(stateListDrawable222);
            if (i26 == 0) {
            }
        }
        i19 = i17;
        str2 = str7;
        i26 = i38;
        l.h("GangupActionBtnView", 1, "updateBtn - gameStatus:" + i3 + " userRoomStatus:" + i36 + " actionBtnStyle:" + i19 + " actionBtnEvent:" + i26);
        if (i26 != 4) {
        }
        str3 = str4;
        if (!TextUtils.isEmpty(str3)) {
        }
        this.f379617d.setText(str2);
        if (i19 != 1) {
        }
        StateListDrawable stateListDrawable2222 = new StateListDrawable();
        drawable = ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.lt7, null);
        if (drawable != null) {
        }
        PorterDuffColorFilter porterDuffColorFilter2222 = new PorterDuffColorFilter(Color.parseColor(str5), PorterDuff.Mode.SRC);
        drawable2 = ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.lt7, null);
        if (drawable2 != null) {
        }
        this.f379617d.setBackgroundDrawable(stateListDrawable2222);
        if (i26 == 0) {
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        q(getContext());
    }

    public void r(long j3) {
        this.f379618e = j3;
    }

    public TeamActionBtnView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TeamActionBtnView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f379619d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f379620e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f379621f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f379622h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f379623i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ YoloRoomOuterClass$YoloCommonGameOneSchema f379624m;

        /* compiled from: P */
        /* loaded from: classes26.dex */
        class c implements DialogInterface.OnClickListener {
            c() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                TeamActionBtnView teamActionBtnView = TeamActionBtnView.this;
                teamActionBtnView.n(teamActionBtnView.f379618e);
            }
        }

        a(int i3, boolean z16, int i16, String str, int i17, YoloRoomOuterClass$YoloCommonGameOneSchema yoloRoomOuterClass$YoloCommonGameOneSchema) {
            this.f379619d = i3;
            this.f379620e = z16;
            this.f379621f = i16;
            this.f379622h = str;
            this.f379623i = i17;
            this.f379624m = yoloRoomOuterClass$YoloCommonGameOneSchema;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!o.a()) {
                switch (this.f379619d) {
                    case 1:
                        if (TeamActionBtnView.this.l()) {
                            TeamActionBtnView.this.w();
                            com.tencent.timi.game.ui.widget.f.c("\u63d0\u9192\u6210\u529f\uff0c\u7b49\u5f85\u961f\u957f\u56de\u6765\u53d1\u8f66\u5427\u3002");
                            ((g) mm4.b.b(g.class)).A(TeamActionBtnView.this.f379618e).K(new C9975a());
                            break;
                        }
                        break;
                    case 2:
                        if (this.f379620e) {
                            TeamActionBtnView teamActionBtnView = TeamActionBtnView.this;
                            teamActionBtnView.n(teamActionBtnView.f379618e);
                            break;
                        } else {
                            if (this.f379621f == 2) {
                                str = "\u4e94\u4eba\u6392\u4f4d\u6a21\u5f0f";
                            } else {
                                str = this.f379622h;
                            }
                            new e.a(vf4.a.b()).q("").j(str + "\u9700\u8981\u6ee1" + this.f379623i + "\u4eba\u624d\u80fd\u5728\u6e38\u620f\u5185\u5f00\u5c40\u54e6\uff0c\u5f53\u524d\u4eba\u6570\u4e0d\u8db3\u662f\u5426\u8981\u7ee7\u7eed?").p("\u5f00\u59cb\u6e38\u620f").o(new c()).n("\u518d\u7b49\u7b49").m(new b()).f(false).c().show();
                            break;
                        }
                    case 3:
                        TeamActionBtnView teamActionBtnView2 = TeamActionBtnView.this;
                        if (teamActionBtnView2.m(teamActionBtnView2.getContext())) {
                            ((g) mm4.b.b(g.class)).A(TeamActionBtnView.this.f379618e).k(new d());
                            break;
                        }
                        break;
                    case 4:
                        TeamActionBtnView teamActionBtnView3 = TeamActionBtnView.this;
                        if (teamActionBtnView3.m(teamActionBtnView3.getContext())) {
                            TeamActionBtnView.this.s(this.f379624m);
                            break;
                        }
                        break;
                    case 5:
                        ((g) mm4.b.b(g.class)).A(TeamActionBtnView.this.f379618e).T(true, new e());
                        break;
                    case 6:
                        ((g) mm4.b.b(g.class)).A(TeamActionBtnView.this.f379618e).T(false, new f());
                        break;
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* compiled from: P */
        /* renamed from: com.tencent.timi.game.team.impl.operate.TeamActionBtnView$a$a, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        class C9975a implements IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> {
            C9975a() {
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(YoloRoomOuterClass$YoloRoomCmdRsp yoloRoomOuterClass$YoloRoomCmdRsp) {
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            public void onError(int i3, String str) {
            }
        }

        /* compiled from: P */
        /* loaded from: classes26.dex */
        class d implements IResultListener<YoloRoomOuterClass$YoloRoomJoinGameCmdRsp> {

            /* compiled from: P */
            /* loaded from: classes26.dex */
            class b implements DialogInterface.OnClickListener {
                b() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    TeamActionBtnView.this.t();
                }
            }

            d() {
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            public void onError(int i3, String str) {
                String str2;
                if (!TeamActionBtnView.this.p(i3, str, "guest joinGame")) {
                    Activity activity = null;
                    boolean z16 = true;
                    if (i3 == 9200118) {
                        str2 = "\u6e38\u620f\u961f\u4f0d\u5df2\u7ecf\u6ee1\u5458\u4e86\uff0c\u6362\u4e2a\u8f66\u961f\u73a9\u6e38\u620f\u5427";
                    } else if (i3 == 9200120) {
                        str2 = "\u6e38\u620f\u961f\u4f0d\u5df2\u7ecf\u5f00\u59cb\u6e38\u620f\u4e86\uff0c\u6362\u4e2a\u8f66\u961f\u73a9\u6e38\u620f\u5427";
                    } else if (i3 == 9200121) {
                        str2 = "\u7531\u4e8e\u738b\u8005\u961f\u4f0d\u53d8\u66f4\u4e86\u6e38\u620f\u6a21\u5f0f\uff0c\u6682\u65f6\u65e0\u6cd5\u52a0\u5165\u3002\u6211\u4eec\u4e3a\u4f60\u63a8\u8350\u4e86\u5176\u4ed6\u8f66\u961f\u5662!";
                    } else {
                        com.tencent.timi.game.ui.widget.f.c("\u52a0\u5165\u6e38\u620f\u5931\u8d25, " + str);
                        z16 = false;
                        str2 = null;
                    }
                    if (z16) {
                        Context context = TeamActionBtnView.this.getContext();
                        if (context != null && (context instanceof Activity)) {
                            activity = (Activity) context;
                        }
                        if (activity != null && !activity.isFinishing()) {
                            new e.a(activity).j(str2).p("\u53bb\u770b\u770b").o(new b()).n("\u53d6\u6d88").m(new DialogInterfaceOnClickListenerC9976a()).c().show();
                        } else {
                            com.tencent.timi.game.ui.widget.f.c(str2);
                        }
                    }
                }
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(YoloRoomOuterClass$YoloRoomJoinGameCmdRsp yoloRoomOuterClass$YoloRoomJoinGameCmdRsp) {
            }

            /* compiled from: P */
            /* renamed from: com.tencent.timi.game.team.impl.operate.TeamActionBtnView$a$d$a, reason: collision with other inner class name */
            /* loaded from: classes26.dex */
            class DialogInterfaceOnClickListenerC9976a implements DialogInterface.OnClickListener {
                DialogInterfaceOnClickListenerC9976a() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes26.dex */
        class e implements IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> {
            e() {
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            public void onError(int i3, String str) {
                if (!TeamActionBtnView.this.p(i3, str, "guest doReady")) {
                    com.tencent.timi.game.ui.widget.f.c("\u51c6\u5907\u5931\u8d25, " + str);
                }
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(YoloRoomOuterClass$YoloRoomCmdRsp yoloRoomOuterClass$YoloRoomCmdRsp) {
            }
        }

        /* compiled from: P */
        /* loaded from: classes26.dex */
        class f implements IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> {
            f() {
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            public void onError(int i3, String str) {
                if (!TeamActionBtnView.this.p(i3, str, "guest doReady")) {
                    com.tencent.timi.game.ui.widget.f.c("\u53d6\u6d88\u51c6\u5907\u5931\u8d25, " + str);
                }
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(YoloRoomOuterClass$YoloRoomCmdRsp yoloRoomOuterClass$YoloRoomCmdRsp) {
            }
        }

        /* compiled from: P */
        /* loaded from: classes26.dex */
        class b implements DialogInterface.OnClickListener {
            b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements IResultListener<YoloRoomOuterClass$YoloRoomStartGameCmdRsp> {
        b() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            TeamActionBtnView.this.p(i3, str, "host startGame");
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(YoloRoomOuterClass$YoloRoomStartGameCmdRsp yoloRoomOuterClass$YoloRoomStartGameCmdRsp) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
