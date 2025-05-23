package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes.dex */
public class NotificationCompat {
    public static final int FLAG_HIGH_PRIORITY = 128;
    private static final NotificationCompatImpl IMPL;
    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_LOW = -1;
    public static final int PRIORITY_MAX = 2;
    public static final int PRIORITY_MIN = -2;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Action {
        public PendingIntent actionIntent;
        public int icon;
        public CharSequence title;

        public Action(int i3, CharSequence charSequence, PendingIntent pendingIntent) {
            this.icon = i3;
            this.title = charSequence;
            this.actionIntent = pendingIntent;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class BigPictureStyle extends Style {
        Bitmap mBigLargeIcon;
        boolean mBigLargeIconSet;
        Bitmap mPicture;

        public BigPictureStyle() {
        }

        public BigPictureStyle bigLargeIcon(Bitmap bitmap) {
            this.mBigLargeIcon = bitmap;
            this.mBigLargeIconSet = true;
            return this;
        }

        public BigPictureStyle bigPicture(Bitmap bitmap) {
            this.mPicture = bitmap;
            return this;
        }

        public BigPictureStyle setBigContentTitle(CharSequence charSequence) {
            this.mBigContentTitle = charSequence;
            return this;
        }

        public BigPictureStyle setSummaryText(CharSequence charSequence) {
            this.mSummaryText = charSequence;
            this.mSummaryTextSet = true;
            return this;
        }

        public BigPictureStyle(Builder builder) {
            setBuilder(builder);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class BigTextStyle extends Style {
        CharSequence mBigText;

        public BigTextStyle() {
        }

        public BigTextStyle bigText(CharSequence charSequence) {
            this.mBigText = charSequence;
            return this;
        }

        public BigTextStyle setBigContentTitle(CharSequence charSequence) {
            this.mBigContentTitle = charSequence;
            return this;
        }

        public BigTextStyle setSummaryText(CharSequence charSequence) {
            this.mSummaryText = charSequence;
            this.mSummaryTextSet = true;
            return this;
        }

        public BigTextStyle(Builder builder) {
            setBuilder(builder);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Builder {
        ArrayList<Action> mActions = new ArrayList<>();
        String mChannelId;
        CharSequence mContentInfo;
        PendingIntent mContentIntent;
        CharSequence mContentText;
        CharSequence mContentTitle;
        Context mContext;
        PendingIntent mFullScreenIntent;
        Bitmap mLargeIcon;
        Notification mNotification;
        int mNumber;
        int mPriority;
        int mProgress;
        boolean mProgressIndeterminate;
        int mProgressMax;
        Style mStyle;
        CharSequence mSubText;
        RemoteViews mTickerView;
        boolean mUseChronometer;

        public Builder(Context context) {
            Notification notification = new Notification();
            this.mNotification = notification;
            this.mContext = context;
            notification.when = System.currentTimeMillis();
            this.mNotification.audioStreamType = -1;
            this.mPriority = 0;
        }

        private void setFlag(int i3, boolean z16) {
            if (z16) {
                Notification notification = this.mNotification;
                notification.flags = i3 | notification.flags;
            } else {
                Notification notification2 = this.mNotification;
                notification2.flags = (~i3) & notification2.flags;
            }
        }

        public Builder addAction(int i3, CharSequence charSequence, PendingIntent pendingIntent) {
            this.mActions.add(new Action(i3, charSequence, pendingIntent));
            return this;
        }

        public Notification build() {
            return NotificationCompat.IMPL.build(this);
        }

        @Deprecated
        public Notification getNotification() {
            return NotificationCompat.IMPL.build(this);
        }

        public Builder setAutoCancel(boolean z16) {
            setFlag(16, z16);
            return this;
        }

        public Builder setChannelId(String str) {
            this.mChannelId = str;
            return this;
        }

        public Builder setContent(RemoteViews remoteViews) {
            this.mNotification.contentView = remoteViews;
            return this;
        }

        public Builder setContentInfo(CharSequence charSequence) {
            this.mContentInfo = charSequence;
            return this;
        }

        public Builder setContentIntent(PendingIntent pendingIntent) {
            this.mContentIntent = pendingIntent;
            return this;
        }

        public Builder setContentText(CharSequence charSequence) {
            this.mContentText = charSequence;
            return this;
        }

        public Builder setContentTitle(CharSequence charSequence) {
            this.mContentTitle = charSequence;
            return this;
        }

        public Builder setDefaults(int i3) {
            Notification notification = this.mNotification;
            notification.defaults = i3;
            if ((i3 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        public Builder setDeleteIntent(PendingIntent pendingIntent) {
            this.mNotification.deleteIntent = pendingIntent;
            return this;
        }

        public Builder setFullScreenIntent(PendingIntent pendingIntent, boolean z16) {
            this.mFullScreenIntent = pendingIntent;
            setFlag(128, z16);
            return this;
        }

        public Builder setLargeIcon(Bitmap bitmap) {
            this.mLargeIcon = bitmap;
            return this;
        }

        public Builder setLights(int i3, int i16, int i17) {
            int i18;
            Notification notification = this.mNotification;
            notification.ledARGB = i3;
            notification.ledOnMS = i16;
            notification.ledOffMS = i17;
            if (i16 != 0 && i17 != 0) {
                i18 = 1;
            } else {
                i18 = 0;
            }
            notification.flags = i18 | (notification.flags & (-2));
            return this;
        }

        public Builder setNumber(int i3) {
            this.mNumber = i3;
            return this;
        }

        public Builder setOngoing(boolean z16) {
            setFlag(2, z16);
            return this;
        }

        public Builder setOnlyAlertOnce(boolean z16) {
            setFlag(8, z16);
            return this;
        }

        public Builder setPriority(int i3) {
            this.mPriority = i3;
            return this;
        }

        public Builder setProgress(int i3, int i16, boolean z16) {
            this.mProgressMax = i3;
            this.mProgress = i16;
            this.mProgressIndeterminate = z16;
            return this;
        }

        public Builder setSmallIcon(int i3) {
            this.mNotification.icon = i3;
            return this;
        }

        public Builder setSound(Uri uri) {
            Notification notification = this.mNotification;
            notification.sound = uri;
            notification.audioStreamType = -1;
            return this;
        }

        public Builder setStyle(Style style) {
            if (this.mStyle != style) {
                this.mStyle = style;
                if (style != null) {
                    style.setBuilder(this);
                }
            }
            return this;
        }

        public Builder setSubText(CharSequence charSequence) {
            this.mSubText = charSequence;
            return this;
        }

        public Builder setTicker(CharSequence charSequence) {
            this.mNotification.tickerText = charSequence;
            return this;
        }

        public Builder setUsesChronometer(boolean z16) {
            this.mUseChronometer = z16;
            return this;
        }

        public Builder setVibrate(long[] jArr) {
            this.mNotification.vibrate = jArr;
            return this;
        }

        public Builder setWhen(long j3) {
            this.mNotification.when = j3;
            return this;
        }

        public Builder setSmallIcon(int i3, int i16) {
            Notification notification = this.mNotification;
            notification.icon = i3;
            notification.iconLevel = i16;
            return this;
        }

        public Builder setTicker(CharSequence charSequence, RemoteViews remoteViews) {
            this.mNotification.tickerText = charSequence;
            this.mTickerView = remoteViews;
            return this;
        }

        public Builder setSound(Uri uri, int i3) {
            Notification notification = this.mNotification;
            notification.sound = uri;
            notification.audioStreamType = i3;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface NotificationCompatImpl {
        Notification build(Builder builder);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class NotificationCompatImplHoneycomb implements NotificationCompatImpl {
        NotificationCompatImplHoneycomb() {
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public Notification build(Builder builder) {
            return NotificationCompatHoneycomb.add(builder.mContext, builder.mNotification, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.mTickerView, builder.mNumber, builder.mContentIntent, builder.mFullScreenIntent, builder.mLargeIcon);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class NotificationCompatImplIceCreamSandwich implements NotificationCompatImpl {
        NotificationCompatImplIceCreamSandwich() {
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public Notification build(Builder builder) {
            return NotificationCompatIceCreamSandwich.add(builder.mContext, builder.mNotification, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.mTickerView, builder.mNumber, builder.mContentIntent, builder.mFullScreenIntent, builder.mLargeIcon, builder.mProgressMax, builder.mProgress, builder.mProgressIndeterminate);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class NotificationCompatImplJellybean implements NotificationCompatImpl {
        NotificationCompatImplJellybean() {
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public Notification build(Builder builder) {
            NotificationCompatJellybean notificationCompatJellybean = new NotificationCompatJellybean(builder.mContext, builder.mNotification, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.mTickerView, builder.mNumber, builder.mContentIntent, builder.mFullScreenIntent, builder.mLargeIcon, builder.mProgressMax, builder.mProgress, builder.mProgressIndeterminate, builder.mUseChronometer, builder.mPriority, builder.mSubText);
            Iterator<Action> it = builder.mActions.iterator();
            while (it.hasNext()) {
                Action next = it.next();
                notificationCompatJellybean.addAction(next.icon, next.title, next.actionIntent);
            }
            Style style = builder.mStyle;
            if (style != null) {
                if (style instanceof BigTextStyle) {
                    BigTextStyle bigTextStyle = (BigTextStyle) style;
                    notificationCompatJellybean.addBigTextStyle(bigTextStyle.mBigContentTitle, bigTextStyle.mSummaryTextSet, bigTextStyle.mSummaryText, bigTextStyle.mBigText);
                } else if (style instanceof InboxStyle) {
                    InboxStyle inboxStyle = (InboxStyle) style;
                    notificationCompatJellybean.addInboxStyle(inboxStyle.mBigContentTitle, inboxStyle.mSummaryTextSet, inboxStyle.mSummaryText, inboxStyle.mTexts);
                } else if (style instanceof BigPictureStyle) {
                    BigPictureStyle bigPictureStyle = (BigPictureStyle) style;
                    notificationCompatJellybean.addBigPictureStyle(bigPictureStyle.mBigContentTitle, bigPictureStyle.mSummaryTextSet, bigPictureStyle.mSummaryText, bigPictureStyle.mPicture, bigPictureStyle.mBigLargeIcon, bigPictureStyle.mBigLargeIconSet);
                }
            }
            return notificationCompatJellybean.build();
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class NotificationCompatImplOreo implements NotificationCompatImpl {
        NotificationCompatImplOreo() {
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public Notification build(Builder builder) {
            NotificationCompatOreo notificationCompatOreo = new NotificationCompatOreo(builder.mContext, builder.mNotification, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.mTickerView, builder.mNumber, builder.mContentIntent, builder.mFullScreenIntent, builder.mLargeIcon, builder.mProgressMax, builder.mProgress, builder.mProgressIndeterminate, builder.mUseChronometer, builder.mPriority, builder.mSubText, builder.mChannelId);
            Iterator<Action> it = builder.mActions.iterator();
            while (it.hasNext()) {
                Action next = it.next();
                notificationCompatOreo.addAction(next.icon, next.title, next.actionIntent);
            }
            Style style = builder.mStyle;
            if (style != null) {
                if (style instanceof BigTextStyle) {
                    BigTextStyle bigTextStyle = (BigTextStyle) style;
                    notificationCompatOreo.addBigTextStyle(bigTextStyle.mBigContentTitle, bigTextStyle.mSummaryTextSet, bigTextStyle.mSummaryText, bigTextStyle.mBigText);
                } else if (style instanceof InboxStyle) {
                    InboxStyle inboxStyle = (InboxStyle) style;
                    notificationCompatOreo.addInboxStyle(inboxStyle.mBigContentTitle, inboxStyle.mSummaryTextSet, inboxStyle.mSummaryText, inboxStyle.mTexts);
                } else if (style instanceof BigPictureStyle) {
                    BigPictureStyle bigPictureStyle = (BigPictureStyle) style;
                    notificationCompatOreo.addBigPictureStyle(bigPictureStyle.mBigContentTitle, bigPictureStyle.mSummaryTextSet, bigPictureStyle.mSummaryText, bigPictureStyle.mPicture, bigPictureStyle.mBigLargeIcon, bigPictureStyle.mBigLargeIconSet);
                }
            }
            return notificationCompatOreo.build();
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class Style {
        CharSequence mBigContentTitle;
        Builder mBuilder;
        CharSequence mSummaryText;
        boolean mSummaryTextSet = false;

        public Notification build() {
            Builder builder = this.mBuilder;
            if (builder != null) {
                return builder.build();
            }
            return null;
        }

        public void setBuilder(Builder builder) {
            if (this.mBuilder != builder) {
                this.mBuilder = builder;
                if (builder != null) {
                    builder.setStyle(this);
                }
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 26) {
            IMPL = new NotificationCompatImplOreo();
        } else {
            IMPL = new NotificationCompatImplJellybean();
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class InboxStyle extends Style {
        ArrayList<CharSequence> mTexts = new ArrayList<>();

        public InboxStyle() {
        }

        public InboxStyle addLine(CharSequence charSequence) {
            this.mTexts.add(charSequence);
            return this;
        }

        public InboxStyle setBigContentTitle(CharSequence charSequence) {
            this.mBigContentTitle = charSequence;
            return this;
        }

        public InboxStyle setSummaryText(CharSequence charSequence) {
            this.mSummaryText = charSequence;
            this.mSummaryTextSet = true;
            return this;
        }

        public InboxStyle(Builder builder) {
            setBuilder(builder);
        }
    }
}
