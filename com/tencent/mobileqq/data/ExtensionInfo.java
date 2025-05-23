package com.tencent.mobileqq.data;

import android.content.ContentValues;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.persistence.defaultValue;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ExtensionInfo extends Entity {
    public static final int AUDIO_PANEL_TYPE_LS = 3;
    public static final int AUDIO_PANEL_TYPE_NONE = -1;
    public static final int AUDIO_PANEL_TYPE_PRESS_RECORDER = 1;
    public static final int AUDIO_PANEL_TYPE_RECORDER = 2;
    public static final int AUDIO_PANEL_TYPE_VOICE_CHANGER = 0;
    public static final long CHAT_FONT_ID_UNAVAILABLE = 0;
    public static final int CHAT_INPUT_TYPE_ADUIO = 2;
    public static final int CHAT_INPUT_TYPE_KEYBOARD = 1;
    public static final int CHAT_INPUT_TYPE_NONE = 0;
    public static final int CHAT_SHOW_AUDIO_PANEL = 1;
    public static final int CHAT_SHOW_NONE_PANEL = 0;
    public static final long EXTENSION_INFO_EXPIRATION = 86400000;
    public static final int FEED_TYPE_QSTORY = 2;
    public static final int FEED_TYPE_QZONE = 0;
    public static final int FEED_TYPE_WEISHI = 1;
    public static final long PENDANT_ID_UNAVAILABLE = 0;
    public static final String TAG = "ExtensionInfo";
    public static final int TYPE_FROM_CHAT = 1;
    public static final int TYPE_FROM_CONTACT = 0;

    @ConfigInject(configPath = "IMCore/src/main/resources/Inject_ExtensionBusinessData.yml", version = 1)
    private static ArrayList<Class<? extends bb1.b>> sBusinessDataInjectClasses;

    @notColumn
    public long chatAnimStartTime;
    public byte[] diyFontConfigBytes;
    public ConcurrentHashMap<Integer, String> diyFontConfigMap;
    public byte[] diyFontTimestampBytes;
    public ConcurrentHashMap<Integer, Integer> diyFontTimestampMap;
    public int faceId;
    public long faceIdUpdateTime;
    public String feedContent;
    public String feedPhotoUrl;
    public long feedTime;
    public int feedType;
    public int fontEffect;
    public long fontEffectLastUpdateTime;

    @notColumn
    public long frdshipAnimStartTime;
    public int friendRingId;
    public boolean hasRemindChat;
    public boolean hasRemindFrdship;
    public boolean hasRemindIntimate;
    public boolean hasRemindLoverChat;
    public boolean hasRemindPraise;
    public boolean hasRemindQzoneVisit;

    @notColumn
    public long intimateAnimStartTime;
    public boolean isAdded2C2C;

    @notColumn
    public boolean isDataChanged;
    public long lastPLNewsTimestamp;
    public long lastPullPLNewsTimestamp;
    public long lastQzoneVisitTime;

    @defaultValue(defaultInteger = 0)
    public long lastShareLbsMsgUniseq;
    public long lastUpdateTime;
    public long latestPLUpdateTimestamp;

    @notColumn
    public long loverChatAnimStartTime;
    public int magicFont;
    public String mutual_marks_store_json;
    public int pendantDiyId;
    public long pendantId;

    @notColumn
    public long praiseAnimStartTime;
    public int qzoneHotDays;

    @notColumn
    public long qzoneVisitAnimStartTime;
    public byte[] richBuffer;
    public long richTime;

    @defaultValue(defaultInteger = -1)
    public long topPositionTime;
    public long uVipFont;

    @unique
    public String uin;
    public int vipFontType;
    public long colorRingId = 0;
    public long commingRingId = 0;
    public long timestamp = 0;
    public boolean feedHasPhoto = false;
    public int chatInputType = 0;
    public int showC2CPanel = 1;
    public int pttChangeVoiceType = 0;
    public long openDoNotDisturbTime = 0;
    public long lastIceBreakCheckTs = 0;
    public long lastIceBreakChatTs = 0;
    public long makeFrdsTs = 0;
    public boolean isListenTogetherOpen = false;

    @defaultValue(defaultInteger = 0)
    public int isSharingLocation = 0;
    public long mTogetherBusinessFlag = 0;
    public boolean messageEnablePreview = true;
    public boolean messageEnableSound = true;
    public boolean messageEnableVibrate = true;

    @defaultValue(defaultInteger = 0)
    public int messageEnablePreviewNew = 0;

    @defaultValue(defaultInteger = 0)
    public int messageEnableSoundNew = 0;

    @defaultValue(defaultInteger = 0)
    public int messageEnableVibrateNew = 0;

    @defaultValue(defaultInteger = 0)
    public int hiddenChatSwitch = 0;
    public boolean isAioShortcutBarOpen = true;
    public int intimate_type = 0;
    public int intimate_level = 0;
    public int intimate_chatDays = 0;
    public long last_intimate_chatTime = 0;
    public boolean isExtinguish = false;
    public int friendshipLevel = 0;
    public int friendshipChatDays = 0;
    public long lastFriendshipTime = 0;
    public int chatHotLevel = 0;
    public int chatDays = 0;
    public long lastChatTime = 0;
    public int praiseHotLevel = 0;

    @Deprecated
    public int praiseDays = 0;
    public long lastpraiseTime = 0;
    public int loverChatLevel = 0;
    public int loverChatDays = 0;
    public long loverLastChatTime = 0;
    public int loverFlag = 0;
    public boolean loverTransFlag = false;
    public int qzoneVisitType = 0;
    public int bestIntimacyType = 0;

    @Deprecated
    public int bestIntimacyDays = 0;
    public int newBestIntimacyType = 0;
    public long localChatSendTs = 0;
    public long localChatRecTs = 0;
    public long lastHotReactiveReCheckInTs = 0;
    public int isGrayTipRemind = 0;
    public int isGrayTipMultiRemind = 0;

    @notColumn
    public long lastGrayPushTime = -1;

    @notColumn
    public long lastFriendshipGrayPushTime = -1;
    public int mutual_mark_version = 0;

    @notColumn
    private Map<String, bb1.b> businessDataCache = new HashMap();

    @defaultValue(defaultInteger = -1)
    public int audioPanelType = -1;

    static {
        ArrayList<Class<? extends bb1.b>> arrayList = new ArrayList<>();
        sBusinessDataInjectClasses = arrayList;
        arrayList.add(com.tencent.mobileqq.mutualmark.info.a.class);
        sBusinessDataInjectClasses.add(com.tencent.mobileqq.richstatus.c.class);
    }

    private void notifyBusinessDataPostRead() {
        ArrayList<Class<? extends bb1.b>> arrayList = sBusinessDataInjectClasses;
        if (arrayList == null) {
            QLog.e(TAG, 1, "sBusinessDataInjectClasses == null");
            return;
        }
        Iterator<Class<? extends bb1.b>> it = arrayList.iterator();
        while (it.hasNext()) {
            Class<? extends bb1.b> next = it.next();
            String name = next.getName();
            try {
                bb1.b newInstance = next.getConstructor(new Class[0]).newInstance(new Object[0]);
                this.businessDataCache.put(name, newInstance);
                newInstance.a(this);
            } catch (Exception e16) {
                QLog.d(TAG, 1, "notifyBusinessDataPostRead, <init> " + name, e16);
            }
        }
    }

    private void notifyBusinessDataPreWrite() {
        Iterator<bb1.b> it = this.businessDataCache.values().iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public ContentValues createContentValues() {
        return doCreateContentValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x042e, code lost:
    
        if (r11.isAccessible() != false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0430, code lost:
    
        r11.setAccessible(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0433, code lost:
    
        r4 = ((java.lang.Integer) r11.get(r22)).intValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x043d, code lost:
    
        if (r4 == r7) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x043f, code lost:
    
        com.tencent.qphone.base.util.QLog.i(com.tencent.mobileqq.data.ExtensionInfo.TAG, 1, "fieldHiddenChatSwitch=" + r4 + ",tmpHiddenChatSwitch=" + r7 + ",hiddenChatSwitch=" + r22.hiddenChatSwitch + ",uin=" + r22.uin, new java.lang.RuntimeException("stackInfo"));
        r5 = new java.util.HashMap<>();
        r5.put("detailEventUin", r22.uin);
        r11 = new java.lang.StringBuilder();
        r11.append(r4);
        r11.append("");
        r5.put("fieldHiddenChatSwitch", r11.toString());
        r5.put("tmpHiddenChatSwitch", r7 + "");
        r5.put("hiddenChatSwitch", r22.hiddenChatSwitch + "");
        r5.put("detailEventDes", "ExtensionInfo table doCreateContentValue, fieldHiddenChatSwitch != tmpHiddenChatSwitch \uff01\uff01\uff01");
        r5.put("stackInfo", com.tencent.qphone.base.util.QLog.getStackTraceString(new java.lang.RuntimeException("stackInfo")));
        com.tencent.mobileqq.statistics.StatisticCollector.getInstance(mqq.app.MobileQQ.sMobileQQ.getApplicationContext()).collectPerformance("", "hiddenChatSwitchDataError", true, 0L, 0L, r5, "", false);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ContentValues doCreateContentValue() {
        List<Field> validField = TableBuilder.getValidField(getClassForTable());
        int size = validField.size();
        ContentValues contentValues = new ContentValues(size);
        int i3 = this.hiddenChatSwitch;
        contentValues.put("audioPanelType", Integer.valueOf(this.audioPanelType));
        contentValues.put("bestIntimacyDays", Integer.valueOf(this.bestIntimacyDays));
        contentValues.put("bestIntimacyType", Integer.valueOf(this.bestIntimacyType));
        contentValues.put("chatDays", Integer.valueOf(this.chatDays));
        contentValues.put("chatHotLevel", Integer.valueOf(this.chatHotLevel));
        contentValues.put("chatInputType", Integer.valueOf(this.chatInputType));
        contentValues.put("colorRingId", Long.valueOf(this.colorRingId));
        contentValues.put("commingRingId", Long.valueOf(this.commingRingId));
        contentValues.put("diyFontConfigBytes", this.diyFontConfigBytes);
        contentValues.put("diyFontTimestampBytes", this.diyFontTimestampBytes);
        contentValues.put("faceId", Integer.valueOf(this.faceId));
        contentValues.put("faceIdUpdateTime", Long.valueOf(this.faceIdUpdateTime));
        contentValues.put("feedContent", this.feedContent);
        contentValues.put("feedHasPhoto", Boolean.valueOf(this.feedHasPhoto));
        contentValues.put("feedPhotoUrl", this.feedPhotoUrl);
        contentValues.put("feedTime", Long.valueOf(this.feedTime));
        contentValues.put("feedType", Integer.valueOf(this.feedType));
        contentValues.put("fontEffect", Integer.valueOf(this.fontEffect));
        contentValues.put("fontEffectLastUpdateTime", Long.valueOf(this.fontEffectLastUpdateTime));
        contentValues.put("friendRingId", Integer.valueOf(this.friendRingId));
        contentValues.put("friendshipChatDays", Integer.valueOf(this.friendshipChatDays));
        contentValues.put("friendshipLevel", Integer.valueOf(this.friendshipLevel));
        contentValues.put("hasRemindChat", Boolean.valueOf(this.hasRemindChat));
        contentValues.put("hasRemindFrdship", Boolean.valueOf(this.hasRemindFrdship));
        contentValues.put("hasRemindIntimate", Boolean.valueOf(this.hasRemindIntimate));
        contentValues.put("hasRemindLoverChat", Boolean.valueOf(this.hasRemindLoverChat));
        contentValues.put("hasRemindPraise", Boolean.valueOf(this.hasRemindPraise));
        contentValues.put("hasRemindQzoneVisit", Boolean.valueOf(this.hasRemindQzoneVisit));
        contentValues.put("hiddenChatSwitch", Integer.valueOf(this.hiddenChatSwitch));
        contentValues.put("intimate_chatDays", Integer.valueOf(this.intimate_chatDays));
        contentValues.put("intimate_level", Integer.valueOf(this.intimate_level));
        contentValues.put("intimate_type", Integer.valueOf(this.intimate_type));
        contentValues.put("isAdded2C2C", Boolean.valueOf(this.isAdded2C2C));
        contentValues.put("isAioShortcutBarOpen", Boolean.valueOf(this.isAioShortcutBarOpen));
        contentValues.put("isExtinguish", Boolean.valueOf(this.isExtinguish));
        contentValues.put("isGrayTipMultiRemind", Integer.valueOf(this.isGrayTipMultiRemind));
        contentValues.put("isGrayTipRemind", Integer.valueOf(this.isGrayTipRemind));
        contentValues.put("isListenTogetherOpen", Boolean.valueOf(this.isListenTogetherOpen));
        contentValues.put("isSharingLocation", Integer.valueOf(this.isSharingLocation));
        contentValues.put("lastChatTime", Long.valueOf(this.lastChatTime));
        contentValues.put("lastFriendshipTime", Long.valueOf(this.lastFriendshipTime));
        contentValues.put("lastHotReactiveReCheckInTs", Long.valueOf(this.lastHotReactiveReCheckInTs));
        contentValues.put("lastIceBreakChatTs", Long.valueOf(this.lastIceBreakChatTs));
        contentValues.put("lastIceBreakCheckTs", Long.valueOf(this.lastIceBreakCheckTs));
        contentValues.put("lastPLNewsTimestamp", Long.valueOf(this.lastPLNewsTimestamp));
        contentValues.put("lastPullPLNewsTimestamp", Long.valueOf(this.lastPullPLNewsTimestamp));
        contentValues.put("lastQzoneVisitTime", Long.valueOf(this.lastQzoneVisitTime));
        contentValues.put("lastShareLbsMsgUniseq", Long.valueOf(this.lastShareLbsMsgUniseq));
        contentValues.put(WadlProxyConsts.LAST_UPDATE_TIME, Long.valueOf(this.lastUpdateTime));
        contentValues.put("last_intimate_chatTime", Long.valueOf(this.last_intimate_chatTime));
        contentValues.put("lastpraiseTime", Long.valueOf(this.lastpraiseTime));
        contentValues.put("latestPLUpdateTimestamp", Long.valueOf(this.latestPLUpdateTimestamp));
        contentValues.put("localChatRecTs", Long.valueOf(this.localChatRecTs));
        contentValues.put("localChatSendTs", Long.valueOf(this.localChatSendTs));
        contentValues.put("loverChatDays", Integer.valueOf(this.loverChatDays));
        contentValues.put("loverChatLevel", Integer.valueOf(this.loverChatLevel));
        contentValues.put("loverFlag", Integer.valueOf(this.loverFlag));
        contentValues.put("loverLastChatTime", Long.valueOf(this.loverLastChatTime));
        contentValues.put("loverTransFlag", Boolean.valueOf(this.loverTransFlag));
        contentValues.put("mTogetherBusinessFlag", Long.valueOf(this.mTogetherBusinessFlag));
        contentValues.put("magicFont", Integer.valueOf(this.magicFont));
        contentValues.put("makeFrdsTs", Long.valueOf(this.makeFrdsTs));
        contentValues.put("messageEnablePreview", Boolean.valueOf(this.messageEnablePreview));
        contentValues.put("messageEnablePreviewNew", Integer.valueOf(this.messageEnablePreviewNew));
        contentValues.put("messageEnableSound", Boolean.valueOf(this.messageEnableSound));
        contentValues.put("messageEnableSoundNew", Integer.valueOf(this.messageEnableSoundNew));
        contentValues.put("messageEnableVibrate", Boolean.valueOf(this.messageEnableVibrate));
        contentValues.put("messageEnableVibrateNew", Integer.valueOf(this.messageEnableVibrateNew));
        contentValues.put("mutual_mark_version", Integer.valueOf(this.mutual_mark_version));
        contentValues.put("mutual_marks_store_json", this.mutual_marks_store_json);
        contentValues.put("newBestIntimacyType", Integer.valueOf(this.newBestIntimacyType));
        contentValues.put("openDoNotDisturbTime", Long.valueOf(this.openDoNotDisturbTime));
        contentValues.put("pendantDiyId", Integer.valueOf(this.pendantDiyId));
        contentValues.put("pendantId", Long.valueOf(this.pendantId));
        contentValues.put("praiseDays", Integer.valueOf(this.praiseDays));
        contentValues.put("praiseHotLevel", Integer.valueOf(this.praiseHotLevel));
        contentValues.put("pttChangeVoiceType", Integer.valueOf(this.pttChangeVoiceType));
        contentValues.put("qzoneHotDays", Integer.valueOf(this.qzoneHotDays));
        contentValues.put("qzoneVisitType", Integer.valueOf(this.qzoneVisitType));
        contentValues.put("richBuffer", this.richBuffer);
        contentValues.put("richTime", Long.valueOf(this.richTime));
        contentValues.put("showC2CPanel", Integer.valueOf(this.showC2CPanel));
        contentValues.put("timestamp", Long.valueOf(this.timestamp));
        contentValues.put("topPositionTime", Long.valueOf(this.topPositionTime));
        contentValues.put("uVipFont", Long.valueOf(this.uVipFont));
        contentValues.put("uin", this.uin);
        contentValues.put("vipFontType", Integer.valueOf(this.vipFontType));
        int i16 = 0;
        while (true) {
            if (i16 >= size) {
                break;
            }
            try {
                Field field = validField.get(i16);
                if (TextUtils.equals(field.getName(), "hiddenChatSwitch")) {
                    break;
                }
                i16++;
            } catch (IllegalAccessException e16) {
                QLog.i(TAG, 1, "ExtensionInfo table doCreateContentValue, getField error", e16);
            }
        }
        return contentValues;
    }

    public <T extends bb1.b> T getBusinessData(Class<T> cls, Object... objArr) {
        String name = cls.getName();
        if (!this.businessDataCache.containsKey(name)) {
            try {
                this.businessDataCache.put(name, cls.getConstructor(new Class[0]).newInstance(new Object[0]));
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 1, "getBusinessData, <init>" + name);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 1, "getBusinessData, <init>" + name, e16);
                }
            }
        }
        T t16 = (T) this.businessDataCache.get(name);
        if (t16 != null) {
            t16.c(this, objArr);
        }
        return t16;
    }

    public boolean isPendantExpired() {
        if (System.currentTimeMillis() - this.timestamp >= 86400000) {
            return true;
        }
        return false;
    }

    public boolean isPendantValid() {
        if (this.pendantId != 0) {
            return true;
        }
        return false;
    }

    public boolean isTogetherBusinessOpen(int i3) {
        if ((this.mTogetherBusinessFlag & i3) != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008a  */
    @Override // com.tencent.mobileqq.persistence.Entity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void postRead() {
        StringBuilder sb5;
        ObjectInputStream objectInputStream;
        ObjectInputStream objectInputStream2;
        StringBuilder sb6;
        ObjectInputStream objectInputStream3 = null;
        if (this.diyFontTimestampBytes != null) {
            try {
                objectInputStream2 = new ObjectInputStream(new ByteArrayInputStream(this.diyFontTimestampBytes));
            } catch (Exception e16) {
                e = e16;
                objectInputStream2 = null;
            } catch (Throwable th5) {
                th = th5;
                if (objectInputStream3 != null) {
                }
                throw th;
            }
            try {
                try {
                    this.diyFontTimestampMap = (ConcurrentHashMap) objectInputStream2.readObject();
                    try {
                        objectInputStream2.close();
                    } catch (Exception e17) {
                        e = e17;
                        sb6 = new StringBuilder();
                        sb6.append("Extensioninfo postRead error: ");
                        sb6.append(e.getMessage());
                        QLog.e(TAG, 1, sb6.toString());
                        if (this.diyFontConfigBytes != null) {
                        }
                        notifyBusinessDataPostRead();
                    }
                } catch (Throwable th6) {
                    th = th6;
                    objectInputStream3 = objectInputStream2;
                    if (objectInputStream3 != null) {
                        try {
                            objectInputStream3.close();
                        } catch (Exception e18) {
                            QLog.e(TAG, 1, "Extensioninfo postRead error: " + e18.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (Exception e19) {
                e = e19;
                QLog.e(TAG, 1, "Extensioninfo postRead error: " + e.getMessage());
                if (objectInputStream2 != null) {
                    try {
                        objectInputStream2.close();
                    } catch (Exception e26) {
                        e = e26;
                        sb6 = new StringBuilder();
                        sb6.append("Extensioninfo postRead error: ");
                        sb6.append(e.getMessage());
                        QLog.e(TAG, 1, sb6.toString());
                        if (this.diyFontConfigBytes != null) {
                        }
                        notifyBusinessDataPostRead();
                    }
                }
                if (this.diyFontConfigBytes != null) {
                }
                notifyBusinessDataPostRead();
            }
        }
        if (this.diyFontConfigBytes != null) {
            try {
                try {
                    objectInputStream = new ObjectInputStream(new ByteArrayInputStream(this.diyFontConfigBytes));
                    try {
                        this.diyFontConfigMap = (ConcurrentHashMap) objectInputStream.readObject();
                    } catch (Exception e27) {
                        e = e27;
                        objectInputStream3 = objectInputStream;
                        QLog.e(TAG, 1, "Extensioninfo postRead error: " + e.getMessage());
                        if (objectInputStream3 != null) {
                            try {
                                objectInputStream3.close();
                            } catch (Exception e28) {
                                e = e28;
                                sb5 = new StringBuilder();
                                sb5.append("Extensioninfo postRead error: ");
                                sb5.append(e.getMessage());
                                QLog.e(TAG, 1, sb5.toString());
                                notifyBusinessDataPostRead();
                            }
                        }
                        notifyBusinessDataPostRead();
                    } catch (Throwable th7) {
                        th = th7;
                        objectInputStream3 = objectInputStream;
                        if (objectInputStream3 != null) {
                            try {
                                objectInputStream3.close();
                            } catch (Exception e29) {
                                QLog.e(TAG, 1, "Extensioninfo postRead error: " + e29.getMessage());
                            }
                        }
                        throw th;
                    }
                } catch (Exception e36) {
                    e = e36;
                }
                try {
                    objectInputStream.close();
                } catch (Exception e37) {
                    e = e37;
                    sb5 = new StringBuilder();
                    sb5.append("Extensioninfo postRead error: ");
                    sb5.append(e.getMessage());
                    QLog.e(TAG, 1, sb5.toString());
                    notifyBusinessDataPostRead();
                }
            } catch (Throwable th8) {
                th = th8;
            }
        }
        notifyBusinessDataPostRead();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.mobileqq.persistence.Entity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void prewrite() {
        ObjectOutputStream objectOutputStream;
        StringBuilder sb5;
        Exception e16;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = null;
        try {
            ObjectOutputStream objectOutputStream3 = new ObjectOutputStream(byteArrayOutputStream);
            try {
                ConcurrentHashMap<Integer, Integer> concurrentHashMap = this.diyFontTimestampMap;
                if (concurrentHashMap != null) {
                    objectOutputStream3.writeObject(concurrentHashMap);
                    objectOutputStream3.flush();
                    this.diyFontTimestampBytes = byteArrayOutputStream.toByteArray();
                }
                if (this.diyFontConfigMap != null) {
                    ObjectOutputStream objectOutputStream4 = new ObjectOutputStream(byteArrayOutputStream2);
                    try {
                        objectOutputStream4.writeObject(this.diyFontConfigMap);
                        objectOutputStream4.flush();
                        this.diyFontConfigBytes = byteArrayOutputStream2.toByteArray();
                        objectOutputStream2 = objectOutputStream4;
                    } catch (Exception e17) {
                        objectOutputStream2 = objectOutputStream3;
                        objectOutputStream = objectOutputStream4;
                        e = e17;
                        try {
                            QLog.e(TAG, 1, "Extensioninfo prewrite error: " + e.getMessage());
                            if (objectOutputStream2 != null) {
                                try {
                                    objectOutputStream2.close();
                                } catch (Exception e18) {
                                    QLog.e(TAG, 1, "Extensioninfo prewrite error: " + e18.getMessage());
                                }
                            }
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.close();
                                } catch (Exception e19) {
                                    e16 = e19;
                                    sb5 = new StringBuilder();
                                    sb5.append("Extensioninfo prewrite error: ");
                                    sb5.append(e16.getMessage());
                                    QLog.e(TAG, 1, sb5.toString());
                                    notifyBusinessDataPreWrite();
                                }
                            }
                            notifyBusinessDataPreWrite();
                        } catch (Throwable th5) {
                            th = th5;
                            if (objectOutputStream2 != null) {
                                try {
                                    objectOutputStream2.close();
                                } catch (Exception e26) {
                                    QLog.e(TAG, 1, "Extensioninfo prewrite error: " + e26.getMessage());
                                }
                            }
                            if (objectOutputStream == null) {
                                try {
                                    objectOutputStream.close();
                                    throw th;
                                } catch (Exception e27) {
                                    QLog.e(TAG, 1, "Extensioninfo prewrite error: " + e27.getMessage());
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th6) {
                        objectOutputStream2 = objectOutputStream3;
                        objectOutputStream = objectOutputStream4;
                        th = th6;
                        if (objectOutputStream2 != null) {
                        }
                        if (objectOutputStream == null) {
                        }
                    }
                }
                try {
                    objectOutputStream3.close();
                } catch (Exception e28) {
                    QLog.e(TAG, 1, "Extensioninfo prewrite error: " + e28.getMessage());
                }
                if (objectOutputStream2 != null) {
                    try {
                        objectOutputStream2.close();
                    } catch (Exception e29) {
                        e16 = e29;
                        sb5 = new StringBuilder();
                        sb5.append("Extensioninfo prewrite error: ");
                        sb5.append(e16.getMessage());
                        QLog.e(TAG, 1, sb5.toString());
                        notifyBusinessDataPreWrite();
                    }
                }
            } catch (Exception e36) {
                e = e36;
                objectOutputStream = null;
                objectOutputStream2 = objectOutputStream3;
            } catch (Throwable th7) {
                th = th7;
                objectOutputStream = null;
                objectOutputStream2 = objectOutputStream3;
            }
        } catch (Exception e37) {
            e = e37;
            objectOutputStream = null;
        } catch (Throwable th8) {
            th = th8;
            objectOutputStream = null;
        }
        notifyBusinessDataPreWrite();
    }

    public <T extends bb1.b> void putBusinessData(T t16) {
        this.businessDataCache.put(t16.getClass().getName(), t16);
    }

    public void setTogetherBusiness(boolean z16, int i3) {
        if (z16) {
            this.mTogetherBusinessFlag = i3 | this.mTogetherBusinessFlag;
        } else {
            this.mTogetherBusinessFlag = (~i3) & this.mTogetherBusinessFlag;
        }
    }

    public String toString() {
        return "ExtensionInfo toString{uin='" + this.uin + "', isSharingLocation=" + this.isSharingLocation + ", hiddenChatSwitch=" + this.hiddenChatSwitch + ", intimate_type=" + this.intimate_type + '}';
    }
}
