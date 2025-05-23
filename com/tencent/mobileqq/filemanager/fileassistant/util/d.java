package com.tencent.mobileqq.filemanager.fileassistant.util;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes12.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f208065a;

    /* renamed from: b, reason: collision with root package name */
    private String f208066b;

    public d(QQAppInterface qQAppInterface) {
        this.f208065a = qQAppInterface;
        if (TextUtils.isEmpty(this.f208066b)) {
            this.f208066b = AppConstants.DATALINE_NEW_VERSION_UIN;
        }
    }

    private void b(MessageForDLFile messageForDLFile) {
        ArrayList<MessageRecord> arrayList = new ArrayList<>();
        arrayList.add(messageForDLFile);
        this.f208065a.getMessageFacade().f(arrayList, this.f208065a.getCurrentAccountUin(), false, h.o());
    }

    private void c(MessageForText messageForText) {
        ArrayList<MessageRecord> arrayList = new ArrayList<>();
        arrayList.add(messageForText);
        this.f208065a.getMessageFacade().f(arrayList, this.f208065a.getCurrentAccountUin(), false, h.o());
    }

    public void a(MessageRecord messageRecord) {
        int i3 = messageRecord.msgtype;
        if (i3 == -1000) {
            c((MessageForText) messageRecord);
        } else if (i3 == -3017) {
            b((MessageForDLFile) messageRecord);
        }
    }
}
