package com.tencent.state.library.calendar;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.ViewGroup;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.state.config.ConfigService;
import com.tencent.state.library.view.LibraryCalendarGuideView;
import com.tencent.state.mmkv.SKey;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.service.VasLibraryFocusRecord;
import com.tencent.state.service.VasLibraryFocusRecordService;
import com.tencent.state.service.VasLibraryFocusTask;
import com.tencent.state.service.VasLibraryFocusTaskScene;
import com.tencent.state.square.EntranceLink;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.data.BuildingBubble;
import com.tencent.state.square.data.SquareEntranceItem;
import com.tencent.state.square.mmkv.IMMKV;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import nt4.a;
import nt4.c;
import org.json.JSONException;
import org.json.JSONObject;
import org.light.LightConstants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u0004H\u0002J\u0018\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\tH\u0002J\u0006\u0010&\u001a\u00020'J\b\u0010(\u001a\u00020\tH\u0002J\u0012\u0010)\u001a\u00020\t2\b\b\u0002\u0010(\u001a\u00020\tH\u0002J\u0006\u0010*\u001a\u00020'J\u0006\u0010+\u001a\u00020\u001fJ*\u0010,\u001a\u00020'2\b\u0010-\u001a\u0004\u0018\u00010.2\u0018\u0010/\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002020100J\u0016\u00103\u001a\u00020'2\u000e\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000400J\u0014\u00104\u001a\u00020'2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020500J0\u00106\u001a\u00020'2\u0006\u0010-\u001a\u00020.2\u0006\u00107\u001a\u00020\t2\u0018\u0010/\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002020100J\b\u00108\u001a\u00020\u001fH\u0002J\u001c\u00109\u001a\u00020'2\u0006\u0010-\u001a\u00020.2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020'0:J\u0012\u0010;\u001a\u00020\t2\b\b\u0002\u0010(\u001a\u00020\tH\u0002J\u000e\u0010<\u001a\u00020'2\u0006\u0010 \u001a\u00020\u001fJ\u0010\u0010=\u001a\u00020'2\u0006\u0010$\u001a\u00020\u0004H\u0002J\u0010\u0010>\u001a\u00020'2\u0006\u0010$\u001a\u00020\u0004H\u0002J\u0006\u0010?\u001a\u00020\u001fJ\u0012\u0010@\u001a\u00020\t2\b\b\u0002\u0010(\u001a\u00020\tH\u0002J\u000e\u0010A\u001a\u00020'2\u0006\u0010B\u001a\u000202J\u0006\u0010C\u001a\u00020'J\u000e\u0010D\u001a\u00020'2\u0006\u0010E\u001a\u00020FJ\u0006\u0010G\u001a\u00020'J2\u0010H\u001a\u00020'2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020L2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020'0:2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020'0:J\u0016\u0010O\u001a\u00020'2\u000e\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000400J\u000e\u0010P\u001a\u00020'2\u0006\u0010Q\u001a\u00020\u0019R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006R"}, d2 = {"Lcom/tencent/state/library/calendar/CalendarGuideManager;", "", "()V", "BUBBLE_ICON", "", "BUILDING_FIRST_GUIDE", "FIRST_GUIDE_LIB_TYPE", "", "FIRST_GUIDE_LIFE_TIME", "", "FOCUS_MAX_TIME", "LIBRARY_CALENDAR_URL", "MOTION_AWARD", "RECOVERY_LIB_TYPE", "REWARD_AFTER_TASK", "TAG", "TASK_AWARD_LIB_TYPE", "TASK_NOTIFY_LIB_TYPE", "TODAY_RECEIVE_RECOVERY", "TODAY_TASK_AWARD", "TODAY_TASK_COMPLETED", "TODAY_TASK_NOTIFY", "bubbleOffset", "Landroid/graphics/Point;", "calendarGuideDialogShowTask", "Ljava/lang/Runnable;", "getCalendarGuideDialogShowTask", "()Ljava/lang/Runnable;", "setCalendarGuideDialogShowTask", "(Ljava/lang/Runnable;)V", "disableByQBookGuideDialogOnce", "", "hasNewMotion", "isInited", "qBookGuideShowTaskFinished", "canShowTips", "tips", "lifeTime", "continueShowCalendarDialog", "", InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, "currentZeroTimestamp", "disableShowCalendarDialogOnce", "enableShowCalendarGuide", "getCalendarGuideForBuilding", "libraryItem", "Lcom/tencent/state/square/data/SquareEntranceItem;", "callback", "Lcom/tencent/state/service/ResultCallback;", "", "Lcom/tencent/state/square/data/BuildingBubble;", "getCalendarGuideForFocus", "getCalendarGuideForLibrary", "Lcom/tencent/state/library/calendar/CalendarGuideMessage;", "getFocusGuideForBuilding", "serverTime", "hasShowCalendar", "initConfig", "Lkotlin/Function0;", "lastZeroTimestamp", "markNewMotion", "markTipsShow", "markTipsShowFirst", "needShowCalendarGuideAtFirst", "nextZeroTimestamp", "readEntranceMessage", "bubble", "resetDisableShowCalendarDialogOnce", "setCalendarGuideConfig", DownloadInfo.spKey_Config, "Lcom/tencent/state/library/calendar/CalendarGuideConfig;", "setNeedInit", "showCalendarGuideAtFirst", "anchor", "Landroid/view/ViewGroup;", "focusRect", "Landroid/graphics/Rect;", "onConfirm", "onCancel", "showNewMotionIfNeed", "tryShowCalendarGuideDialogAfterQBookGuideDialog", "task", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class CalendarGuideManager {
    private static final String BUBBLE_ICON = "https://vat-zplan-1251316161.file.myqcloud.com/focus_calendar/focus_calendar_bubble_icon.png";
    public static final String BUILDING_FIRST_GUIDE = "\u5feb\u6765\u9886\u53d6\u6d3b\u52a8\u9650\u5b9a\u52a8\u4f5c";
    private static final int FIRST_GUIDE_LIB_TYPE = 1;
    private static final long FIRST_GUIDE_LIFE_TIME = 259200000;
    private static final int FOCUS_MAX_TIME = 600;
    private static final String LIBRARY_CALENDAR_URL = "mqqapi://zplan/enterLibrary?src_type=app&version=1.0&subReferer=em_zplan_library_icon&openFocusCalendar=true";
    public static final String MOTION_AWARD = "\u9a6c\u4e0a\u843d\u5ea7\uff0c\u8ba9\u5927\u5bb6\u56f4\u89c2\u4f60\u7684\u9ad8\u7ea7\u5b66\u9738\u52a8\u4f5c";
    private static final int RECOVERY_LIB_TYPE = 2;
    public static final String REWARD_AFTER_TASK = "\u5b8c\u621010\u5206\u949f\u4e13\u6ce8\u540e\u5373\u53ef\u9886\u53d6\u5956\u52b1";
    private static final String TAG = "CalendarGuideManager";
    private static final int TASK_AWARD_LIB_TYPE = 3;
    private static final int TASK_NOTIFY_LIB_TYPE = 4;
    public static final String TODAY_RECEIVE_RECOVERY = "\u9001\u4f60\u590d\u539f\u5361\uff0c\u53ea\u9650\u4eca\u65e5";
    public static final String TODAY_TASK_AWARD = "\u5b8c\u6210\u4efb\u52a1\uff0c\u7acb\u5373\u9886\u5956\u52b1";
    public static final String TODAY_TASK_COMPLETED = "\u592a\u68d2\u5566\uff01\u4eca\u65e5\u4efb\u52a1\u5df2\u5b8c\u6210";
    public static final String TODAY_TASK_NOTIFY = "\u8fd8\u5dee\u4e00\u70b9\u5b8c\u6210\u4eca\u65e5\u4efb\u52a1";
    private static Runnable calendarGuideDialogShowTask;
    private static boolean disableByQBookGuideDialogOnce;
    private static boolean hasNewMotion;
    private static boolean isInited;
    private static boolean qBookGuideShowTaskFinished;
    public static final CalendarGuideManager INSTANCE = new CalendarGuideManager();
    private static Point bubbleOffset = new Point(0, 0);

    CalendarGuideManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean canShowTips(String tips) {
        long decodeLong$default = IMMKV.DefaultImpls.decodeLong$default(SquareBaseKt.getSquareMMKV(), SKey.Calendar.SQUARE_LIBRARY_CALENDAR_GUIDE_KEY_PREFIX + tips, 0L, null, false, 12, null);
        Calendar nowCalendar = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(nowCalendar, "nowCalendar");
        nowCalendar.setTimeInMillis(currentTime());
        Calendar lastCalendar = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(lastCalendar, "lastCalendar");
        lastCalendar.setTimeInMillis(decodeLong$default);
        return (lastCalendar.get(5) == nowCalendar.get(5) && lastCalendar.get(2) == nowCalendar.get(2) && lastCalendar.get(1) == nowCalendar.get(1)) ? false : true;
    }

    private final long currentTime() {
        long serverTime = Square.INSTANCE.getConfig().getCommonUtils().getServerTime();
        return serverTime > 0 ? serverTime * 1000 : System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long currentZeroTimestamp(long currentTime) {
        Calendar calendar = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(calendar, "Calendar.getInstance()");
        if (currentTime > 0) {
            calendar.setTimeInMillis(currentTime);
        }
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        return calendar.getTimeInMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean hasShowCalendar() {
        return IMMKV.DefaultImpls.decodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.Calendar.HAS_SHOW_LIBRARY_CALENDAR, false, null, false, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long lastZeroTimestamp(long currentTime) {
        Calendar calendar = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(calendar, "Calendar.getInstance()");
        if (currentTime > 0) {
            calendar.setTimeInMillis(currentTime);
        }
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.add(5, -1);
        return calendar.getTimeInMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void markTipsShow(String tips) {
        IMMKV.DefaultImpls.encodeLong$default(SquareBaseKt.getSquareMMKV(), SKey.Calendar.SQUARE_LIBRARY_CALENDAR_GUIDE_KEY_PREFIX + tips, currentTime(), null, false, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void markTipsShowFirst(String tips) {
        String str = SKey.Calendar.SQUARE_LIBRARY_CALENDAR_GUIDE_KEY_PREFIX + tips;
        if (IMMKV.DefaultImpls.decodeLong$default(SquareBaseKt.getSquareMMKV(), str, 0L, null, false, 12, null) == 0) {
            IMMKV.DefaultImpls.encodeLong$default(SquareBaseKt.getSquareMMKV(), str, currentTime(), null, false, 12, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long nextZeroTimestamp(long currentTime) {
        Calendar calendar = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(calendar, "Calendar.getInstance()");
        if (currentTime > 0) {
            calendar.setTimeInMillis(currentTime);
        }
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.add(5, 1);
        return calendar.getTimeInMillis() / 1000;
    }

    public final void continueShowCalendarDialog() {
        Runnable runnable = calendarGuideDialogShowTask;
        if (runnable != null) {
            runnable.run();
        }
        calendarGuideDialogShowTask = null;
        disableByQBookGuideDialogOnce = false;
        qBookGuideShowTaskFinished = true;
    }

    public final boolean enableShowCalendarGuide() {
        return IMMKV.DefaultImpls.decodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.Calendar.ENABLE_SHOW_LIBRARY_CALENDAR_GUIDE, false, null, false, 12, null);
    }

    public final Runnable getCalendarGuideDialogShowTask() {
        return calendarGuideDialogShowTask;
    }

    public final void getCalendarGuideForBuilding(final SquareEntranceItem libraryItem, final ResultCallback<Map<Integer, BuildingBubble>> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (libraryItem == null) {
            callback.onResultSuccess(new LinkedHashMap());
        } else {
            initConfig(libraryItem, new Function0<Unit>() { // from class: com.tencent.state.library.calendar.CalendarGuideManager$getCalendarGuideForBuilding$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    boolean hasShowCalendar;
                    boolean canShowTips;
                    Point point;
                    Map mutableMapOf;
                    CalendarGuideManager calendarGuideManager = CalendarGuideManager.INSTANCE;
                    if (!calendarGuideManager.enableShowCalendarGuide()) {
                        ResultCallback.this.onResultSuccess(new LinkedHashMap());
                        return;
                    }
                    if (calendarGuideManager.needShowCalendarGuideAtFirst()) {
                        canShowTips = calendarGuideManager.canShowTips(CalendarGuideManager.BUILDING_FIRST_GUIDE, 259200000L);
                        if (canShowTips) {
                            EntranceLink link = libraryItem.getLink();
                            point = CalendarGuideManager.bubbleOffset;
                            BuildingBubble buildingBubble = new BuildingBubble(0, "", CalendarGuideManager.BUILDING_FIRST_GUIDE, "https://vat-zplan-1251316161.file.myqcloud.com/focus_calendar/focus_calendar_bubble_icon.png", link, 0, 1, point);
                            ResultCallback resultCallback = ResultCallback.this;
                            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(Integer.valueOf(libraryItem.getEntranceId()), buildingBubble));
                            resultCallback.onResultSuccess(mutableMapOf);
                            calendarGuideManager.markTipsShowFirst(CalendarGuideManager.BUILDING_FIRST_GUIDE);
                            return;
                        }
                    }
                    hasShowCalendar = calendarGuideManager.hasShowCalendar();
                    if (!hasShowCalendar) {
                        ResultCallback.this.onResultSuccess(new LinkedHashMap());
                    } else {
                        VasLibraryFocusRecordService.INSTANCE.requestFocusTask(VasLibraryFocusTaskScene.SQUARE, new ResultCallback<VasLibraryFocusTask>() { // from class: com.tencent.state.library.calendar.CalendarGuideManager$getCalendarGuideForBuilding$1.1
                            @Override // com.tencent.state.service.ResultCallback
                            public void onResultFailure(int i3, String str, String str2) {
                                ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
                            }

                            @Override // com.tencent.state.service.ResultCallback
                            public void onResultFailure(int error, String message) {
                                ResultCallback.this.onResultFailure(error, message);
                            }

                            @Override // com.tencent.state.service.ResultCallback
                            public void onResultSuccess(VasLibraryFocusTask result) {
                                long lastZeroTimestamp;
                                long currentZeroTimestamp;
                                long nextZeroTimestamp;
                                boolean canShowTips2;
                                Point point2;
                                boolean canShowTips3;
                                Point point3;
                                Intrinsics.checkNotNullParameter(result, "result");
                                HashMap hashMap = new HashMap();
                                if (result.getHintRecovery()) {
                                    canShowTips3 = CalendarGuideManager.INSTANCE.canShowTips(CalendarGuideManager.TODAY_RECEIVE_RECOVERY);
                                    if (canShowTips3) {
                                        EntranceLink entranceLink = new EntranceLink("mqqapi://zplan/enterLibrary?src_type=app&version=1.0&subReferer=em_zplan_library_icon&openFocusCalendar=true", 2);
                                        point3 = CalendarGuideManager.bubbleOffset;
                                        hashMap.put(Integer.valueOf(libraryItem.getEntranceId()), new BuildingBubble(0, "", CalendarGuideManager.TODAY_RECEIVE_RECOVERY, "https://vat-zplan-1251316161.file.myqcloud.com/focus_calendar/focus_calendar_bubble_icon.png", entranceLink, 0, 2, point3));
                                        ResultCallback.this.onResultSuccess(hashMap);
                                        return;
                                    }
                                } else {
                                    Map<Long, Boolean> dailyResult = result.getDailyResult();
                                    CalendarGuideManager calendarGuideManager2 = CalendarGuideManager.INSTANCE;
                                    lastZeroTimestamp = calendarGuideManager2.lastZeroTimestamp(result.getServerTime());
                                    if (Intrinsics.areEqual(dailyResult.get(Long.valueOf(lastZeroTimestamp)), Boolean.TRUE)) {
                                        Map<Long, Boolean> dailyResult2 = result.getDailyResult();
                                        currentZeroTimestamp = calendarGuideManager2.currentZeroTimestamp(result.getServerTime());
                                        if (!Intrinsics.areEqual(dailyResult2.get(Long.valueOf(currentZeroTimestamp)), r5)) {
                                            long endTimestamp = result.getEndTimestamp();
                                            nextZeroTimestamp = calendarGuideManager2.nextZeroTimestamp(result.getServerTime());
                                            if (endTimestamp == nextZeroTimestamp) {
                                                canShowTips2 = calendarGuideManager2.canShowTips(CalendarGuideManager.TODAY_TASK_AWARD);
                                                if (canShowTips2) {
                                                    EntranceLink entranceLink2 = new EntranceLink("mqqapi://zplan/enterLibrary?src_type=app&version=1.0&subReferer=em_zplan_library_icon&openFocusCalendar=true", 2);
                                                    point2 = CalendarGuideManager.bubbleOffset;
                                                    hashMap.put(Integer.valueOf(libraryItem.getEntranceId()), new BuildingBubble(0, "", CalendarGuideManager.TODAY_TASK_AWARD, "https://vat-zplan-1251316161.file.myqcloud.com/focus_calendar/focus_calendar_bubble_icon.png", entranceLink2, 0, 3, point2));
                                                    ResultCallback.this.onResultSuccess(hashMap);
                                                    return;
                                                }
                                            }
                                        }
                                    }
                                }
                                if (result.getStartTimestamp() > 0) {
                                    CalendarGuideManager.INSTANCE.getFocusGuideForBuilding(libraryItem, result.getServerTime(), ResultCallback.this);
                                } else {
                                    ResultCallback.this.onResultSuccess(hashMap);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public final void getCalendarGuideForFocus(final ResultCallback<String> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!enableShowCalendarGuide()) {
            callback.onResultSuccess(null);
        } else {
            VasLibraryFocusRecordService.INSTANCE.requestFocusTask(VasLibraryFocusTaskScene.LIBRARY, new ResultCallback<VasLibraryFocusTask>() { // from class: com.tencent.state.library.calendar.CalendarGuideManager$getCalendarGuideForFocus$1
                @Override // com.tencent.state.service.ResultCallback
                public void onResultFailure(int i3, String str, String str2) {
                    ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
                }

                @Override // com.tencent.state.service.ResultCallback
                public void onResultFailure(int error, String message) {
                    ResultCallback.this.onResultFailure(error, message);
                }

                @Override // com.tencent.state.service.ResultCallback
                public void onResultSuccess(VasLibraryFocusTask result) {
                    long currentZeroTimestamp;
                    boolean canShowTips;
                    Intrinsics.checkNotNullParameter(result, "result");
                    Map<Long, Boolean> dailyResult = result.getDailyResult();
                    CalendarGuideManager calendarGuideManager = CalendarGuideManager.INSTANCE;
                    currentZeroTimestamp = calendarGuideManager.currentZeroTimestamp(result.getServerTime());
                    Boolean bool = dailyResult.get(Long.valueOf(currentZeroTimestamp));
                    if (bool != null ? bool.booleanValue() : false) {
                        canShowTips = calendarGuideManager.canShowTips(CalendarGuideManager.TODAY_TASK_COMPLETED);
                        if (canShowTips) {
                            calendarGuideManager.markTipsShow(CalendarGuideManager.TODAY_TASK_COMPLETED);
                            ResultCallback.this.onResultSuccess(CalendarGuideManager.TODAY_TASK_COMPLETED);
                            return;
                        }
                    }
                    ResultCallback.this.onResultSuccess(null);
                }
            });
        }
    }

    public final void getCalendarGuideForLibrary(final ResultCallback<CalendarGuideMessage> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!enableShowCalendarGuide()) {
            callback.onResultSuccess(new CalendarGuideMessage(null, null, 3, null));
        } else {
            VasLibraryFocusRecordService.INSTANCE.requestFocusTask(VasLibraryFocusTaskScene.LIBRARY, new ResultCallback<VasLibraryFocusTask>() { // from class: com.tencent.state.library.calendar.CalendarGuideManager$getCalendarGuideForLibrary$1
                @Override // com.tencent.state.service.ResultCallback
                public void onResultFailure(int i3, String str, String str2) {
                    ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
                }

                @Override // com.tencent.state.service.ResultCallback
                public void onResultFailure(int error, String message) {
                    ResultCallback.this.onResultFailure(error, message);
                }

                @Override // com.tencent.state.service.ResultCallback
                public void onResultSuccess(VasLibraryFocusTask result) {
                    long currentZeroTimestamp;
                    long lastZeroTimestamp;
                    long nextZeroTimestamp;
                    boolean canShowTips;
                    boolean canShowTips2;
                    Intrinsics.checkNotNullParameter(result, "result");
                    Map<Long, Boolean> dailyResult = result.getDailyResult();
                    CalendarGuideManager calendarGuideManager = CalendarGuideManager.INSTANCE;
                    currentZeroTimestamp = calendarGuideManager.currentZeroTimestamp(result.getServerTime());
                    Boolean bool = dailyResult.get(Long.valueOf(currentZeroTimestamp));
                    boolean booleanValue = bool != null ? bool.booleanValue() : false;
                    Map<Long, Boolean> dailyResult2 = result.getDailyResult();
                    lastZeroTimestamp = calendarGuideManager.lastZeroTimestamp(result.getServerTime());
                    Boolean bool2 = dailyResult2.get(Long.valueOf(lastZeroTimestamp));
                    boolean booleanValue2 = bool2 != null ? bool2.booleanValue() : false;
                    if (booleanValue) {
                        canShowTips2 = calendarGuideManager.canShowTips(CalendarGuideManager.TODAY_TASK_COMPLETED);
                        if (canShowTips2) {
                            calendarGuideManager.markTipsShow(CalendarGuideManager.TODAY_TASK_COMPLETED);
                            ResultCallback.this.onResultSuccess(new CalendarGuideMessage(CalendarGuideManager.TODAY_TASK_COMPLETED, null));
                            return;
                        }
                    } else if (booleanValue2) {
                        long endTimestamp = result.getEndTimestamp();
                        nextZeroTimestamp = calendarGuideManager.nextZeroTimestamp(result.getServerTime());
                        if (endTimestamp == nextZeroTimestamp) {
                            canShowTips = calendarGuideManager.canShowTips(CalendarGuideManager.REWARD_AFTER_TASK);
                            if (canShowTips) {
                                calendarGuideManager.markTipsShow(CalendarGuideManager.REWARD_AFTER_TASK);
                                ResultCallback.this.onResultSuccess(new CalendarGuideMessage(null, CalendarGuideManager.REWARD_AFTER_TASK));
                                return;
                            }
                        }
                    }
                    ResultCallback.this.onResultSuccess(new CalendarGuideMessage(null, null, 3, null));
                }
            });
        }
    }

    public final void getFocusGuideForBuilding(final SquareEntranceItem libraryItem, long serverTime, final ResultCallback<Map<Integer, BuildingBubble>> callback) {
        Intrinsics.checkNotNullParameter(libraryItem, "libraryItem");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!canShowTips(TODAY_TASK_NOTIFY)) {
            callback.onResultSuccess(new LinkedHashMap());
        } else {
            VasLibraryFocusRecordService.INSTANCE.requestFocusRecord(currentZeroTimestamp(serverTime), nextZeroTimestamp(serverTime), new ResultCallback<VasLibraryFocusRecord>() { // from class: com.tencent.state.library.calendar.CalendarGuideManager$getFocusGuideForBuilding$1
                @Override // com.tencent.state.service.ResultCallback
                public void onResultFailure(int i3, String str, String str2) {
                    ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
                }

                @Override // com.tencent.state.service.ResultCallback
                public void onResultFailure(int error, String message) {
                    callback.onResultFailure(error, message);
                }

                @Override // com.tencent.state.service.ResultCallback
                public void onResultSuccess(VasLibraryFocusRecord result) {
                    boolean canShowTips;
                    Point point;
                    HashMap hashMap = new HashMap();
                    if (result != null && !result.isFinish() && result.getTotalTime() > 0 && result.getTotalTime() < 600) {
                        canShowTips = CalendarGuideManager.INSTANCE.canShowTips(CalendarGuideManager.TODAY_TASK_NOTIFY);
                        if (canShowTips) {
                            EntranceLink entranceLink = new EntranceLink("mqqapi://zplan/enterLibrary?src_type=app&version=1.0&subReferer=em_zplan_library_icon&openFocusCalendar=true", 2);
                            point = CalendarGuideManager.bubbleOffset;
                            hashMap.put(Integer.valueOf(SquareEntranceItem.this.getEntranceId()), new BuildingBubble(0, "", CalendarGuideManager.TODAY_TASK_NOTIFY, "https://vat-zplan-1251316161.file.myqcloud.com/focus_calendar/focus_calendar_bubble_icon.png", entranceLink, 0, 4, point));
                        }
                    }
                    callback.onResultSuccess(hashMap);
                }
            });
        }
    }

    public final void initConfig(SquareEntranceItem libraryItem, final Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(libraryItem, "libraryItem");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!isInited) {
            new ConfigService().getBuildingConfig(new int[]{libraryItem.getEntranceId()}, new Function1<c, Unit>() { // from class: com.tencent.state.library.calendar.CalendarGuideManager$initConfig$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(c cVar) {
                    invoke2(cVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(c cVar) {
                    a aVar;
                    a[] aVarArr;
                    Object firstOrNull;
                    CalendarGuideManager calendarGuideManager = CalendarGuideManager.INSTANCE;
                    CalendarGuideManager.isInited = cVar != null;
                    JSONObject jSONObject = null;
                    if (cVar == null || (aVarArr = cVar.f421280a) == null) {
                        aVar = null;
                    } else {
                        firstOrNull = ArraysKt___ArraysKt.firstOrNull(aVarArr);
                        aVar = (a) firstOrNull;
                    }
                    if (aVar != null) {
                        try {
                            byte[] bArr = aVar.f421278b;
                            Intrinsics.checkNotNullExpressionValue(bArr, "config.config");
                            jSONObject = new JSONObject(new String(bArr, Charsets.UTF_8));
                        } catch (JSONException e16) {
                            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "CalendarGuideManager", "initConfig failed " + e16.getMessage(), null, 4, null);
                        }
                        IMMKV.DefaultImpls.encodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.Calendar.ENABLE_SHOW_LIBRARY_CALENDAR_GUIDE, jSONObject != null ? jSONObject.optBoolean("calendar_guide") : false, null, false, 12, null);
                        SquareBase squareBase = SquareBase.INSTANCE;
                        int calPx = ViewExtensionsKt.calPx(squareBase.getApp(), jSONObject != null ? jSONObject.optInt("calendar_bubble_x", 0) : 0);
                        int calPx2 = ViewExtensionsKt.calPx(squareBase.getApp(), jSONObject != null ? jSONObject.optInt("calendar_bubble_y", LightConstants.ErrorCode.HEAD_INSET_RESOURCE_NOT_SUPPORT) : 0);
                        CalendarGuideManager calendarGuideManager2 = CalendarGuideManager.INSTANCE;
                        CalendarGuideManager.bubbleOffset = new Point(calPx, calPx2);
                    } else {
                        IMMKV.DefaultImpls.encodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.Calendar.ENABLE_SHOW_LIBRARY_CALENDAR_GUIDE, false, null, false, 12, null);
                    }
                    Function0.this.invoke();
                }
            });
        } else {
            callback.invoke();
        }
    }

    public final void markNewMotion(boolean hasNewMotion2) {
        hasNewMotion = hasNewMotion2;
    }

    public final boolean needShowCalendarGuideAtFirst() {
        return !IMMKV.DefaultImpls.decodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.Calendar.HAS_SHOW_LIBRARY_CALENDAR_GUIDE, false, null, false, 12, null);
    }

    public final void readEntranceMessage(BuildingBubble bubble) {
        Intrinsics.checkNotNullParameter(bubble, "bubble");
        markTipsShow(bubble.getContent());
    }

    public final void setCalendarGuideConfig(CalendarGuideConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        IMMKV.DefaultImpls.encodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.Calendar.HAS_SHOW_LIBRARY_CALENDAR, true, null, false, 12, null);
    }

    public final void setCalendarGuideDialogShowTask(Runnable runnable) {
        calendarGuideDialogShowTask = runnable;
    }

    public final void showCalendarGuideAtFirst(ViewGroup anchor, Rect focusRect, Function0<Unit> onConfirm, Function0<Unit> onCancel) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        Intrinsics.checkNotNullParameter(focusRect, "focusRect");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Intrinsics.checkNotNullParameter(onCancel, "onCancel");
        if (enableShowCalendarGuide() && needShowCalendarGuideAtFirst()) {
            LibraryCalendarGuideView.INSTANCE.showAtView(anchor, focusRect, onConfirm, onCancel);
            IMMKV.DefaultImpls.encodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.Calendar.HAS_SHOW_LIBRARY_CALENDAR_GUIDE, true, null, false, 12, null);
        }
    }

    public final void showNewMotionIfNeed(ResultCallback<String> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (hasNewMotion) {
            callback.onResultSuccess(MOTION_AWARD);
            hasNewMotion = false;
        } else {
            callback.onResultSuccess(null);
        }
    }

    public final void tryShowCalendarGuideDialogAfterQBookGuideDialog(Runnable task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (qBookGuideShowTaskFinished) {
            if (!disableByQBookGuideDialogOnce) {
                task.run();
                return;
            } else {
                resetDisableShowCalendarDialogOnce();
                return;
            }
        }
        calendarGuideDialogShowTask = task;
    }

    public final void disableShowCalendarDialogOnce() {
        disableByQBookGuideDialogOnce = true;
        calendarGuideDialogShowTask = null;
        qBookGuideShowTaskFinished = true;
    }

    public final void resetDisableShowCalendarDialogOnce() {
        disableByQBookGuideDialogOnce = false;
        calendarGuideDialogShowTask = null;
        qBookGuideShowTaskFinished = false;
    }

    public final void setNeedInit() {
        isInited = false;
    }

    static /* synthetic */ long currentZeroTimestamp$default(CalendarGuideManager calendarGuideManager, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 0;
        }
        return calendarGuideManager.currentZeroTimestamp(j3);
    }

    static /* synthetic */ long lastZeroTimestamp$default(CalendarGuideManager calendarGuideManager, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 0;
        }
        return calendarGuideManager.lastZeroTimestamp(j3);
    }

    static /* synthetic */ long nextZeroTimestamp$default(CalendarGuideManager calendarGuideManager, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 0;
        }
        return calendarGuideManager.nextZeroTimestamp(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean canShowTips(String tips, long lifeTime) {
        long decodeLong$default = IMMKV.DefaultImpls.decodeLong$default(SquareBaseKt.getSquareMMKV(), SKey.Calendar.SQUARE_LIBRARY_CALENDAR_GUIDE_KEY_PREFIX + tips, 0L, null, false, 12, null);
        return decodeLong$default == 0 || currentTime() - decodeLong$default < lifeTime;
    }
}
