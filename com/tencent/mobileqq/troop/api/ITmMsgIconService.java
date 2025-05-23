package com.tencent.mobileqq.troop.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.Nullable;
import tencent.im.msg.nt_im_msg_general_flags_body$MsgIcon;

/* compiled from: P */
@Service(process = {""})
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001:\u0001\rJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u001c\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH&J\u001c\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH&J\u0014\u0010\f\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/troop/api/ITmMsgIconService;", "Lmqq/app/api/IRuntimeService;", "", "memberUin", "Lcom/tencent/mobileqq/troop/api/ITmMsgIconService$a;", "callback", "", "getMemberIconData", "Ltencent/im/msg/nt_im_msg_general_flags_body$MsgIcon;", "icon", "setMemberIconData", "cacheMemberIconData", "getMemberIconDataFromCache", "a", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public interface ITmMsgIconService extends IRuntimeService {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/troop/api/ITmMsgIconService$a;", "", "Ltencent/im/msg/nt_im_msg_general_flags_body$MsgIcon;", "memberMsgIcon", "", "a", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public interface a {
        void a(@Nullable nt_im_msg_general_flags_body$MsgIcon memberMsgIcon);
    }

    void cacheMemberIconData(@Nullable String memberUin, @Nullable nt_im_msg_general_flags_body$MsgIcon icon);

    void getMemberIconData(@Nullable String memberUin, @Nullable a callback);

    @Nullable
    nt_im_msg_general_flags_body$MsgIcon getMemberIconDataFromCache(@Nullable String memberUin);

    void setMemberIconData(@Nullable String memberUin, @Nullable nt_im_msg_general_flags_body$MsgIcon icon);
}
