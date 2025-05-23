package androidx.core.app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;

/* compiled from: P */
/* loaded from: classes.dex */
public class NotificationChannelCompat {
    public static final String DEFAULT_CHANNEL_ID = "miscellaneous";
    private static final int DEFAULT_LIGHT_COLOR = 0;
    private static final boolean DEFAULT_SHOW_BADGE = true;
    AudioAttributes mAudioAttributes;
    private boolean mBypassDnd;
    private boolean mCanBubble;
    String mConversationId;
    String mDescription;
    String mGroupId;

    @NonNull
    final String mId;
    int mImportance;
    private boolean mImportantConversation;
    int mLightColor;
    boolean mLights;
    private int mLockscreenVisibility;
    CharSequence mName;
    String mParentId;
    boolean mShowBadge;
    Uri mSound;
    boolean mVibrationEnabled;
    long[] mVibrationPattern;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Builder {
        private final NotificationChannelCompat mChannel;

        public Builder(@NonNull String str, int i3) {
            this.mChannel = new NotificationChannelCompat(str, i3);
        }

        @NonNull
        public NotificationChannelCompat build() {
            return this.mChannel;
        }

        @NonNull
        public Builder setConversationId(@NonNull String str, @NonNull String str2) {
            if (Build.VERSION.SDK_INT >= 30) {
                NotificationChannelCompat notificationChannelCompat = this.mChannel;
                notificationChannelCompat.mParentId = str;
                notificationChannelCompat.mConversationId = str2;
            }
            return this;
        }

        @NonNull
        public Builder setDescription(@Nullable String str) {
            this.mChannel.mDescription = str;
            return this;
        }

        @NonNull
        public Builder setGroup(@Nullable String str) {
            this.mChannel.mGroupId = str;
            return this;
        }

        @NonNull
        public Builder setImportance(int i3) {
            this.mChannel.mImportance = i3;
            return this;
        }

        @NonNull
        public Builder setLightColor(int i3) {
            this.mChannel.mLightColor = i3;
            return this;
        }

        @NonNull
        public Builder setLightsEnabled(boolean z16) {
            this.mChannel.mLights = z16;
            return this;
        }

        @NonNull
        public Builder setName(@Nullable CharSequence charSequence) {
            this.mChannel.mName = charSequence;
            return this;
        }

        @NonNull
        public Builder setShowBadge(boolean z16) {
            this.mChannel.mShowBadge = z16;
            return this;
        }

        @NonNull
        public Builder setSound(@Nullable Uri uri, @Nullable AudioAttributes audioAttributes) {
            NotificationChannelCompat notificationChannelCompat = this.mChannel;
            notificationChannelCompat.mSound = uri;
            notificationChannelCompat.mAudioAttributes = audioAttributes;
            return this;
        }

        @NonNull
        public Builder setVibrationEnabled(boolean z16) {
            this.mChannel.mVibrationEnabled = z16;
            return this;
        }

        @NonNull
        public Builder setVibrationPattern(@Nullable long[] jArr) {
            boolean z16;
            NotificationChannelCompat notificationChannelCompat = this.mChannel;
            if (jArr != null && jArr.length > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            notificationChannelCompat.mVibrationEnabled = z16;
            notificationChannelCompat.mVibrationPattern = jArr;
            return this;
        }
    }

    NotificationChannelCompat(@NonNull String str, int i3) {
        this.mShowBadge = true;
        this.mSound = Settings.System.DEFAULT_NOTIFICATION_URI;
        this.mLightColor = 0;
        this.mId = (String) Preconditions.checkNotNull(str);
        this.mImportance = i3;
        this.mAudioAttributes = Notification.AUDIO_ATTRIBUTES_DEFAULT;
    }

    public boolean canBubble() {
        return this.mCanBubble;
    }

    public boolean canBypassDnd() {
        return this.mBypassDnd;
    }

    public boolean canShowBadge() {
        return this.mShowBadge;
    }

    @Nullable
    public AudioAttributes getAudioAttributes() {
        return this.mAudioAttributes;
    }

    @Nullable
    public String getConversationId() {
        return this.mConversationId;
    }

    @Nullable
    public String getDescription() {
        return this.mDescription;
    }

    @Nullable
    public String getGroup() {
        return this.mGroupId;
    }

    @NonNull
    public String getId() {
        return this.mId;
    }

    public int getImportance() {
        return this.mImportance;
    }

    public int getLightColor() {
        return this.mLightColor;
    }

    public int getLockscreenVisibility() {
        return this.mLockscreenVisibility;
    }

    @Nullable
    public CharSequence getName() {
        return this.mName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NotificationChannel getNotificationChannel() {
        String str;
        String str2;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 26) {
            return null;
        }
        NotificationChannel notificationChannel = new NotificationChannel(this.mId, this.mName, this.mImportance);
        notificationChannel.setDescription(this.mDescription);
        notificationChannel.setGroup(this.mGroupId);
        notificationChannel.setShowBadge(this.mShowBadge);
        notificationChannel.setSound(this.mSound, this.mAudioAttributes);
        notificationChannel.enableLights(this.mLights);
        notificationChannel.setLightColor(this.mLightColor);
        notificationChannel.setVibrationPattern(this.mVibrationPattern);
        notificationChannel.enableVibration(this.mVibrationEnabled);
        if (i3 >= 30 && (str = this.mParentId) != null && (str2 = this.mConversationId) != null) {
            notificationChannel.setConversationId(str, str2);
        }
        return notificationChannel;
    }

    @Nullable
    public String getParentChannelId() {
        return this.mParentId;
    }

    @Nullable
    public Uri getSound() {
        return this.mSound;
    }

    @Nullable
    public long[] getVibrationPattern() {
        return this.mVibrationPattern;
    }

    public boolean isImportantConversation() {
        return this.mImportantConversation;
    }

    public boolean shouldShowLights() {
        return this.mLights;
    }

    public boolean shouldVibrate() {
        return this.mVibrationEnabled;
    }

    @NonNull
    public Builder toBuilder() {
        return new Builder(this.mId, this.mImportance).setName(this.mName).setDescription(this.mDescription).setGroup(this.mGroupId).setShowBadge(this.mShowBadge).setSound(this.mSound, this.mAudioAttributes).setLightsEnabled(this.mLights).setLightColor(this.mLightColor).setVibrationEnabled(this.mVibrationEnabled).setVibrationPattern(this.mVibrationPattern).setConversationId(this.mParentId, this.mConversationId);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    @RequiresApi(26)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public NotificationChannelCompat(@NonNull NotificationChannel notificationChannel) {
        this(r0, r1);
        String id5;
        int importance;
        CharSequence name;
        String description;
        String group;
        boolean canShowBadge;
        Uri sound;
        AudioAttributes audioAttributes;
        boolean shouldShowLights;
        int lightColor;
        boolean shouldVibrate;
        long[] vibrationPattern;
        boolean canBypassDnd;
        int lockscreenVisibility;
        boolean isImportantConversation;
        boolean canBubble;
        String parentChannelId;
        String conversationId;
        id5 = notificationChannel.getId();
        importance = notificationChannel.getImportance();
        name = notificationChannel.getName();
        this.mName = name;
        description = notificationChannel.getDescription();
        this.mDescription = description;
        group = notificationChannel.getGroup();
        this.mGroupId = group;
        canShowBadge = notificationChannel.canShowBadge();
        this.mShowBadge = canShowBadge;
        sound = notificationChannel.getSound();
        this.mSound = sound;
        audioAttributes = notificationChannel.getAudioAttributes();
        this.mAudioAttributes = audioAttributes;
        shouldShowLights = notificationChannel.shouldShowLights();
        this.mLights = shouldShowLights;
        lightColor = notificationChannel.getLightColor();
        this.mLightColor = lightColor;
        shouldVibrate = notificationChannel.shouldVibrate();
        this.mVibrationEnabled = shouldVibrate;
        vibrationPattern = notificationChannel.getVibrationPattern();
        this.mVibrationPattern = vibrationPattern;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 30) {
            parentChannelId = notificationChannel.getParentChannelId();
            this.mParentId = parentChannelId;
            conversationId = notificationChannel.getConversationId();
            this.mConversationId = conversationId;
        }
        canBypassDnd = notificationChannel.canBypassDnd();
        this.mBypassDnd = canBypassDnd;
        lockscreenVisibility = notificationChannel.getLockscreenVisibility();
        this.mLockscreenVisibility = lockscreenVisibility;
        if (i3 >= 29) {
            canBubble = notificationChannel.canBubble();
            this.mCanBubble = canBubble;
        }
        if (i3 >= 30) {
            isImportantConversation = notificationChannel.isImportantConversation();
            this.mImportantConversation = isImportantConversation;
        }
    }
}
