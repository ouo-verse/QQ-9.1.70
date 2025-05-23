package com.qzone.proxy.feedcomponent;

import android.graphics.drawable.Drawable;
import com.qzone.adapter.feedcomponent.o;
import com.tencent.litetransfersdk.LiteTransferType;
import com.tencent.luan.ioc.annotation.Inject;
import com.tencent.luan.ioc.annotation.Prototype;
import com.tencent.luggage.wxa.gf.u;
import com.tencent.luggage.wxa.xd.l0;
import com.tencent.luggage.wxa.yf.x;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.qbox.QBoxConfProcessor;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.reminder.util.QQConstants;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.vas.config.business.qvip.QVipServiceAccountFolderProcessor;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qqlive.module.videoreport.BuildConfig;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import com.tencent.qqnt.kernel.nativeinterface.UfsGROUPMASK;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import com.tencent.view.FilterEnum;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import cooperation.qzone.util.ResDownloadManger;
import cooperation.qzone.util.WnsError;
import mqq.app.Constants;

/* compiled from: P */
@Prototype
/* loaded from: classes39.dex */
public class f implements o {
    @Inject
    public f() {
    }

    private int f(int i3) {
        switch (i3) {
            case 274:
                return R.dimen.f158818pr;
            case 275:
                return R.dimen.f158821pu;
            case 276:
                return R.dimen.f158828q1;
            case 277:
                return R.dimen.f158700mp;
            case 278:
                return R.dimen.f158723nd;
            case FilterEnum.MIC_PTU_TRANS_ROUHE /* 279 */:
                return R.dimen.f158727nh;
            case FilterEnum.MIC_PTU_TRANS_XINXIAN /* 280 */:
                return R.dimen.b5p;
            case FilterEnum.MIC_PTU_TRANS_KONGCHENG /* 281 */:
                return R.dimen.b5o;
            case FilterEnum.MIC_PTU_BAIXI /* 282 */:
                return R.dimen.b5s;
            case 283:
                return R.dimen.b5r;
            case 284:
                return R.dimen.b5n;
            case 285:
                return R.dimen.f158832q5;
            case 286:
                return R.dimen.f158833q6;
            case 287:
                return R.dimen.f158834q7;
            case 288:
                return R.dimen.azw;
            case FilterEnum.MIC_PTU_ZIRAN /* 289 */:
                return R.dimen.p_;
            case 290:
                return R.dimen.f158800p9;
            case 291:
                return R.dimen.b5k;
            case 292:
                return R.dimen.b5_;
            default:
                return 0;
        }
    }

    public static boolean h(int i3) {
        if (i3 >= 1911 && i3 <= 2183) {
            return true;
        }
        return false;
    }

    @Override // com.qzone.adapter.feedcomponent.o
    public float a(int i3) {
        return FeedGlobalEnv.getContext().getResources().getDimension(f(i3));
    }

    @Override // com.qzone.adapter.feedcomponent.o
    public int b(int i3) {
        return FeedGlobalEnv.getContext().getResources().getDimensionPixelSize(f(i3));
    }

    @Override // com.qzone.adapter.feedcomponent.o
    public float c(String str) {
        return (!str.endsWith("feed") && str.endsWith("feed_left_thumb")) ? 14.0f : 15.0f;
    }

    @Override // com.qzone.adapter.feedcomponent.o
    public int d(int i3) {
        switch (i3) {
            case 1:
                return R.color.qzone_skin_feed_content_text_color;
            case 2:
                return R.color.qzone_skin_feed_second_content_text_color;
            case 3:
                return R.color.qzone_skin_feed_text_link_color;
            case 4:
                return R.color.qzone_skin_feed_input_box_hint_color;
            case 5:
                return R.color.a6v;
            case 6:
                return R.color.a_l;
            case 7:
                return R.color.f156606d;
            case 8:
                return R.color.f156647j;
            case 9:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 23:
            case 26:
            case 27:
            case 34:
            case 35:
            case 36:
            case 37:
            case 44:
            case 45:
            default:
                return 0;
            case 10:
                return R.color.a8o;
            case 11:
                return R.color.f157116k8;
            case 12:
                return R.color.f156605c;
            case 13:
                return R.color.qzone_skin_feed_gap_color;
            case 14:
                return R.color.f156646i;
            case 20:
                return R.color.qzone_skin_feed_background_color;
            case 21:
                return R.color.f156679n;
            case 22:
                return R.color.f156603a;
            case 24:
                return R.color.f156680o;
            case 25:
                return R.color.a_8;
            case 28:
                return R.color.f156976gm;
            case 29:
                return R.color.f156681p;
            case 30:
                return R.color.a7v;
            case 31:
                return R.color.a7c;
            case 32:
                return R.color.a7b;
            case 33:
                return R.color.qzone_skin_feed_text_link_dark_color;
            case 38:
                return R.color.qzone_skin_feed_second_background_color;
            case 39:
                return R.color.qzone_skin_feed_split_line_color;
            case 40:
                return R.color.qzone_skin_feed_qui_main_button_normal;
            case 41:
                return R.color.qzone_skin_feed_qui_second_button_normal;
            case 42:
                return R.color.qzone_skin_feed_qui_second_button_on_bg_normal;
            case 43:
                return R.color.qzone_skin_feed_qui_third_button_normal;
            case 46:
                return R.color.qzone_skin_feed_input_box_bg_color;
            case 47:
                return R.color.cna;
            case 48:
                return R.color.black;
            case 49:
                return R.color.cnm;
            case 50:
                return R.color.cnl;
        }
    }

    @Override // com.qzone.adapter.feedcomponent.o
    public int getAnimationId(int i3) {
        switch (i3) {
            case 4098:
                return R.anim.f155020gs;
            case 4099:
                return R.anim.f155019gr;
            case 4100:
                return R.anim.f155017gp;
            case 4101:
                return R.anim.f155018gq;
            default:
                return 0;
        }
    }

    @Override // com.qzone.adapter.feedcomponent.o
    public int getColor(int i3) {
        return FeedGlobalEnv.getContext().getResources().getColor(d(i3));
    }

