package com.tencent.mobileqq.emoticon.data;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/emoticon/data/EmoticonDataSource;", "", Const.BUNDLE_KEY_REQUEST, "", "setListener", "listener", "Lcom/tencent/mobileqq/emoticon/data/EmoticonDataSource$DataSourceListener;", "DataSourceListener", "QQSystemEmoji-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public interface EmoticonDataSource {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/emoticon/data/EmoticonDataSource$DataSourceListener;", "", "onGetEmoticons", "", "more", "", "emoticons", "", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "QQSystemEmoji-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public interface DataSourceListener {
        void onGetEmoticons(boolean more, @NotNull List<? extends EmoticonInfo> emoticons);
    }

    void request();

    void setListener(@Nullable DataSourceListener listener);
}
