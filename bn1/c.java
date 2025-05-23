package bn1;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.feed.nativepublish.utils.GuildFeedPublishUtils;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel;

/* compiled from: P */
/* loaded from: classes13.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public String f28687a;

    /* renamed from: b, reason: collision with root package name */
    public int f28688b;

    /* renamed from: c, reason: collision with root package name */
    public String f28689c;

    /* renamed from: d, reason: collision with root package name */
    public Boolean f28690d;

    public c(String str, int i3, String str2, Boolean bool) {
        this.f28687a = str;
        this.f28688b = i3;
        this.f28689c = str2;
        this.f28690d = bool;
    }

    public static c a(IGProChannel iGProChannel) {
        boolean z16 = false;
        if (GuildFeedPublishUtils.f222315a.w(String.valueOf(iGProChannel.getGuildId()))) {
            String valueOf = String.valueOf(iGProChannel.getChannelId());
            String channelName = iGProChannel.getChannelName();
            if (iGProChannel.getVisibleType() == 1 && iGProChannel.getSpeakPermission() == 1) {
                z16 = true;
            }
            return new c(valueOf, 1, channelName, Boolean.valueOf(z16));
        }
        String valueOf2 = String.valueOf(iGProChannel.getChannelId());
        String channelName2 = iGProChannel.getChannelName();
        if (iGProChannel.getMySpeakPermissionType() == 2) {
            z16 = true;
        }
        return new c(valueOf2, 1, channelName2, Boolean.valueOf(z16));
    }

    @NonNull
    public String toString() {
        return "[GuildSelectPartInfo] channelId = " + this.f28687a + ", partType = " + this.f28688b + ", partName = " + this.f28689c + ", canSpeak = " + this.f28690d;
    }
}
