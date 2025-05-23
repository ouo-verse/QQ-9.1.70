package com.tencent.mobileqq.data;

import com.tencent.ark.ark;
import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForArkFlashChat extends ChatMessage {
    public ArkFlashChatContainerWrapper arkContainer;
    public ArkFlashChatMessage ark_app_message;
    public WeakReference<AutoStartProgressBar> mSendingProgress;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        ArkFlashChatMessage arkFlashChatMessage = new ArkFlashChatMessage();
        byte[] bArr = this.msgData;
        if (bArr != null) {
            arkFlashChatMessage.fromBytes(bArr);
        }
        this.ark_app_message = arkFlashChatMessage;
        if (this.f203106msg == null) {
            this.f203106msg = arkFlashChatMessage.getSummery();
        }
    }

    public String getSummery() {
        ArkFlashChatMessage arkFlashChatMessage = this.ark_app_message;
        if (arkFlashChatMessage != null) {
            return arkFlashChatMessage.getSummery();
        }
        return HardCodeUtil.qqStr(R.string.o2a);
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public boolean isSupportReply() {
        return true;
    }

    public void playAnim() {
        try {
            if (QLog.isColorLevel()) {
                QLog.d("FlashChat", 2, "testMyStopAnimLogic play " + this.ark_app_message.getMeta(this.uniseq, true));
            }
            ArkFlashChatMessage arkFlashChatMessage = this.ark_app_message;
            ark.arkNotify(arkFlashChatMessage.appName, "", "UpdateAnimContent", arkFlashChatMessage.getMeta(this.uniseq, true), ark.ARKMETADATA_JSON);
        } catch (UnsatisfiedLinkError unused) {
            if (QLog.isColorLevel()) {
                QLog.d("FlashChat", 2, "arkNotify failed, .so not loaded");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        parse();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        byte[] bArr;
        ArkFlashChatMessage arkFlashChatMessage = this.ark_app_message;
        if (arkFlashChatMessage != null) {
            bArr = arkFlashChatMessage.toBytes();
        } else {
            bArr = null;
        }
        this.f203106msg = getSummery();
        this.msgData = bArr;
    }

    public void setParsed() {
        synchronized (this) {
            this.mIsParsed = true;
        }
    }

    public void setupSendLoading(AutoStartProgressBar autoStartProgressBar) {
        WeakReference<AutoStartProgressBar> weakReference = new WeakReference<>(autoStartProgressBar);
        this.mSendingProgress = weakReference;
        weakReference.get().setTag(this);
    }

    public void stopAnim() {
        try {
            if (QLog.isColorLevel()) {
                QLog.d("FlashChat", 2, "testMyStopAnimLogic stopAnim" + this.ark_app_message.getMeta(this.uniseq, false));
            }
            ArkFlashChatMessage arkFlashChatMessage = this.ark_app_message;
            ark.arkNotify(arkFlashChatMessage.appName, "", "UpdateAnimContent", arkFlashChatMessage.getMeta(this.uniseq, false), ark.ARKMETADATA_JSON);
        } catch (UnsatisfiedLinkError unused) {
            if (QLog.isColorLevel()) {
                QLog.d("FlashChat", 2, "arkNotify failed, .so not loaded");
            }
        }
    }
}
