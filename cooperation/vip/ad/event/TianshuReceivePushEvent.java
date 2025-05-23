package cooperation.vip.ad.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.qphone.base.BaseConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcooperation/vip/ad/event/TianshuReceivePushEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", BaseConstants.EXTRA_PUSHID, "", "jumpScheme", "", "(ILjava/lang/String;)V", "getJumpScheme", "()Ljava/lang/String;", "getPushId", "()I", "tianshu-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class TianshuReceivePushEvent extends SimpleBaseEvent {

    @Nullable
    private final String jumpScheme;
    private final int pushId;

    public TianshuReceivePushEvent(int i3, @Nullable String str) {
        this.pushId = i3;
        this.jumpScheme = str;
    }

    @Nullable
    public final String getJumpScheme() {
        return this.jumpScheme;
    }

    public final int getPushId() {
        return this.pushId;
    }
}
