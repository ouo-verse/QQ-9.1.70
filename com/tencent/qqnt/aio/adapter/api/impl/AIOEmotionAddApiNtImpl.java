package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOEmotionAddApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J'\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016\u00a2\u0006\u0002\u0010\rJ\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u000eH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOEmotionAddApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOEmotionAddApi;", "()V", "addEmotion", "", "context", "Landroid/content/Context;", "msgItem", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "path", "", "emojiPackageId", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Integer;)V", "", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class AIOEmotionAddApiNtImpl implements IAIOEmotionAddApi {
    static IPatchRedirector $redirector_;

    public AIOEmotionAddApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addEmotion$lambda$0(Context context) {
        Intrinsics.checkNotNullParameter(context, "$context");
        QQToast.makeText(context, "Add Expression is not supported", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addEmotion$lambda$1(Context context) {
        Intrinsics.checkNotNullParameter(context, "$context");
        QQToast.makeText(context, "Add multi emo is not supported", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addEmotion$lambda$2(Context context) {
        Intrinsics.checkNotNullParameter(context, "$context");
        QQToast.makeText(context, "Add Expression is not supported", 0).show();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOEmotionAddApi
    public void addEmotion(@NotNull final Context context, @NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) msgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqnt.aio.adapter.api.impl.h
            @Override // java.lang.Runnable
            public final void run() {
                AIOEmotionAddApiNtImpl.addEmotion$lambda$0(context);
            }
        });
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOEmotionAddApi
    public void addEmotion(@NotNull final Context context, @NotNull List<? extends AIOMsgItem> msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) msgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        QLog.d("AIOEmotionAdd", 2, "addEmotion: size:" + msgItem.size());
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqnt.aio.adapter.api.impl.j
            @Override // java.lang.Runnable
            public final void run() {
                AIOEmotionAddApiNtImpl.addEmotion$lambda$1(context);
            }
        });
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOEmotionAddApi
    public void addEmotion(@NotNull final Context context, @NotNull String path, @Nullable Integer emojiPackageId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, path, emojiPackageId);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, "path");
        QLog.d("AIOEmotionAdd", 2, "addEmotion: path:" + path + ", emojiPackageId:" + emojiPackageId);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqnt.aio.adapter.api.impl.i
            @Override // java.lang.Runnable
            public final void run() {
                AIOEmotionAddApiNtImpl.addEmotion$lambda$2(context);
            }
        });
    }
}
