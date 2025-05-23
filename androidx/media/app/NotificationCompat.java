package androidx.media.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.widget.RemoteViews;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes.dex */
public class NotificationCompat {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @RequiresApi(15)
    /* loaded from: classes.dex */
    public static class Api15Impl {
        Api15Impl() {
        }

        @DoNotInline
        static void setContentDescription(RemoteViews remoteViews, int i3, CharSequence charSequence) {
            remoteViews.setContentDescription(i3, charSequence);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @RequiresApi(21)
    /* loaded from: classes.dex */
    public static class Api21Impl {
        Api21Impl() {
        }

        @DoNotInline
        static Notification.MediaStyle createMediaStyle() {
            return new Notification.MediaStyle();
        }

        @DoNotInline
        static Notification.MediaStyle fillInMediaStyle(Notification.MediaStyle mediaStyle, int[] iArr, MediaSessionCompat.Token token) {
            if (iArr != null) {
                setShowActionsInCompactView(mediaStyle, iArr);
            }
            if (token != null) {
                setMediaSession(mediaStyle, (MediaSession.Token) token.getToken());
            }
            return mediaStyle;
        }

        @DoNotInline
        static void setMediaSession(Notification.MediaStyle mediaStyle, MediaSession.Token token) {
            mediaStyle.setMediaSession(token);
        }

        @DoNotInline
        static void setMediaStyle(Notification.Builder builder, Notification.MediaStyle mediaStyle) {
            builder.setStyle(mediaStyle);
        }

        @DoNotInline
        static void setShowActionsInCompactView(Notification.MediaStyle mediaStyle, int... iArr) {
            mediaStyle.setShowActionsInCompactView(iArr);
        }
    }

    /* compiled from: P */
    @RequiresApi(24)
    /* loaded from: classes.dex */
    private static class Api24Impl {
        Api24Impl() {
        }

        @DoNotInline
        static Notification.DecoratedMediaCustomViewStyle createDecoratedMediaCustomViewStyle() {
            return new Notification.DecoratedMediaCustomViewStyle();
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class DecoratedMediaCustomViewStyle extends MediaStyle {
        private void setBackgroundColor(RemoteViews remoteViews) {
            int color;
            if (this.mBuilder.getColor() != 0) {
                color = this.mBuilder.getColor();
            } else {
                color = this.mBuilder.mContext.getResources().getColor(R.color.f157387c82);
            }
            remoteViews.setInt(R.id.f88234wi, "setBackgroundColor", color);
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                Api21Impl.setMediaStyle(notificationBuilderWithBuilderAccessor.getBuilder(), Api21Impl.fillInMediaStyle(Api24Impl.createDecoratedMediaCustomViewStyle(), this.mActionsToShowInCompact, this.mToken));
            } else {
                super.apply(notificationBuilderWithBuilderAccessor);
            }
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle
        int getBigContentViewLayoutResource(int i3) {
            if (i3 <= 3) {
                return R.layout.fox;
            }
            return R.layout.fov;
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle
        int getContentViewLayoutResource() {
            if (this.mBuilder.getContentView() != null) {
                return R.layout.f168342fp2;
            }
            return super.getContentViewLayoutResource();
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            RemoteViews contentView;
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            if (this.mBuilder.getBigContentView() != null) {
                contentView = this.mBuilder.getBigContentView();
            } else {
                contentView = this.mBuilder.getContentView();
            }
            if (contentView == null) {
                return null;
            }
            RemoteViews generateBigContentView = generateBigContentView();
            buildIntoRemoteViews(generateBigContentView, contentView);
            setBackgroundColor(generateBigContentView);
            return generateBigContentView;
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            boolean z16;
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            boolean z17 = true;
            if (this.mBuilder.getContentView() != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 && this.mBuilder.getBigContentView() == null) {
                z17 = false;
            }
            if (!z17) {
                return null;
            }
            RemoteViews generateContentView = generateContentView();
            if (z16) {
                buildIntoRemoteViews(generateContentView, this.mBuilder.getContentView());
            }
            setBackgroundColor(generateContentView);
            return generateContentView;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            RemoteViews contentView;
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            if (this.mBuilder.getHeadsUpContentView() != null) {
                contentView = this.mBuilder.getHeadsUpContentView();
            } else {
                contentView = this.mBuilder.getContentView();
            }
            if (contentView == null) {
                return null;
            }
            RemoteViews generateBigContentView = generateBigContentView();
            buildIntoRemoteViews(generateBigContentView, contentView);
            setBackgroundColor(generateBigContentView);
            return generateBigContentView;
        }
    }

    NotificationCompat() {
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class MediaStyle extends NotificationCompat.Style {
        private static final int MAX_MEDIA_BUTTONS = 5;
        private static final int MAX_MEDIA_BUTTONS_IN_COMPACT = 3;
        int[] mActionsToShowInCompact = null;
        PendingIntent mCancelButtonIntent;
        boolean mShowCancelButton;
        MediaSessionCompat.Token mToken;

        public MediaStyle() {
        }

        private RemoteViews generateMediaActionButton(NotificationCompat.Action action) {
            boolean z16;
            if (action.getActionIntent() == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            RemoteViews remoteViews = new RemoteViews(this.mBuilder.mContext.getPackageName(), R.layout.fos);
            remoteViews.setImageViewResource(R.id.s8y, action.getIcon());
            if (!z16) {
                remoteViews.setOnClickPendingIntent(R.id.s8y, action.getActionIntent());
            }
            Api15Impl.setContentDescription(remoteViews, R.id.s8y, action.getTitle());
            return remoteViews;
        }

        public static MediaSessionCompat.Token getMediaSession(Notification notification) {
            Parcelable parcelable;
            Bundle extras = androidx.core.app.NotificationCompat.getExtras(notification);
            if (extras != null && (parcelable = extras.getParcelable(androidx.core.app.NotificationCompat.EXTRA_MEDIA_SESSION)) != null) {
                return MediaSessionCompat.Token.fromToken(parcelable);
            }
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Api21Impl.setMediaStyle(notificationBuilderWithBuilderAccessor.getBuilder(), Api21Impl.fillInMediaStyle(Api21Impl.createMediaStyle(), this.mActionsToShowInCompact, this.mToken));
        }

        RemoteViews generateBigContentView() {
            int min = Math.min(this.mBuilder.mActions.size(), 5);
            RemoteViews applyStandardTemplate = applyStandardTemplate(false, getBigContentViewLayoutResource(min), false);
            applyStandardTemplate.removeAllViews(R.id.yzj);
            if (min > 0) {
                for (int i3 = 0; i3 < min; i3++) {
                    applyStandardTemplate.addView(R.id.yzj, generateMediaActionButton(this.mBuilder.mActions.get(i3)));
                }
            }
            if (this.mShowCancelButton) {
                applyStandardTemplate.setViewVisibility(R.id.tlg, 0);
                applyStandardTemplate.setInt(R.id.tlg, "setAlpha", this.mBuilder.mContext.getResources().getInteger(R.integer.f167144ao));
                applyStandardTemplate.setOnClickPendingIntent(R.id.tlg, this.mCancelButtonIntent);
            } else {
                applyStandardTemplate.setViewVisibility(R.id.tlg, 8);
            }
            return applyStandardTemplate;
        }

        RemoteViews generateContentView() {
            int min;
            RemoteViews applyStandardTemplate = applyStandardTemplate(false, getContentViewLayoutResource(), true);
            int size = this.mBuilder.mActions.size();
            int[] iArr = this.mActionsToShowInCompact;
            if (iArr == null) {
                min = 0;
            } else {
                min = Math.min(iArr.length, 3);
            }
            applyStandardTemplate.removeAllViews(R.id.yzj);
            if (min > 0) {
                for (int i3 = 0; i3 < min; i3++) {
                    if (i3 < size) {
                        applyStandardTemplate.addView(R.id.yzj, generateMediaActionButton(this.mBuilder.mActions.get(this.mActionsToShowInCompact[i3])));
                    } else {
                        throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", Integer.valueOf(i3), Integer.valueOf(size - 1)));
                    }
                }
            }
            if (this.mShowCancelButton) {
                applyStandardTemplate.setViewVisibility(R.id.uvh, 8);
                applyStandardTemplate.setViewVisibility(R.id.tlg, 0);
                applyStandardTemplate.setOnClickPendingIntent(R.id.tlg, this.mCancelButtonIntent);
                applyStandardTemplate.setInt(R.id.tlg, "setAlpha", this.mBuilder.mContext.getResources().getInteger(R.integer.f167144ao));
            } else {
                applyStandardTemplate.setViewVisibility(R.id.uvh, 0);
                applyStandardTemplate.setViewVisibility(R.id.tlg, 8);
            }
            return applyStandardTemplate;
        }

        int getBigContentViewLayoutResource(int i3) {
            if (i3 <= 3) {
                return R.layout.fow;
            }
            return R.layout.fou;
        }

        int getContentViewLayoutResource() {
            return R.layout.f168341fp1;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        public MediaStyle setCancelButtonIntent(PendingIntent pendingIntent) {
            this.mCancelButtonIntent = pendingIntent;
            return this;
        }

        public MediaStyle setMediaSession(MediaSessionCompat.Token token) {
            this.mToken = token;
            return this;
        }

        public MediaStyle setShowActionsInCompactView(int... iArr) {
            this.mActionsToShowInCompact = iArr;
            return this;
        }

        public MediaStyle(NotificationCompat.Builder builder) {
            setBuilder(builder);
        }

        public MediaStyle setShowCancelButton(boolean z16) {
            return this;
        }
    }
}
