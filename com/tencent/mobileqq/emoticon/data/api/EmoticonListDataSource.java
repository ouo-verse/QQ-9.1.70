package com.tencent.mobileqq.emoticon.data.api;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticon.data.EmoticonDataSource;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/emoticon/data/api/EmoticonListDataSource;", "Lcom/tencent/mobileqq/emoticon/data/EmoticonDataSource;", "emoticons", "", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "(Ljava/util/List;)V", "getEmoticons", "()Ljava/util/List;", "listener", "Lcom/tencent/mobileqq/emoticon/data/EmoticonDataSource$DataSourceListener;", Const.BUNDLE_KEY_REQUEST, "", "setListener", "qqemoticondata-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class EmoticonListDataSource implements EmoticonDataSource {
    static IPatchRedirector $redirector_;

    @NotNull
    private final List<EmoticonInfo> emoticons;

    @Nullable
    private EmoticonDataSource.DataSourceListener listener;

    /* JADX WARN: Multi-variable type inference failed */
    public EmoticonListDataSource(@NotNull List<? extends EmoticonInfo> emoticons) {
        Intrinsics.checkNotNullParameter(emoticons, "emoticons");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) emoticons);
        } else {
            this.emoticons = emoticons;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void request$lambda$0(EmoticonListDataSource this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EmoticonDataSource.DataSourceListener dataSourceListener = this$0.listener;
        if (dataSourceListener != null) {
            dataSourceListener.onGetEmoticons(false, this$0.emoticons);
        }
    }

    @NotNull
    public final List<EmoticonInfo> getEmoticons() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.emoticons;
    }

    @Override // com.tencent.mobileqq.emoticon.data.EmoticonDataSource
    public void request() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.emoticon.data.api.a
                @Override // java.lang.Runnable
                public final void run() {
                    EmoticonListDataSource.request$lambda$0(EmoticonListDataSource.this);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.emoticon.data.EmoticonDataSource
    public void setListener(@Nullable EmoticonDataSource.DataSourceListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) listener);
        } else {
            this.listener = listener;
        }
    }
}
