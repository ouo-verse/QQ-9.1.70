package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.ArraySet;
import androidx.core.app.NotificationCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class NotificationCompatBuilder implements NotificationBuilderWithBuilderAccessor {
    private RemoteViews mBigContentView;
    private final Notification.Builder mBuilder;
    private final NotificationCompat.Builder mBuilderCompat;
    private RemoteViews mContentView;
    private final Context mContext;
    private int mGroupAlertBehavior;
    private RemoteViews mHeadsUpContentView;
    private final List<Bundle> mActionExtrasList = new ArrayList();
    private final Bundle mExtras = new Bundle();

    /* JADX INFO: Access modifiers changed from: package-private */
    public NotificationCompatBuilder(NotificationCompat.Builder builder) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        List list;
        Notification.Builder badgeIconType;
        Notification.Builder settingsText;
        Notification.Builder shortcutId;
        Notification.Builder timeoutAfter;
        this.mBuilderCompat = builder;
        this.mContext = builder.mContext;
        if (Build.VERSION.SDK_INT >= 26) {
            this.mBuilder = new Notification.Builder(builder.mContext, builder.mChannelId);
        } else {
            this.mBuilder = new Notification.Builder(builder.mContext);
        }
        Notification notification = builder.mNotification;
        Notification.Builder lights = this.mBuilder.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, builder.mTickerView).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
        if ((notification.flags & 2) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Notification.Builder ongoing = lights.setOngoing(z16);
        if ((notification.flags & 8) != 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        Notification.Builder onlyAlertOnce = ongoing.setOnlyAlertOnce(z17);
        if ((notification.flags & 16) != 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        Notification.Builder deleteIntent = onlyAlertOnce.setAutoCancel(z18).setDefaults(notification.defaults).setContentTitle(builder.mContentTitle).setContentText(builder.mContentText).setContentInfo(builder.mContentInfo).setContentIntent(builder.mContentIntent).setDeleteIntent(notification.deleteIntent);
        PendingIntent pendingIntent = builder.mFullScreenIntent;
        if ((notification.flags & 128) != 0) {
            z19 = true;
        } else {
            z19 = false;
        }
        deleteIntent.setFullScreenIntent(pendingIntent, z19).setLargeIcon(builder.mLargeIcon).setNumber(builder.mNumber).setProgress(builder.mProgressMax, builder.mProgress, builder.mProgressIndeterminate);
        this.mBuilder.setSubText(builder.mSubText).setUsesChronometer(builder.mUseChronometer).setPriority(builder.mPriority);
        Iterator<NotificationCompat.Action> it = builder.mActions.iterator();
        while (it.hasNext()) {
            addAction(it.next());
        }
        Bundle bundle = builder.mExtras;
        if (bundle != null) {
            this.mExtras.putAll(bundle);
        }
        int i3 = Build.VERSION.SDK_INT;
        this.mContentView = builder.mContentView;
        this.mBigContentView = builder.mBigContentView;
        this.mBuilder.setShowWhen(builder.mShowWhen);
        this.mBuilder.setLocalOnly(builder.mLocalOnly).setGroup(builder.mGroupKey).setGroupSummary(builder.mGroupSummary).setSortKey(builder.mSortKey);
        this.mGroupAlertBehavior = builder.mGroupAlertBehavior;
        this.mBuilder.setCategory(builder.mCategory).setColor(builder.mColor).setVisibility(builder.mVisibility).setPublicVersion(builder.mPublicVersion).setSound(notification.sound, notification.audioAttributes);
        if (i3 < 28) {
            list = combineLists(getPeople(builder.mPersonList), builder.mPeople);
        } else {
            list = builder.mPeople;
        }
        if (list != null && !list.isEmpty()) {
            Iterator it5 = list.iterator();
            while (it5.hasNext()) {
                this.mBuilder.addPerson((String) it5.next());
            }
        }
        this.mHeadsUpContentView = builder.mHeadsUpContentView;
        if (builder.mInvisibleActions.size() > 0) {
            Bundle bundle2 = builder.getExtras().getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            for (int i16 = 0; i16 < builder.mInvisibleActions.size(); i16++) {
                bundle4.putBundle(Integer.toString(i16), NotificationCompatJellybean.getBundleForAction(builder.mInvisibleActions.get(i16)));
            }
            bundle2.putBundle("invisible_actions", bundle4);
            bundle3.putBundle("invisible_actions", bundle4);
            builder.getExtras().putBundle("android.car.EXTENSIONS", bundle2);
            this.mExtras.putBundle("android.car.EXTENSIONS", bundle3);
        }
        int i17 = Build.VERSION.SDK_INT;
        Icon icon = builder.mSmallIcon;
        if (icon != null) {
            this.mBuilder.setSmallIcon(icon);
        }
        if (i17 >= 24) {
            this.mBuilder.setExtras(builder.mExtras).setRemoteInputHistory(builder.mRemoteInputHistory);
            RemoteViews remoteViews = builder.mContentView;
            if (remoteViews != null) {
                this.mBuilder.setCustomContentView(remoteViews);
            }
            RemoteViews remoteViews2 = builder.mBigContentView;
            if (remoteViews2 != null) {
                this.mBuilder.setCustomBigContentView(remoteViews2);
            }
            RemoteViews remoteViews3 = builder.mHeadsUpContentView;
            if (remoteViews3 != null) {
                this.mBuilder.setCustomHeadsUpContentView(remoteViews3);
            }
        }
        if (i17 >= 26) {
            badgeIconType = this.mBuilder.setBadgeIconType(builder.mBadgeIcon);
            settingsText = badgeIconType.setSettingsText(builder.mSettingsText);
            shortcutId = settingsText.setShortcutId(builder.mShortcutId);
            timeoutAfter = shortcutId.setTimeoutAfter(builder.mTimeout);
            timeoutAfter.setGroupAlertBehavior(builder.mGroupAlertBehavior);
            if (builder.mColorizedSet) {
                this.mBuilder.setColorized(builder.mColorized);
            }
            if (!TextUtils.isEmpty(builder.mChannelId)) {
                this.mBuilder.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i17 >= 28) {
            Iterator<Person> it6 = builder.mPersonList.iterator();
            while (it6.hasNext()) {
                this.mBuilder.addPerson(it6.next().toAndroidPerson());
            }
        }
        int i18 = Build.VERSION.SDK_INT;
        if (i18 >= 29) {
            this.mBuilder.setAllowSystemGeneratedContextualActions(builder.mAllowSystemGeneratedContextualActions);
            this.mBuilder.setBubbleMetadata(NotificationCompat.BubbleMetadata.toPlatform(builder.mBubbleMetadata));
            LocusIdCompat locusIdCompat = builder.mLocusId;
            if (locusIdCompat != null) {
                this.mBuilder.setLocusId(locusIdCompat.toLocusId());
            }
        }
        if (builder.mSilent) {
            if (this.mBuilderCompat.mGroupSummary) {
                this.mGroupAlertBehavior = 2;
            } else {
                this.mGroupAlertBehavior = 1;
            }
            this.mBuilder.setVibrate(null);
            this.mBuilder.setSound(null);
            int i19 = notification.defaults & (-2) & (-3);
            notification.defaults = i19;
            this.mBuilder.setDefaults(i19);
            if (i18 >= 26) {
                if (TextUtils.isEmpty(this.mBuilderCompat.mGroupKey)) {
                    this.mBuilder.setGroup(NotificationCompat.GROUP_KEY_SILENT);
                }
                this.mBuilder.setGroupAlertBehavior(this.mGroupAlertBehavior);
            }
        }
    }

    private void addAction(NotificationCompat.Action action) {
        Icon icon;
        Bundle bundle;
        IconCompat iconCompat = action.getIconCompat();
        if (iconCompat != null) {
            icon = iconCompat.toIcon();
        } else {
            icon = null;
        }
        Notification.Action.Builder builder = new Notification.Action.Builder(icon, action.getTitle(), action.getActionIntent());
        if (action.getRemoteInputs() != null) {
            for (android.app.RemoteInput remoteInput : RemoteInput.fromCompat(action.getRemoteInputs())) {
                builder.addRemoteInput(remoteInput);
            }
        }
        if (action.getExtras() != null) {
            bundle = new Bundle(action.getExtras());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 24) {
            builder.setAllowGeneratedReplies(action.getAllowGeneratedReplies());
        }
        bundle.putInt("android.support.action.semanticAction", action.getSemanticAction());
        if (i3 >= 28) {
            builder.setSemanticAction(action.getSemanticAction());
        }
        if (i3 >= 29) {
            builder.setContextual(action.isContextual());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", action.getShowsUserInterface());
        builder.addExtras(bundle);
        this.mBuilder.addAction(builder.build());
    }

    @Nullable
    private static List<String> combineLists(@Nullable List<String> list, @Nullable List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        ArraySet arraySet = new ArraySet(list.size() + list2.size());
        arraySet.addAll(list);
        arraySet.addAll(list2);
        return new ArrayList(arraySet);
    }

    @Nullable
    private static List<String> getPeople(@Nullable List<Person> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<Person> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().resolveToLegacyUri());
        }
        return arrayList;
    }

    private void removeSoundAndVibration(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults = notification.defaults & (-2) & (-3);
    }

    public Notification build() {
        RemoteViews remoteViews;
        Bundle extras;
        RemoteViews makeHeadsUpContentView;
        RemoteViews makeBigContentView;
        NotificationCompat.Style style = this.mBuilderCompat.mStyle;
        if (style != null) {
            style.apply(this);
        }
        if (style != null) {
            remoteViews = style.makeContentView(this);
        } else {
            remoteViews = null;
        }
        Notification buildInternal = buildInternal();
        if (remoteViews != null) {
            buildInternal.contentView = remoteViews;
        } else {
            RemoteViews remoteViews2 = this.mBuilderCompat.mContentView;
            if (remoteViews2 != null) {
                buildInternal.contentView = remoteViews2;
            }
        }
        if (style != null && (makeBigContentView = style.makeBigContentView(this)) != null) {
            buildInternal.bigContentView = makeBigContentView;
        }
        if (style != null && (makeHeadsUpContentView = this.mBuilderCompat.mStyle.makeHeadsUpContentView(this)) != null) {
            buildInternal.headsUpContentView = makeHeadsUpContentView;
        }
        if (style != null && (extras = NotificationCompat.getExtras(buildInternal)) != null) {
            style.addCompatExtras(extras);
        }
        return buildInternal;
    }

    protected Notification buildInternal() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26) {
            return this.mBuilder.build();
        }
        if (i3 >= 24) {
            Notification build = this.mBuilder.build();
            if (this.mGroupAlertBehavior != 0) {
                if (build.getGroup() != null && (build.flags & 512) != 0 && this.mGroupAlertBehavior == 2) {
                    removeSoundAndVibration(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.mGroupAlertBehavior == 1) {
                    removeSoundAndVibration(build);
                }
            }
            return build;
        }
        this.mBuilder.setExtras(this.mExtras);
        Notification build2 = this.mBuilder.build();
        RemoteViews remoteViews = this.mContentView;
        if (remoteViews != null) {
            build2.contentView = remoteViews;
        }
        RemoteViews remoteViews2 = this.mBigContentView;
        if (remoteViews2 != null) {
            build2.bigContentView = remoteViews2;
        }
        RemoteViews remoteViews3 = this.mHeadsUpContentView;
        if (remoteViews3 != null) {
            build2.headsUpContentView = remoteViews3;
        }
        if (this.mGroupAlertBehavior != 0) {
            if (build2.getGroup() != null && (build2.flags & 512) != 0 && this.mGroupAlertBehavior == 2) {
                removeSoundAndVibration(build2);
            }
            if (build2.getGroup() != null && (build2.flags & 512) == 0 && this.mGroupAlertBehavior == 1) {
                removeSoundAndVibration(build2);
            }
        }
        return build2;
    }

    @Override // androidx.core.app.NotificationBuilderWithBuilderAccessor
    public Notification.Builder getBuilder() {
        return this.mBuilder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context getContext() {
        return this.mContext;
    }
}
