package com.tencent.mobileqq.filemanager.fileviewer;

import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FileBrowserMiniAIOHelper implements Observer {

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f208162d;

    /* renamed from: e, reason: collision with root package name */
    private String f208163e;

    /* renamed from: f, reason: collision with root package name */
    private View f208164f;

    public FileBrowserMiniAIOHelper(QQAppInterface qQAppInterface, String str) {
        this.f208162d = qQAppInterface;
        this.f208163e = str;
    }

    public void b(View view) {
        this.f208164f = view;
    }

    public void c() {
        if (this.f208162d.getMessageFacade() != null) {
            this.f208162d.getMessageFacade().deleteObserver(this);
        }
    }

    public void d() {
        View view = this.f208164f;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void e() {
        if (this.f208162d.getMessageFacade() != null) {
            this.f208162d.getMessageFacade().deleteObserver(this);
        }
    }

    public void f() {
        if (this.f208162d.getMessageFacade() != null) {
            this.f208162d.getMessageFacade().addObserver(this);
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (obj != null && (obj instanceof MessageRecord) && (obj instanceof ChatMessage)) {
            MessageRecord messageRecord = (MessageRecord) obj;
            if (QLog.isColorLevel()) {
                QLog.d("FileBrowserMiniAIOHelper<QFile>", 2, "recv: msgseq[" + messageRecord.msgseq + "] uin[" + messageRecord.frienduin + "]");
                if (messageRecord.frienduin.equals(this.f208163e)) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.FileBrowserMiniAIOHelper.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (FileBrowserMiniAIOHelper.this.f208164f != null) {
                                FileBrowserMiniAIOHelper.this.f208164f.setVisibility(0);
                            }
                        }
                    });
                }
            }
        }
    }
}
