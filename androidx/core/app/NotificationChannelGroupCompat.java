package androidx.core.app;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class NotificationChannelGroupCompat {
    private boolean mBlocked;
    private List<NotificationChannelCompat> mChannels;
    String mDescription;
    final String mId;
    CharSequence mName;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Builder {
        final NotificationChannelGroupCompat mGroup;

        public Builder(@NonNull String str) {
            this.mGroup = new NotificationChannelGroupCompat(str);
        }

        @NonNull
        public NotificationChannelGroupCompat build() {
            return this.mGroup;
        }

        @NonNull
        public Builder setDescription(@Nullable String str) {
            this.mGroup.mDescription = str;
            return this;
        }

        @NonNull
        public Builder setName(@Nullable CharSequence charSequence) {
            this.mGroup.mName = charSequence;
            return this;
        }
    }

    NotificationChannelGroupCompat(@NonNull String str) {
        this.mChannels = Collections.emptyList();
        this.mId = (String) Preconditions.checkNotNull(str);
    }

    @RequiresApi(26)
    private List<NotificationChannelCompat> getChannelsCompat(List<NotificationChannel> list) {
        String group;
        ArrayList arrayList = new ArrayList();
        for (NotificationChannel notificationChannel : list) {
            String str = this.mId;
            group = notificationChannel.getGroup();
            if (str.equals(group)) {
                arrayList.add(new NotificationChannelCompat(notificationChannel));
            }
        }
        return arrayList;
    }

    @NonNull
    public List<NotificationChannelCompat> getChannels() {
        return this.mChannels;
    }

    @Nullable
    public String getDescription() {
        return this.mDescription;
    }

    @NonNull
    public String getId() {
        return this.mId;
    }

    @Nullable
    public CharSequence getName() {
        return this.mName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NotificationChannelGroup getNotificationChannelGroup() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 26) {
            return null;
        }
        NotificationChannelGroup notificationChannelGroup = new NotificationChannelGroup(this.mId, this.mName);
        if (i3 >= 28) {
            notificationChannelGroup.setDescription(this.mDescription);
        }
        return notificationChannelGroup;
    }

    public boolean isBlocked() {
        return this.mBlocked;
    }

    @NonNull
    public Builder toBuilder() {
        return new Builder(this.mId).setName(this.mName).setDescription(this.mDescription);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RequiresApi(28)
    public NotificationChannelGroupCompat(@NonNull NotificationChannelGroup notificationChannelGroup) {
        this(notificationChannelGroup, Collections.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    @RequiresApi(26)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public NotificationChannelGroupCompat(@NonNull NotificationChannelGroup notificationChannelGroup, @NonNull List<NotificationChannel> list) {
        this(r0);
        String id5;
        CharSequence name;
        boolean isBlocked;
        List<NotificationChannel> channels;
        String description;
        id5 = notificationChannelGroup.getId();
        name = notificationChannelGroup.getName();
        this.mName = name;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 28) {
            description = notificationChannelGroup.getDescription();
            this.mDescription = description;
        }
        if (i3 >= 28) {
            isBlocked = notificationChannelGroup.isBlocked();
            this.mBlocked = isBlocked;
            channels = notificationChannelGroup.getChannels();
            this.mChannels = getChannelsCompat(channels);
            return;
        }
        this.mChannels = getChannelsCompat(list);
    }
}
