package com.tencent.biz.qqcircle.debug.controller;

import android.view.View;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/biz/qqcircle/debug/controller/ce;", "Lcom/tencent/qcircle/cooperation/config/debug/a;", "", "e", "Landroid/view/View;", "view", "", NodeProps.ON_CLICK, "", "b", "d", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class ce extends com.tencent.qcircle.cooperation.config.debug.a {
    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public int b() {
        return 0;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    @NotNull
    public String d() {
        return "QFSCommentFavEmotionController";
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    @NotNull
    public String e() {
        return "\u91cd\u7f6e\u8bc4\u8bba\u8868\u60c5\u7ea2\u70b9\u8ba1\u6570";
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public void onClick(@Nullable View view) {
        uq3.k.a().m("sp_key_comment_fav_tab_red_point_left_count", 3);
        uq3.k.a().m("sp_key_comment_emotion_red_point_left_count", 3);
        uq3.k.b().m("sp_key_emoji_last_selected_emoji_tab", 7);
        uq3.k.a().j(HostDataTransUtils.getAccount() + "_qfs_key_profile_qq_group_red_dot", false);
        uq3.k.a().j(HostDataTransUtils.getAccount() + "_qfs_key_profile_face_follow_red_dot", false);
        uq3.k.a().j(HostDataTransUtils.getAccount() + "_qfs_key_profile_face_follow_first_use", true);
        QQToastUtil.showQQToast(0, "\u7ea2\u70b9\u8ba1\u6570\u5df2\u91cd\u7f6e");
    }
}
