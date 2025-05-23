package com.tencent.mobileqq.troop.troopcard.ui;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.eu;

/* compiled from: P */
/* loaded from: classes19.dex */
public class m {
    static IPatchRedirector $redirector_;

    public static void a(int i3, Object obj) {
        String str;
        try {
            switch (i3) {
                case 1:
                    ReportController.o(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X8009E37", 2, 0, "", "", "", "");
                    return;
                case 2:
                    ReportController.o(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A57F", 2, 0, "", "", "", "");
                    return;
                case 3:
                    Object[] objArr = (Object[]) obj;
                    String str2 = (String) objArr[0];
                    if (((Boolean) objArr[1]).booleanValue()) {
                        str = "0";
                    } else if (((Boolean) objArr[2]).booleanValue()) {
                        str = "1";
                    } else {
                        str = "2";
                    }
                    ReportController.o(null, "dc00899", "Grp_set_new", "", "grpData_admin", "clk_image", 0, 0, str2, "0", str, "");
                    return;
                case 4:
                    ReportController.o(null, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "nonmber_Clk_head", 0, 0, (String) obj, "", "", "");
                    return;
                case 5:
                    Object[] objArr2 = (Object[]) obj;
                    ReportController.o(null, "dc00898", "", "", "0X800A526", "0X800A526", ((Integer) objArr2[0]).intValue(), 0, (String) objArr2[1], "", "", "");
                    return;
                case 6:
                    ReportController.o(null, "P_CliOper", "Grp_discuss", "", "discuss_AIO", "Clk_grpaio", 0, 0, (String) obj, "", "", "");
                    return;
                case 7:
                    ReportController.o(null, "P_CliOper", "Grp_payjoin", "", "join_grp", "Clk_data", 0, 0, (String) obj, "", "", "");
                    return;
                case 8:
                    ReportController.o(null, "CliOper", "", "", "0x80084B4", "0x80084B4", 0, 0, "", "", "", "");
                    return;
                case 9:
                    ReportController.o(null, "CliOper", "", "", "0x80084B5", "0x80084B5", 0, 0, "", "", "", "");
                    return;
                case 10:
                    Object[] objArr3 = (Object[]) obj;
                    ReportController.o(null, "dc00898", "", "", "0X800A527", "0X800A527", ((Integer) objArr3[0]).intValue(), 0, (String) objArr3[1], "", "", "");
                    return;
                case 11:
                    ReportController.o(null, "dc00898", "", "", "kuolie", "0X80097DC", 0, 0, "", "", "", "");
                    return;
                case 12:
                    ReportController.o(null, "dc00898", "", "", "0X80092D7", "0X80092D7", 0, 0, "", "", "", "");
                    return;
                case 13:
                    Object[] objArr4 = (Object[]) obj;
                    eu.g("Grp_set_new", "grpData_visitor", "clk_join", 0, 0, (String) objArr4[0], (String) objArr4[1]);
                    return;
                case 14:
                    ReportController.o(null, "dc00898", "", "", "0X8007246", "0X8007246", 0, 0, "", "", "", "");
                    return;
                case 15:
                    Object[] objArr5 = (Object[]) obj;
                    ReportController.o(null, "dc00899", "Grp_recom", "", "set_page", "page_exp", 0, 0, (String) objArr5[0], "", (String) objArr5[1], "");
                    return;
                case 16:
                    Object[] objArr6 = (Object[]) obj;
                    ReportController.o(null, "dc00899", "Grp_recom", "", "set_page", "recom_exp", 0, 0, (String) objArr6[0], "", (String) objArr6[1], "");
                    return;
                case 17:
                    Object[] objArr7 = (Object[]) obj;
                    ReportController.o(null, "P_CliOper", "Grp_set", "", "Grp_Visdata", "Clk_data", 0, 0, (String) objArr7[0], (String) objArr7[1], "", "");
                    return;
                case 18:
                    ReportController.o(null, "P_CliOper", "Grp_discuss", "", "discuss_AIO", "Clk_objgrp", 0, 0, (String) obj, "", "", "");
                    return;
                case 19:
                    Object[] objArr8 = (Object[]) obj;
                    ReportController.o(null, "dc00898", "", "", "0X800A525", "0X800A525", ((Integer) objArr8[0]).intValue(), 0, (String) objArr8[1], "", "", "");
                    return;
                case 20:
                    ReportController.o(null, "P_CliOper", "Grp_rank", "", "Grp_data", "Clk_grprank", 0, 0, (String) obj, "", "", "");
                    return;
                case 21:
                    ReportController.o(null, "CliOper", "", "", "Grp", "Dismiss_grp_OK", 0, 0, "", "", "", "");
                    return;
                default:
                    return;
            }
        } catch (ClassCastException e16) {
            e16.printStackTrace();
        }
    }
}
