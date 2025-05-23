package com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils;

import android.text.Editable;
import com.tencent.guild.aio.input.at.utils.data.AtRoleInfo;
import com.tencent.guild.aio.input.at.utils.data.AtUserWithRoleInfo;
import com.tencent.mobileqq.guild.event.GuildAtEvent;
import com.tencent.mobileqq.guild.feed.widget.comment.CommentEditText;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes13.dex */
public class b {
    public static void a(CommentEditText commentEditText, GuildAtEvent guildAtEvent) {
        AtRoleInfo atRole;
        int selectionStart = commentEditText.getSelectionStart();
        Editable editableText = commentEditText.getEditableText();
        List<IGProUserInfo> list = guildAtEvent.userInfo;
        if (list != null && list.size() != 0) {
            if (selectionStart != 0) {
                int i3 = selectionStart - 1;
                if (editableText.toString().substring(i3, selectionStart).equals("@")) {
                    commentEditText.getText().delete(i3, selectionStart);
                    commentEditText.setSelection(i3);
                }
            }
            for (IGProUserInfo iGProUserInfo : guildAtEvent.userInfo) {
                if (iGProUserInfo != null) {
                    int i16 = 0;
                    if (iGProUserInfo instanceof AtUserWithRoleInfo) {
                        String c16 = c(iGProUserInfo);
                        AtUserWithRoleInfo atUserWithRoleInfo = (AtUserWithRoleInfo) iGProUserInfo;
                        int atType = atUserWithRoleInfo.getAtType();
                        String str = "@" + c16 + " ";
                        String tinyId = iGProUserInfo.getTinyId();
                        if (atType == 1) {
                            tinyId = "at_all";
                        } else if (atType == 64) {
                            tinyId = "at_online";
                        } else if (atType == 8) {
                            tinyId = "at_role";
                        }
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("@{uin:");
                        sb5.append(tinyId);
                        sb5.append(",nick:");
                        sb5.append(c16);
                        if (atType == 8 && (atRole = atUserWithRoleInfo.getAtRole()) != null) {
                            i16 = (int) atRole.getColor();
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("role_id", atRole.getRoleId());
                                jSONObject.put("name", atRole.getName());
                                jSONObject.put("color", atRole.getColor());
                                sb5.append(",role_info:");
                                sb5.append(jSONObject);
                            } catch (JSONException e16) {
                                e16.printStackTrace();
                            }
                        }
                        sb5.append("}");
                        commentEditText.c(str, sb5.toString(), i16);
                    } else {
                        String c17 = c(iGProUserInfo);
                        commentEditText.c("@" + c17 + " ", "@{uin:" + iGProUserInfo.getTinyId() + ",nick:" + c17 + "}", 0);
                    }
                }
            }
        }
    }

    public static String b(Editable editable) {
        CommentEditText.AtSpan[] atSpanArr = (CommentEditText.AtSpan[]) editable.getSpans(0, editable.length(), CommentEditText.AtSpan.class);
        StringBuilder sb5 = new StringBuilder();
        int i3 = 0;
        for (CommentEditText.AtSpan atSpan : atSpanArr) {
            int spanStart = editable.getSpanStart(atSpan);
            int spanEnd = editable.getSpanEnd(atSpan);
            if (i3 < spanStart) {
                sb5.append(editable.subSequence(i3, spanStart));
            }
            if (i3 < spanEnd) {
                i3 = spanEnd;
            }
        }
        if (i3 < editable.length()) {
            sb5.append(editable.subSequence(i3, editable.length()));
        }
        return sb5.toString();
    }

    private static String c(IGProUserInfo iGProUserInfo) {
        if (iGProUserInfo == null) {
            return "";
        }
        return iGProUserInfo.getName();
    }
}