    @Override // com.qzone.adapter.feedcomponent.o
    public Drawable getDrawable(int i3) {
        if (h(i3)) {
            return g(i3);
        }
        try {
            return FeedGlobalEnv.getContext().getResources().getDrawable(getDrawableId(i3));
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.qzone.adapter.feedcomponent.o
    public int getDrawableId(int i3) {
        if (i3 != 5) {
            if (i3 != 6) {
                if (i3 != 7) {
                    if (i3 != 8) {
                        if (i3 != 21) {
                            if (i3 != 22) {
                                if (i3 != 47) {
                                    if (i3 != 48) {
                                        if (i3 != 588) {
                                            if (i3 != 589) {
                                                switch (i3) {
                                                    case 18:
                                                        return R.color.f157906a82;
                                                    case 547:
                                                        return R.drawable.g28;
                                                    case PlayerResources.ViewId.VIDEO_SURFACE /* 548 */:
                                                        return R.drawable.axa;
                                                    case 549:
                                                        return R.drawable.ayw;
                                                    case 550:
                                                        return R.drawable.ax_;
                                                    case PlayerResources.ViewId.TITLE_BAR /* 551 */:
                                                        return R.drawable.abk;
                                                    case 552:
                                                        return R.drawable.azx;
                                                    case PlayerResources.ViewId.LOADING /* 553 */:
                                                        return R.drawable.azs;
                                                    case PlayerResources.ViewId.SWITCH_LANDSCAPE_BUTTON /* 554 */:
                                                        return R.drawable.axc;
                                                    case 555:
                                                        return R.drawable.f162226g25;
                                                    case PlayerResources.ViewId.CONTROLLER_PROGRESS /* 556 */:
                                                        return R.drawable.g27;
                                                    case PlayerResources.ViewId.PLAYER_DURATION /* 557 */:
                                                        return R.drawable.ax5;
                                                    case PlayerResources.ViewId.CURRUNT_TIME /* 558 */:
                                                        return R.drawable.f160830com;
                                                    case 591:
                                                        return R.drawable.f162222g20;
                                                    case com.tencent.luggage.wxa.v6.d.CTRL_INDEX /* 592 */:
                                                    case QVipServiceAccountFolderProcessor.CMD /* 722 */:
                                                    case LpReportInfoConfig.ACTION_TYPE_AIO_SYNC_QZONE /* 723 */:
                                                        return R.drawable.azt;
                                                    case 595:
                                                    case 662:
                                                        return R.drawable.gfo;
                                                    case 597:
                                                        return R.drawable.g1i;
                                                    case 598:
                                                        return R.drawable.g3u;
                                                    case 599:
                                                        return R.drawable.fu8;
                                                    case 600:
                                                        return R.drawable.fua;
                                                    case 605:
                                                        return R.drawable.g3e;
                                                    case 642:
                                                        return R.drawable.f162205hb2;
                                                    case 643:
                                                        return R.drawable.bvo;
                                                    case 644:
                                                        return R.drawable.g3a;
                                                    case MiniReportManager.EventId.PAGE_LOAD_END /* 645 */:
                                                        return R.drawable.g3b;
                                                    case 646:
                                                        return R.drawable.ari;
                                                    case 647:
                                                        return R.drawable.b3f;
                                                    case 648:
                                                        return R.drawable.arh;
                                                    case 656:
                                                        return R.drawable.g0g;
                                                    case 659:
                                                        return R.drawable.g8q;
                                                    case TbsListener.ErrorCode.STATIC_TBS_INSTALL_HAS_INSTALLED_EXCEPTION /* 660 */:
                                                        return R.drawable.fxe;
                                                    case LpReportInfoConfig.ACTION_SPECIAL_FOLLOW_TOAST /* 661 */:
                                                        return R.drawable.f162261g71;
                                                    case 663:
                                                        return R.drawable.ayu;
                                                    case LpReportInfoConfig.ACTION_VIDEO_EDITOR /* 664 */:
                                                        return R.drawable.ayx;
                                                    case 669:
                                                        return R.drawable.g36;
                                                    case TbsListener.ErrorCode.STATIC_TBS_INSTALL_TMP_RENAME_ERR /* 670 */:
                                                        return R.drawable.f162232g35;
                                                    case 671:
                                                        return R.drawable.azy;
                                                    case 672:
                                                        return R.drawable.azz;
                                                    case 701:
                                                    case 702:
                                                        return R.drawable.azr;
                                                    case 703:
                                                        return R.drawable.fza;
                                                    case 705:
                                                    case 903:
                                                        return R.drawable.qzone_skin_feed_icon_praise_clicked;
                                                    case 706:
                                                        return R.drawable.f162237g40;
                                                    case 707:
                                                        return R.drawable.g3z;
                                                    case 711:
                                                    case TMAssistantDownloadErrorCode.DOWNLOAD_ERR_KNOWN_LENGTH_CHECK_ERROR /* 712 */:
                                                        return R.drawable.qzone_famous_icon;
                                                    case 716:
                                                        return R.drawable.ayi;
                                                    case 717:
                                                        return R.drawable.b0j;
                                                    case 718:
                                                        return R.drawable.qzone_skin_feed_inputbox_doodle_icon;
                                                    case 719:
                                                    case com.tencent.luggage.wxa.uf.k.CTRL_INDEX /* 814 */:
                                                        return R.drawable.ayh;
                                                    case 720:
                                                        return R.drawable.azu;
                                                    case 721:
                                                        return R.drawable.azv;
                                                    case 725:
                                                        return R.drawable.atu;
                                                    case 726:
                                                        return R.drawable.qzone_skin_feed_recom_header_close_icon;
                                                    case 729:
                                                        return R.drawable.f162166fu4;
                                                    case TMAssistantDownloadErrorCode.DownloadSDKErrorCode_SPACE_NOT_ENOUGH /* 730 */:
                                                        return R.drawable.fu5;
                                                    case TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_EMPTY /* 731 */:
                                                        return R.drawable.qzone_skin_feed_icon_feedback_delete;
                                                    case TMAssistantDownloadErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION /* 732 */:
                                                        return R.drawable.f162344nz4;
                                                    case 733:
                                                        return R.drawable.nz5;
                                                    case com.tencent.luggage.wxa.ci.a.CTRL_INDEX /* 734 */:
                                                        return R.drawable.nz6;
                                                    case com.tencent.luggage.wxa.ci.b.CTRL_INDEX /* 735 */:
                                                        return R.drawable.nz7;
                                                    case com.tencent.luggage.wxa.wh.b.CTRL_INDEX /* 736 */:
                                                        return R.drawable.nz8;
                                                    case com.tencent.luggage.wxa.sm.e.P /* 752 */:
                                                        return R.drawable.gii;
                                                    case 754:
                                                        return R.drawable.naq;
                                                    case 756:
                                                        return R.drawable.g3h;
                                                    case 757:
                                                        return R.drawable.g3i;
                                                    case 766:
                                                        return R.drawable.qzone_skin_feed_container_border;
                                                    case MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER /* 771 */:
                                                        return R.drawable.gcl;
                                                    case 772:
                                                        return R.drawable.gcm;
                                                    case 773:
                                                        return R.drawable.gcn;
                                                    case 775:
                                                        return R.drawable.f162163fu1;
                                                    case 776:
                                                        return R.drawable.fyb;
                                                    case com.tencent.luggage.wxa.he.e.CTRL_INDEX /* 777 */:
                                                        return R.drawable.fyc;
                                                    case 778:
                                                        return R.drawable.bvl;
                                                    case com.tencent.luggage.wxa.gg.e.CTRL_INDEX /* 779 */:
                                                        return R.drawable.gin;
                                                    case MiniReportManager.EventId.SDK_EMBEDDED_SUPPORT_RESULT /* 780 */:
                                                        return R.drawable.giu;
                                                    case 796:
                                                        return R.drawable.gae;
                                                    case 797:
                                                        return R.drawable.gag;
                                                    case com.tencent.luggage.wxa.b7.a.CTRL_INDEX /* 799 */:
                                                        return R.drawable.gaa;
                                                    case 800:
                                                        return R.drawable.ga_;
                                                    case 801:
                                                        return R.drawable.qzone_skin_feed_operation_list_forward_icon;
                                                    case 802:
                                                        return R.drawable.g3f;
                                                    case 804:
                                                        return R.drawable.arn;
                                                    case 805:
                                                        return R.drawable.arl;
                                                    case 806:
                                                        return R.drawable.g3l;
                                                    case 807:
                                                        return R.drawable.atv;
                                                    case com.tencent.luggage.wxa.uf.f.CTRL_INDEX /* 812 */:
                                                        return R.drawable.qzone_skin_feed_operation_list_comment_icon;
                                                    case com.tencent.luggage.wxa.uf.e.CTRL_INDEX /* 813 */:
                                                        return R.drawable.b0k;
                                                    case com.tencent.luggage.wxa.he.k.CTRL_INDEX /* 815 */:
                                                        return R.drawable.g4c;
                                                    case 816:
                                                        return R.drawable.g67;
                                                    case 822:
                                                        return R.drawable.qzone_skin_feed_card_bg;
                                                    case 823:
                                                    case 824:
                                                        return R.drawable.g2q;
                                                    case 825:
                                                        return R.drawable.atg;
                                                    case BusinessInfoCheckUpdateItem.UIAPPID_XINGQU_BULUO /* 826 */:
                                                        return R.drawable.ath;
                                                    case 827:
                                                        return R.drawable.g2o;
                                                    case 828:
                                                        return R.drawable.g2s;
                                                    case QCircleReportHelper.SCENE_PAGE_ID_NEW_POLYMERIZE_DETAIL_GROUP_PAGE /* 831 */:
                                                        return R.drawable.gai;
                                                    case 832:
                                                        return R.drawable.skin_icon_arrow_right_normal;
                                                    case 833:
                                                        return R.drawable.b8p;
                                                    case 834:
                                                        return R.drawable.gj5;
                                                    case 835:
                                                        return R.drawable.f162367gj3;
                                                    case 836:
                                                        return R.drawable.f162368gj4;
                                                    case LiteTransferType.MsgBodyType.MsgType_0x346 /* 838 */:
                                                        return R.drawable.g47;
                                                    case 839:
                                                        return R.drawable.g48;
                                                    case 847:
                                                    case 879:
                                                        return R.drawable.gj8;
                                                    case 849:
                                                        return R.drawable.g1j;
                                                    case 850:
                                                        return R.drawable.gdq;
                                                    case QCircleReportHelper.SCENE_PAGE_ID_NEW_POLYMERIZE_DETAIL_QZONE_PAGE /* 851 */:
                                                        return R.drawable.qzone_skin_secret_feed_up;
                                                    case 852:
                                                        return R.drawable.qzone_skin_secret_feed_down;
                                                    case 856:
                                                        return R.drawable.ata;
                                                    case u.CTRL_INDEX /* 857 */:
                                                        return R.drawable.g4b;
                                                    case com.tencent.luggage.wxa.q2.d.CTRL_INDEX /* 867 */:
                                                        return R.drawable.g1b;
                                                    case 868:
                                                        return R.drawable.qzone_skin_feed_shadow_bg;
                                                    case 869:
                                                        return R.drawable.qzone_skin_feed_high5_icon_normal;
                                                    case 870:
                                                        return R.drawable.qzone_skin_feed_high5_icon_clicked;
                                                    case 871:
                                                        return R.drawable.g2a;
                                                    case 872:
                                                        return R.drawable.g49;
                                                    case QBoxConfProcessor.TASK_TYPE_ID /* 875 */:
                                                    case 902:
                                                        return R.drawable.qzone_skin_feed_icon_praise;
                                                    case 876:
                                                        return R.drawable.qzone_skin_feed_arrow_fold;
                                                    case 877:
                                                        return R.drawable.qzone_skin_feed_arrow_unfold;
                                                    case 878:
                                                        return R.drawable.b08;
                                                    case x.CTRL_INDEX /* 880 */:
                                                        return R.drawable.f160736ml;
                                                    case 881:
                                                        return R.drawable.at9;
                                                    case 882:
                                                        return R.drawable.g1h;
                                                    case 883:
                                                        return R.drawable.auu;
                                                    case 900:
                                                    case 945:
                                                        return R.drawable.qzone_skin_feed_comment_comment;
                                                    case 901:
                                                        return R.drawable.qzone_skin_feed_comment_comment_click;
                                                    case 905:
                                                        return R.drawable.qzone_skin_feed_inputbox_present_icon;
                                                    case 915:
                                                        return R.drawable.f161175rp;
                                                    case 920:
                                                        return R.drawable.ghi;
                                                    case 921:
                                                        return R.drawable.ghj;
                                                    case 922:
                                                        return R.drawable.git;
                                                    case 923:
                                                        return R.drawable.gis;
                                                    case 925:
                                                        return R.drawable.ghy;
                                                    case 926:
                                                        return R.drawable.ghx;
                                                    case l0.CTRL_INDEX /* 927 */:
                                                        return R.drawable.g1c;
                                                    case 928:
                                                        return R.drawable.qzone_skin_feed_card_bg_shadow_8;
                                                    case 929:
                                                        return R.drawable.cmn;
                                                    case 930:
                                                        return R.drawable.g3r;
                                                    case 931:
                                                        return R.drawable.g3q;
                                                    case 932:
                                                        return R.drawable.g3t;
                                                    case 933:
                                                        return R.drawable.g3s;
                                                    case 934:
                                                        return R.drawable.atr;
                                                    case 935:
                                                        return R.drawable.att;
                                                    case com.tencent.luggage.wxa.i2.b.CTRL_INDEX /* 938 */:
                                                        return R.drawable.f162360gh3;
                                                    case 942:
                                                        return R.drawable.avp;
                                                    case 944:
                                                        return R.drawable.g26;
                                                    case 946:
                                                        return R.drawable.qzone_skin_feed_icon_forward;
                                                    case 949:
                                                        return R.drawable.hi7;
                                                    case 954:
                                                        return R.drawable.bhr;
                                                    case com.tencent.luggage.wxa.yf.o.CTRL_INDEX /* 955 */:
                                                        return R.drawable.bjk;
                                                    case 961:
                                                        return R.drawable.bhs;
                                                    case 962:
                                                        return R.drawable.bhq;
                                                    case 963:
                                                        return R.drawable.bhy;
                                                    case 964:
                                                        return R.drawable.bhz;
                                                    case 965:
                                                        return R.drawable.g4o;
                                                    case 966:
                                                        return R.drawable.dbe;
                                                    case 973:
                                                        return R.drawable.lck;
                                                    case QQConstants.REMINDER_POS_ID /* 974 */:
                                                        return R.drawable.na7;
                                                    case 975:
                                                        return R.drawable.ldv;
                                                    case 976:
                                                        return R.drawable.nb6;
                                                    case 977:
                                                        return R.drawable.na9;
                                                    case 979:
                                                        return R.drawable.lek;
                                                    case 981:
                                                        return R.drawable.ldp;
                                                    case 982:
                                                        return R.drawable.m1g;
                                                    default:
                                                        switch (i3) {
                                                            case 404:
                                                                return R.drawable.aio;
                                                            case 405:
                                                                return R.drawable.b2e;
                                                            case 406:
                                                                return R.drawable.f162345as1;
                                                            case 407:
                                                                return R.drawable.b3b;
                                                            default:
                                                                switch (i3) {
                                                                    case PlayerResources.ViewId.GET_MORE_TOGGLE_AREA /* 560 */:
                                                                        return R.drawable.g1w;
                                                                    case PlayerResources.ViewId.GET_MORE_TOGGLE_ARROW_BTN /* 561 */:
                                                                        return R.drawable.g1x;
                                                                    case PlayerResources.ViewId.GET_MORE_JUMP_AREA /* 562 */:
                                                                        return R.drawable.f162256g61;
                                                                    case PlayerResources.ViewId.GET_MORE_JUMP_TIPS_BTN /* 563 */:
                                                                        return R.drawable.f162228g31;
                                                                    case PlayerResources.ViewId.NEXT_VIDEO_COUNT_DOWN_TIP /* 564 */:
                                                                        return R.drawable.f162229g32;
                                                                    case PlayerResources.ViewId.EXTENDED_VIEW_NAME_PLUS_HEAD /* 565 */:
                                                                        return R.drawable.g8v;
                                                                    case PlayerResources.ViewId.EXTENDED_VIEW_IV_USER_PORTRAIT /* 566 */:
                                                                        return R.drawable.ghl;
                                                                    case 567:
                                                                        return R.drawable.fyj;
                                                                    case PlayerResources.ViewId.EXTENDED_VIEW_BTN_NORMAL_BUTTON /* 568 */:
                                                                        return R.drawable.fyn;
                                                                    case PlayerResources.ViewId.EXTENDED_VIEW_BTN_SHINE_BUTTON /* 569 */:
                                                                        return R.drawable.ax6;
                                                                    default:
                                                                        switch (i3) {
                                                                            case PlayerResources.ViewId.EXTENDED_VIEW_LEFT_TOP_CIRCLE /* 571 */:
                                                                                return R.drawable.ax7;
                                                                            case PlayerResources.ViewId.EXTENDED_VIEW_TV_COUNTDOWN /* 572 */:
                                                                                return R.drawable.ax9;
                                                                            case PlayerResources.ViewId.EXTENDED_VIEW_IV_USER_PORTRAIT_CONTAINER /* 573 */:
                                                                                return R.drawable.g7k;
                                                                            case 574:
                                                                                return R.drawable.g7l;
                                                                            case 575:
                                                                                return R.drawable.g7j;
                                                                            default:
                                                                                switch (i3) {
                                                                                    case 577:
                                                                                        return R.drawable.qzone_skin_feed_icon_gift;
                                                                                    case 578:
                                                                                        return R.drawable.f162363gi1;
                                                                                    case 579:
                                                                                        return R.drawable.f162362gi0;
                                                                                    case 580:
                                                                                        return R.drawable.gia;
                                                                                    default:
                                                                                        switch (i3) {
                                                                                            case 583:
                                                                                                return R.drawable.g2y;
                                                                                            case 584:
                                                                                                return R.drawable.g2z;
                                                                                            case LpReportInfoConfig.ACTION_TYPE_MOOD_LIST /* 585 */:
                                                                                                return R.drawable.f162227g30;
                                                                                            case 586:
                                                                                                return R.drawable.gfj;
                                                                                            default:
                                                                                                return 0;
                                                                                        }
                                                                                }
                                                                        }
                                                                }
                                                        }
                                                }
                                            }
                                            return R.drawable.ati;
                                        }
                                        return R.drawable.qzone_skin_feed_inputbox_rapid_comment_icon;
                                    }
                                    return R.color.black;
                                }
                                return R.color.cna;
                            }
                            return R.color.f156603a;
                        }
                        return R.color.f156679n;
                    }
                    return R.color.f156647j;
                }
                return R.color.f156606d;
            }
            return R.color.a_l;
        }
        return R.color.a6v;
    }

    @Override // com.qzone.adapter.feedcomponent.o
    public int getLayoutId(int i3) {
        switch (i3) {
            case 1642:
                return R.layout.f169054bv1;
            case 1643:
            case 1648:
            case 1649:
            case 1651:
            case 1653:
            case 1655:
            case 1656:
            case 1657:
            case 1658:
            case 1659:
            case 1660:
            case 1663:
            case 1664:
            case 1665:
            case 1666:
            case 1669:
            case 1673:
            case 1678:
            case 1683:
            case 1684:
            case 1685:
            case 1686:
            case 1687:
            case 1688:
            case 1689:
            case 1690:
            case 1691:
            case 1692:
            case 1697:
            case 1713:
            case 1714:
            case 1715:
            case 1718:
            case 1720:
            case 1723:
            default:
                return 0;
            case 1644:
                return R.layout.btv;
            case 1645:
                return R.layout.bur;
            case 1646:
                return R.layout.bus;
            case 1647:
                return R.layout.bv6;
            case 1650:
                return R.layout.bul;
            case 1652:
                return R.layout.bua;
            case 1654:
                return R.layout.buc;
            case 1661:
                return R.layout.f169057bv4;
            case 1662:
                return R.layout.bv5;
            case 1667:
                return R.layout.f169055bv2;
            case 1668:
                return R.layout.bv7;
            case 1670:
                return R.layout.buo;
            case 1671:
                return R.layout.buq;
            case 1672:
                return R.layout.bup;
            case 1674:
                return R.layout.f169008bl1;
            case 1675:
                return R.layout.bls;
            case 1676:
                return R.layout.f169009bl2;
            case 1677:
                return R.layout.f169007bl0;
            case 1679:
                return R.layout.blg;
            case 1680:
                return R.layout.ble;
            case 1681:
                return R.layout.blf;
            case 1682:
                return R.layout.blr;
            case 1693:
                return R.layout.bub;
            case 1694:
                return R.layout.btg;
            case 1695:
                return R.layout.btu;
            case 1696:
                return R.layout.f169056bv3;
            case 1698:
                return R.layout.bu7;
            case 1699:
                return R.layout.f169053bv0;
            case FSUploadConst.ERR_FILE_NOT_EXIST /* 1700 */:
                return R.layout.bud;
            case UfsGROUPMASK.GROUP_MASK_MINI_APP /* 1701 */:
                return R.layout.bl6;
            case FSUploadConst.ERR_LOGIN_STATUS_EMPTY /* 1702 */:
                return R.layout.f169013bm4;
            case FSUploadConst.ERR_LOGIN_UIN_ILLEGAL /* 1703 */:
                return R.layout.bqp;
            case FSUploadConst.ERR_UPLOAD_RESULT_ILLEGAL /* 1704 */:
                return R.layout.bl9;
            case FSUploadConst.ERR_NO_LOGIN /* 1705 */:
                return R.layout.bl_;
            case FSUploadConst.ERR_COMPRESS_ENV_UNPREPAERD /* 1706 */:
                return R.layout.bpo;
            case FSUploadConst.ERR_GENERATE_VIDEO_COVER_FAIL /* 1707 */:
                return R.layout.bts;
            case 1708:
                return R.layout.bto;
            case 1709:
                return R.layout.f167646cr;
            case 1710:
                return R.layout.bv8;
            case 1711:
                return R.layout.bsy;
            case 1712:
                return R.layout.bqv;
            case 1716:
                return R.layout.f169045ce0;
            case 1717:
                return R.layout.afo;
            case 1719:
                return R.layout.hkx;
            case 1721:
                return R.layout.hkw;
            case 1722:
                return R.layout.hkv;
            case 1724:
                return R.layout.qzone_feedx_detail_header;
        }
    }

    @Override // com.qzone.adapter.feedcomponent.o
    public int getViewId(int i3) {
        if (i3 != 2200) {
            if (i3 != 2201) {
                if (i3 != 2203) {
                    if (i3 != 2204) {
                        if (i3 != 2212) {
                            if (i3 != 2213) {
                                switch (i3) {
                                    case 2184:
                                        return R.id.c96;
                                    case 2231:
                                        return R.id.f165384cw3;
                                    case 2232:
                                        return R.id.b95;
                                    case 2233:
                                        return R.id.f166968jh4;
                                    case 2234:
                                        return R.id.f166967jh3;
                                    case 2235:
                                        return R.id.jgt;
                                    case 2236:
                                        return R.id.jgs;
                                    case 2237:
                                        return R.id.jij;
                                    case 2238:
                                        return R.id.aml;
                                    case 2239:
                                        return R.id.ezs;
                                    case 2240:
                                        return R.id.b3h;
                                    case 2241:
                                        return R.id.b3i;
                                    case 2242:
                                        return R.id.c9x;
                                    case 2243:
                                        return R.id.c8v;
                                    case 2244:
                                        return R.id.c6r;
                                    case 2311:
                                        return R.id.c5m;
                                    case 2314:
                                        return R.id.c8p;
                                    case 2315:
                                        return R.id.c8s;
                                    case 2316:
                                        return R.id.c8n;
                                    case 2317:
                                        return R.id.c8g;
                                    case 2318:
                                        return R.id.c8h;
                                    case 2319:
                                        return R.id.c8i;
                                    case 2320:
                                        return R.id.c8q;
                                    case 2321:
                                        return R.id.c8r;
                                    case 2322:
                                        return R.id.i1l;
                                    case 2323:
                                        return R.id.i1k;
                                    case 2324:
                                        return R.id.c8u;
                                    case 2325:
                                        return R.id.c8t;
                                    case 2326:
                                        return R.id.i1r;
                                    case 2327:
                                        return R.id.i2f;
                                    case 2330:
                                        return R.id.c8j;
                                    case 2331:
                                        return R.id.c9_;
                                    case 2332:
                                        return R.id.ff8;
                                    case 2333:
                                        return R.id.ff_;
                                    case 2386:
                                        return R.id.c5w;
                                    case 2387:
                                        return R.id.cgr;
                                    case 2388:
                                        return R.id.cgs;
                                    case 2389:
                                        return R.id.c8_;
                                    case 2390:
                                        return R.id.i2d;
                                    case 2391:
                                        return R.id.f165284cn4;
                                    case 2392:
                                        return R.id.c6_;
                                    case 2393:
                                        return R.id.cmz;
                                    case 2394:
                                        return R.id.f165280cn0;
                                    case 2395:
                                        return R.id.f165281cn1;
                                    case 2396:
                                        return R.id.cn5;
                                    case 2397:
                                        return R.id.f165283cn3;
                                    case 2398:
                                        return R.id.cn6;
                                    case 2399:
                                        return R.id.f165282cn2;
                                    case WnsError.WNS_CODE_DIS_STAT_BEGIN /* 2400 */:
                                        return R.id.cnb;
                                    case JsonGrayBusiId.AIO_GROUP_ESSENCE_MSG_TIP /* 2401 */:
                                        return R.id.cna;
                                    case 2402:
                                        return R.id.cn7;
                                    case JsonGrayBusiId.GROUP_AIO_UPLOAD_PERMISSIONS_GRAY_TIP_ID /* 2403 */:
                                        return R.id.cn8;
                                    case JsonGrayBusiId.GROUP_AIO_HOME_SCHOOL_WELCOME_GRAY_TIP_ID /* 2404 */:
                                        return R.id.cn9;
                                    case 2411:
                                        return R.id.c8x;
                                    case 2413:
                                        return R.id.c6e;
                                    case 2414:
                                        return R.id.c8a;
                                    case 2415:
                                        return R.id.cqc;
                                    case 2416:
                                        return R.id.cqb;
                                    case 2417:
                                        return R.id.cqe;
                                    case 2418:
                                        return R.id.cqd;
                                    case 2419:
                                        return R.id.cq_;
                                    case BuildConfig.VERSION_CODE /* 2444 */:
                                        return R.id.i1x;
                                    case 2445:
                                        return R.id.kxz;
                                    case 2446:
                                        return R.id.f167111ky1;
                                    case 2447:
                                        return R.id.i7a;
                                    case 2448:
                                        return R.id.i7e;
                                    case 2449:
                                        return R.id.i7d;
                                    case 2450:
                                        return R.id.f165197c94;
                                    case 2451:
                                        return R.id.c95;
                                    case 2452:
                                        return R.id.f0u;
                                    case 2454:
                                        return R.id.f0l;
                                    case 2469:
                                        return R.id.c5t;
                                    case 2470:
                                        return R.id.f164048ig;
                                    case 2471:
                                        return R.id.d3n;
                                    case 2472:
                                        return R.id.i1p;
                                    case 2473:
                                        return R.id.ff7;
                                    case 2484:
                                        return R.id.cmh;
                                    case 2485:
                                        return R.id.cm9;
                                    case 2486:
                                        return R.id.cmp;
                                    case 2487:
                                        return R.id.cm5;
                                    case 2488:
                                        return R.id.cmt;
                                    case 2489:
                                        return R.id.f165277cm2;
                                    case 2490:
                                        return R.id.cm7;
                                    case 2491:
                                        return R.id.cmi;
                                    case 2493:
                                        return R.id.f165279cm4;
                                    case 2494:
                                        return R.id.cmc;
                                    case 2495:
                                        return R.id.cme;
                                    case 2496:
                                        return R.id.cmd;
                                    case 2497:
                                        return R.id.cmf;
                                    case 2498:
                                        return R.id.cm6;
                                    case 2499:
                                        return R.id.f165278cm3;
                                    case 2500:
                                        return R.id.cmj;
                                    case 2501:
                                        return R.id.cmk;
                                    case 2502:
                                        return R.id.cmo;
                                    case 2503:
                                        return R.id.cmr;
                                    case 2504:
                                        return R.id.cmm;
                                    case 2505:
                                        return R.id.cmn;
                                    case 2506:
                                        return R.id.cm_;
                                    case 2507:
                                        return R.id.cmq;
                                    case 2508:
                                        return R.id.cma;
                                    case 2514:
                                        return R.id.i2h;
                                    case 2570:
                                        return R.id.c5u;
                                    case 2575:
                                        return R.id.c6g;
                                    case 2576:
                                        return R.id.c6f;
                                    case 2578:
                                        return R.id.c9v;
                                    case 2579:
                                        return R.id.c9w;
                                    case 2580:
                                        return R.id.c8e;
                                    case 2581:
                                        return R.id.c8d;
                                    case 2582:
                                        return R.id.c8c;
                                    case 2584:
                                        return R.id.a0c;
                                    case 2585:
                                        return R.id.a0e;
                                    case 2586:
                                        return R.id.a0d;
                                    case 2598:
                                        return R.id.c4q;
                                    case 2599:
                                        return R.id.cmu;
                                    case 2600:
                                        return R.id.cmv;
                                    case JsonGrayBusiId.QCIRCLE_SHOW_FULE_TIPS /* 2601 */:
                                        return R.id.cmw;
                                    case JsonGrayBusiId.QWALLET_GRAY_TIP_ID /* 2602 */:
                                        return R.id.c5d;
                                    case JsonGrayBusiId.DISBAND_DISCUSSION_GRAY_TIP_ID /* 2603 */:
                                        return R.id.f165163c54;
                                    case 2604:
                                        return R.id.c5b;
                                    case 2605:
                                        return R.id.c5c;
                                    case 2606:
                                        return R.id.c7v;
                                    case 2607:
                                        return R.id.hur;
                                    case 2608:
                                        return R.id.c3y;
                                    case 2624:
                                        return R.id.c5_;
                                    case 2625:
                                        return R.id.f166472ff1;
                                    case 2626:
                                        return R.id.f166473ff2;
                                    case 2630:
                                        return R.id.epn;
                                    case 2631:
                                        return R.id.epo;
                                    case 2632:
                                        return R.id.epk;
                                    case 2633:
                                        return R.id.epl;
                                    case 2634:
                                        return R.id.f165255ch3;
                                    case 2635:
                                        return R.id.f165253ch0;
                                    case 2636:
                                        return R.id.ch7;
                                    case 2637:
                                        return R.id.ch6;
                                    case 2638:
                                        return R.id.f165254ch1;
                                    case 2639:
                                        return R.id.d87;
                                    case 2640:
                                        return R.id.d8e;
                                    case 2641:
                                        return R.id.d8d;
                                    case 2642:
                                        return R.id.d8h;
                                    case 2643:
                                        return R.id.d88;
                                    case 2644:
                                        return R.id.d8f;
                                    case 2654:
                                        return R.id.f165185c80;
                                    case 2663:
                                        return R.id.f165186c81;
                                    case 2664:
                                        return R.id.hh6;
                                    case 2665:
                                        return R.id.b5d;
                                    case 2677:
                                        return R.id.hhw;
                                    case 2678:
                                        return R.id.hho;
                                    case 2679:
                                        return R.id.hhq;
                                    case 2680:
                                        return R.id.hhv;
                                    case 2681:
                                        return R.id.hhr;
                                    case 2682:
                                        return R.id.hht;
                                    case 2683:
                                        return R.id.hhu;
                                    case 2684:
                                        return R.id.hhs;
                                    case 2685:
                                        return R.id.hhp;
                                    case 2686:
                                        return R.id.ksb;
                                    case 2704:
                                        return R.id.cm8;
                                    case 2705:
                                        return R.id.cml;
                                    case 2706:
                                        return R.id.cmb;
                                    case 2709:
                                        return R.id.d8g;
                                    case 2710:
                                        return R.id.iwk;
                                    case 2711:
                                        return R.id.hic;
                                    case 2712:
                                        return R.id.hi9;
                                    case 2713:
                                        return R.id.f166712hi3;
                                    case 2714:
                                        return R.id.hib;
                                    case 2715:
                                        return R.id.hia;
                                    case 2716:
                                        return R.id.f166713hi4;
                                    case 2717:
                                        return R.id.hi8;
                                    case 2718:
                                        return R.id.hi6;
                                    case 2719:
                                        return R.id.epm;
                                    case 2720:
                                        return R.id.epp;
                                    case 2721:
                                        return R.id.c7t;
                                    case 2722:
                                        return R.id.c7u;
                                    case 2723:
                                        return R.id.f166710hi1;
                                    case 2724:
                                        return R.id.f166711hi2;
                                    case 2725:
                                        return R.id.c7q;
                                    case 2726:
                                        return R.id.c7l;
                                    case 2727:
                                        return R.id.c7o;
                                    case 2734:
                                        return R.id.c79;
                                    case 2735:
                                        return R.id.c4l;
                                    case 2736:
                                        return R.id.head;
                                    case 2737:
                                        return R.id.c6a;
                                    case 2738:
                                        return R.id.f165160c51;
                                    case 2739:
                                        return R.id.f0p;
                                    case 2740:
                                        return R.id.il_;
                                    case 2741:
                                        return R.id.c7h;
                                    case 2742:
                                        return R.id.c7f;
                                    case 2743:
                                        return R.id.d8p;
                                    case 2744:
                                        return R.id.cwi;
                                    case 2745:
                                        return R.id.cwk;
                                    case 2746:
                                        return R.id.ila;
                                    case 2747:
                                        return R.id.hij;
                                    case 2748:
                                        return R.id.c6j;
                                    case 2764:
                                        return R.id.hft;
                                    case 2765:
                                        return R.id.hfu;
                                    case 2766:
                                        return R.id.c6h;
                                    case 2767:
                                        return R.id.f165177c63;
                                    case 2768:
                                        return R.id.c5x;
                                    case 2769:
                                        return R.id.c67;
                                    case 2770:
                                        return R.id.c66;
                                    case 2771:
                                        return R.id.c5y;
                                    case 2772:
                                        return R.id.c68;
                                    case 2773:
                                        return R.id.c65;
                                    case 2774:
                                        return R.id.f165176c62;
                                    case 2775:
                                        return R.id.f165173c60;
                                    case 2776:
                                        return R.id.c5z;
                                    case 2777:
                                        return R.id.f165196c93;
                                    case 2778:
                                        return R.id.g4p;
                                    case 2779:
                                        return R.id.f165276cm1;
                                    case 2780:
                                        return R.id.cms;
                                    case 2782:
                                        return R.id.f164851b34;
                                    case 2783:
                                        return R.id.c78;
                                    case 2784:
                                        return R.id.b38;
                                    case 2785:
                                        return R.id.f164852b35;
                                    case 2786:
                                        return R.id.c98;
                                    case 2787:
                                        return R.id.c4o;
                                    case 2788:
                                        return R.id.c99;
                                    case 2789:
                                        return R.id.c7z;
                                    case 2790:
                                        return R.id.c7n;
                                    case 2791:
                                        return R.id.c7k;
                                    case 2792:
                                        return R.id.i6c;
                                    case 2793:
                                        return R.id.i67;
                                    case 2794:
                                        return R.id.f165162c53;
                                    case 2795:
                                        return R.id.ap6;
                                    case 2796:
                                        return R.id.i5y;
                                    case 2797:
                                        return R.id.f166775i61;
                                    case 2798:
                                        return R.id.f166776i62;
                                    case 2799:
                                        return R.id.i5x;
                                    case 2800:
                                        return R.id.i5w;
                                    case 2801:
                                        return R.id.i69;
                                    case 2802:
                                        return R.id.i6e;
                                    case 2803:
                                        return R.id.f166778i64;
                                    case 2804:
                                        return R.id.i65;
                                    case 2805:
                                        return R.id.i66;
                                    case 2806:
                                        return R.id.f166774i60;
                                    case 2807:
                                        return R.id.i68;
                                    case 2808:
                                        return R.id.i6_;
                                    case 2809:
                                        return R.id.i6a;
                                    case 2810:
                                        return R.id.i6b;
                                    case 2811:
                                        return R.id.f166777i63;
                                    case 2812:
                                        return R.id.c6b;
                                    case 2813:
                                        return R.id.c6c;
                                    case 2814:
                                        return R.id.f165161c52;
                                    case 2815:
                                        return R.id.h8x;
                                    case 2816:
                                        return R.id.c5s;
                                    case 2817:
                                        return R.id.g4o;
                                    case 2834:
                                        return R.id.d0r;
                                    case 2835:
                                        return R.id.d0n;
                                    case 2836:
                                        return R.id.d0p;
                                    case 2837:
                                        return R.id.d0u;
                                    case 2838:
                                        return R.id.d0s;
                                    case 2839:
                                        return R.id.b3c;
                                    case 2840:
                                        return R.id.epj;
                                    case 2841:
                                        return R.id.hr6;
                                    case 2842:
                                        return R.id.hr7;
                                    case 2843:
                                        return R.id.jte;
                                    case 2844:
                                        return R.id.i2m;
                                    case 2845:
                                        return R.id.c8o;
                                    case 2846:
                                        return R.id.i2i;
                                    case 2847:
                                        return R.id.i2k;
                                    case 2848:
                                        return R.id.i2j;
                                    case 2849:
                                        return R.id.c8l;
                                    case 2850:
                                        return R.id.c8k;
                                    case 2851:
                                        return R.id.c8m;
                                    case 2852:
                                        return R.id.cqa;
                                    case 2860:
                                        return R.id.c7s;
                                    case 2861:
                                        return R.id.c7r;
                                    case 2863:
                                        return R.id.lkq;
                                    case 2864:
                                        return R.id.lkn;
                                    case 2865:
                                        return R.id.lko;
                                    case 2866:
                                        return R.id.lkp;
                                    case 2867:
                                        return R.id.lhh;
                                    case 2868:
                                        return R.id.lhi;
                                    case 2869:
                                        return R.id.lhb;
                                    case 2870:
                                        return R.id.lhd;
                                    case 2871:
                                        return R.id.lh_;
                                    case 2872:
                                        return R.id.lh8;
                                    case 2873:
                                        return R.id.lh9;
                                    case 2874:
                                        return R.id.f165156lh4;
                                    case 2875:
                                        return R.id.lh6;
                                    case 2876:
                                        return R.id.lh7;
                                    case 2877:
                                        return R.id.lh5;
                                    case 2878:
                                        return R.id.f165155lh3;
                                    case 2879:
                                        return R.id.ayz;
                                    case 2880:
                                        return R.id.f165882az0;
                                    case 2881:
                                        return R.id.b6b;
                                    case 2882:
                                        return R.id.k6u;
                                    case 2883:
                                        return R.id.e2d;
                                    case 2884:
                                        return R.id.e2e;
                                    case 2885:
                                        return R.id.f166007bf2;
                                    case 2886:
                                        return R.id.f165171a91;
                                    case 2887:
                                        return R.id.f165170a90;
                                    case 2888:
                                        return R.id.f165172a92;
                                    case 2889:
                                        return R.id.al7;
                                    case 2890:
                                        return R.id.afn;
                                    case 2892:
                                        return R.id.ace;
                                    case 2893:
                                        return R.id.f165174ab3;
                                    case 2894:
                                        return R.id.acf;
                                    case 2895:
                                        return R.id.abo;
                                    case 2896:
                                        return R.id.aci;
                                    case 2897:
                                        return R.id.acd;
                                    case 2898:
                                        return R.id.al6;
                                    case 2899:
                                        return R.id.f165178c64;
                                    case BaseConstants.CODE_SERVER_RETURN_ERROR /* 2900 */:
                                        return R.id.caz;
                                    case BaseConstants.CODE_RESENDMSG /* 2901 */:
                                        return R.id.ih9;
                                    case BaseConstants.CODE_SEND_WITH_NO_AUTH_ERROR /* 2902 */:
                                        return R.id.f68393fx;
                                    case 2903:
                                        return R.id.f68423g0;
                                    case 2904:
                                        return R.id.f68413fz;
                                    case 2905:
                                        return R.id.f68403fy;
                                    case 2909:
                                        return R.id.f68523g_;
                                    case 2910:
                                        return R.id.f68493g7;
                                    case 2911:
                                        return R.id.f68483g6;
                                    case 2912:
                                        return R.id.f68513g9;
                                    case 2913:
                                        return R.id.f68503g8;
                                    case 2914:
                                        return R.id.f165157v14;
                                    case 2915:
                                        return R.id.f165158v15;
                                    case 2916:
                                        return R.id.v16;
                                    case 2917:
                                        return R.id.ff6;
                                    case 17185:
                                        return R.id.c4r;
                                    case 17186:
                                        return R.id.c4s;
                                    default:
                                        switch (i3) {
                                            case 2187:
                                                return R.id.ffa;
                                            case 2188:
                                                return R.id.c7p;
                                            case 2189:
                                                return R.id.c7j;
                                            case 2190:
                                                return R.id.c7m;
                                            case 2191:
                                                return R.id.c4j;
                                            case 2192:
                                                return R.id.c7y;
                                            case 2193:
                                                return R.id.c58;
                                            default:
                                                switch (i3) {
                                                    case 2196:
                                                        return R.id.a0a;
                                                    case 2197:
                                                        return R.id.c4x;
                                                    case 2198:
                                                        return R.id.c7y;
                                                    default:
                                                        switch (i3) {
                                                            case Constants.Action.ACTION_VERIFY_PASSWD_SUBMIT_IMAGECODE /* 2206 */:
                                                                return R.id.c7x;
                                                            case Constants.Action.ACTION_VERIFY_PASSWD_REFRESH_IMAGECODE /* 2207 */:
                                                                return R.id.c4u;
                                                            case Constants.Action.ACTION_WTLOGIN_GET_OPEN_KEY_WITHOUT_PASSWD /* 2208 */:
                                                                return R.id.c87;
                                                            case 2209:
                                                                return R.id.f165190c90;
                                                            case Constants.Action.ACTION_MANUAL_SET_LOG_LEVEL /* 2210 */:
                                                                return R.id.f165188c83;
                                                            default:
                                                                switch (i3) {
                                                                    case Constants.Action.ACTION_NOTIFY_MSF_WEAK_NET_SWITCH /* 2222 */:
                                                                        return R.id.i1t;
                                                                    case Constants.Action.ACTION_AFTER_FETCH_CONFIG_LOG_REPORT /* 2223 */:
                                                                        return R.id.i1q;
                                                                    case Constants.Action.ACTION_UPDATE_COMPLEX_CONNECT_CONFIG /* 2224 */:
                                                                        return R.id.i1s;
                                                                    case Constants.Action.ACTION_UPDATE_MSF_MMKV_CONFIG /* 2225 */:
                                                                        return R.id.f165672d32;
                                                                    case Constants.Action.ACTION_NOTIFY_MSF_MSG_SYNC_END /* 2226 */:
                                                                        return R.id.f165674d34;
                                                                    case Constants.Action.ACTION_UPDATE_BEFORE_MSG_SYNC_CONTROL_CONFIG /* 2227 */:
                                                                        return R.id.d8s;
                                                                    case Constants.Action.ACTION_NOTIFY_MSF_ONLINE_REGISTER /* 2228 */:
                                                                        return R.id.f165673d33;
                                                                    default:
                                                                        switch (i3) {
                                                                            case 2250:
                                                                                return R.id.b37;
                                                                            case 2251:
                                                                                return R.id.b2z;
                                                                            case 2252:
                                                                                return R.id.b3a;
                                                                            case 2253:
                                                                                return R.id.f164849b32;
                                                                            case 2254:
                                                                                return R.id.b3d;
                                                                            case 2255:
                                                                                return R.id.b3b;
                                                                            case 2256:
                                                                                return R.id.b56;
                                                                            case 2257:
                                                                                return R.id.a1_;
                                                                            case 2258:
                                                                                return R.id.f164850b33;
                                                                            case 2259:
                                                                                return R.id.c3x;
                                                                            default:
                                                                                switch (i3) {
                                                                                    case JsonGrayBusiId.AIO_ZPLAN_SCENE_LINKAGE /* 2302 */:
                                                                                        return R.id.i0m;
                                                                                    case 2303:
                                                                                        return R.id.f165159c50;
                                                                                    case 2304:
                                                                                        return R.id.kxy;
                                                                                    case 2305:
                                                                                        return R.id.djp;
                                                                                    default:
                                                                                        return 0;
                                                                                }
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                            }
                            return R.id.c6d;
                        }
                        return R.id.c4y;
                    }
                    return R.id.c4k;
                }
                return R.id.a0b;
            }
            return R.id.c59;
        }
        return R.id.c5a;
    }

    @Override // com.qzone.adapter.feedcomponent.o
    public Object e(int i3) {
        switch (i3) {
            case 1639:
                return R.styleable.CustomGridLayout;
            case 1640:
            case 1649:
                return 1;
            case 1641:
            case 1652:
                return 4;
            case 1642:
            case 1651:
            case 1668:
                return 3;
            case 1643:
            case 1646:
            case 1659:
            case 1670:
                return 0;
            case 1644:
            case 1650:
                return 2;
            case 1645:
                return R.styleable.Markable;
            case 1647:
            case 1666:
                return 7;
            case 1648:
            case 1665:
                return 8;
            case 1653:
                return 5;
            case 1654:
            case 1664:
                return 6;
            case 1655:
            case 1656:
            case 1657:
            default:
                return null;
            case 1658:
                return R.styleable.CellTextView;
            case 1660:
                return 16;
            case 1661:
                return 10;
            case 1662:
                return 15;
            case 1663:
                return 14;
            case 1667:
                return 9;
            case 1669:
                return jj2.b.Y6;
        }
    }

    public static Drawable g(int i3) {
        switch (i3) {
            case WnsError.WNS_CODE_LOGIN_ILLIGAL_APPID /* 1912 */:
                return ResDownloadManger.getmInstance().getDrawableAsync(5, "qzone_video2_bg_comments", null);
            case 1913:
                return ResDownloadManger.getmInstance().getDrawableAsync(5, "qzone_video2_bg_comments_mutant", null);
            case 1914:
                return ResDownloadManger.getmInstance().getDrawableAsync(5, "qzone_video_rounded_cover", null);
            case 1915:
                return ResDownloadManger.getmInstance().getDrawableAsync(5, "qzone_feed_video_replay", null);
            case 1916:
                return ResDownloadManger.getmInstance().getDrawableAsync(5, "qzone_feed_video_mo`re", null);
            case 1917:
                return ResDownloadManger.getmInstance().getDrawableAsync(5, "qzone_icon_action_sheet_weibo", null);
            case 1918:
                return ResDownloadManger.getmInstance().getDrawableAsync(5, "qzone_detail_panel_copy", null);
            case 1919:
                return ResDownloadManger.getmInstance().getDrawableAsync(5, "qzone_detail_panel_forword", null);
            case 1920:
                return ResDownloadManger.getmInstance().getDrawableAsync(5, "qzone_detail_panel_forword_browser", null);
            case 1921:
                return ResDownloadManger.getmInstance().getDrawableAsync(5, "qzone_detail_panel_none", null);
            case 1922:
                return ResDownloadManger.getmInstance().getDrawableAsync(5, "qzone_detail_panel_view", null);
            default:
                return null;
        }
    }

    @Override // com.qzone.adapter.feedcomponent.o
    public int getInteger(int i3) {
        return FeedGlobalEnv.getContext().getResources().getInteger(i3 != 820 ? 0 : R.integer.f167152e);
    }

    @Override // com.qzone.adapter.feedcomponent.o
    public String getString(int i3) {
        int i16;
        switch (i3) {
            case 1093:
                i16 = R.string.b58;
                break;
            case 1094:
                i16 = R.string.b4x;
                break;
            case 1095:
                i16 = R.string.b4y;
                break;
            case 1096:
                i16 = R.string.b5a;
                break;
            case 1097:
                i16 = R.string.b5b;
                break;
            case 1098:
                i16 = R.string.gaf;
                break;
            case 1099:
                i16 = R.string.gag;
                break;
            case 1100:
                i16 = R.string.f173029gl0;
                break;
            case 1101:
                i16 = R.string.f173030gl1;
                break;
            case 1102:
                i16 = R.string.f173031gl2;
                break;
            case 1103:
                i16 = R.string.gkw;
                break;
            case 1104:
                i16 = R.string.gkx;
                break;
            case 1105:
                i16 = R.string.gl8;
                break;
            case 1106:
                i16 = R.string.geu;
                break;
            case 1107:
                i16 = R.string.gfw;
                break;
            case 1108:
                i16 = R.string.gfp;
                break;
            case 1109:
                return "https://qzonestyle.gtimg.cn/gdt/display/res/qzone/qzone_video_recommend_pop_adv_close_button.png";
            case 1110:
                i16 = R.string.gew;
                break;
            case 1111:
                i16 = R.string.gev;
                break;
            default:
                i16 = 0;
                break;
        }
        return FeedGlobalEnv.getContext().getResources().getString(i16);
    }

    @Override // com.qzone.adapter.feedcomponent.o
    public CharSequence getText(int i3) {
        return FeedGlobalEnv.getContext().getResources().getText(i3 != 1366 ? i3 != 1367 ? 0 : R.string.b56 : R.string.b57);
    }
}
