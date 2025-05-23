package com.tencent.mobileqq.data;

import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForFoldMsgGrayTips extends ChatMessage {
    public static int PASSWD_REDBAG_FOLD_NICK_NUM = 20;
    public static int PASSWD_REDBAG_FOLD_STORE_NICK_LEN = 20;
    public static int PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT = 10;
    public static boolean PASSWD_REDBAG_MSG_INDEX_WITH_ID = true;
    public static boolean PASSWD_REDBAG_MSG_SWITCH_DEFAULT = true;
    public static boolean PASSWD_REDBAG_MSG_SWITCH_INDEX = true;
    private SpannableString clickSpan;
    public int foldMsgCount;
    public String redBagId;
    public String redBagIndex;
    public String redBagSenderNick;
    public String redBagSenderUin;
    public boolean isOpen = true;
    public LinkedHashSet<String> foldUinList = new LinkedHashSet<>();
    ArrayList<String> foldUinNickList = new ArrayList<>();

    public void init(QQAppInterface qQAppInterface, String str, long j3, LinkedHashSet<String> linkedHashSet, String str2, String str3) {
        this.redBagId = str2;
        this.redBagIndex = str3;
        String valueOf = String.valueOf(j3);
        this.redBagSenderUin = valueOf;
        this.redBagSenderNick = ac.J(qQAppInterface, str, valueOf);
        this.foldUinList = linkedHashSet;
        if (!linkedHashSet.isEmpty()) {
            Iterator<String> it = this.foldUinList.iterator();
            while (it.hasNext()) {
                String J = ac.J(qQAppInterface, str, it.next());
                if (J.length() > PASSWD_REDBAG_FOLD_STORE_NICK_LEN) {
                    J = J.substring(0, PASSWD_REDBAG_FOLD_STORE_NICK_LEN) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                }
                this.foldUinNickList.add(J);
            }
        }
    }

    public void update(QQAppInterface qQAppInterface, String str, LinkedHashSet<String> linkedHashSet, int i3, String str2, String str3) {
        this.foldMsgCount += i3;
        if (!TextUtils.isEmpty(str2)) {
            this.redBagId = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            this.redBagIndex = str3;
        }
        Iterator<String> it = linkedHashSet.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (this.foldUinList.add(next) && this.foldUinNickList.size() < PASSWD_REDBAG_FOLD_NICK_NUM) {
                String J = ac.J(qQAppInterface, str, next);
                if (J.length() > PASSWD_REDBAG_FOLD_STORE_NICK_LEN) {
                    J = J.substring(0, PASSWD_REDBAG_FOLD_STORE_NICK_LEN) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                }
                this.foldUinNickList.add(J);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
    }
}
