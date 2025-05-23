package com.tencent.mobileqq.aio.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import androidx.recyclerview.widget.AIORecycleView;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.LongShotMsgIntent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b1\u00102J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J@\u0010\u0012\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013J\u0016\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013J\u0016\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001bJ\u000e\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013J\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00160\u001f2\u0006\u0010\u0014\u001a\u00020\u0013J\u0016\u0010$\u001a\u00020#2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u000fJB\u0010*\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u001f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020'0\u001fJ*\u0010.\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00160\u001f2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00160\u001fJ\u0016\u00100\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020+2\u0006\u0010/\u001a\u00020\u0002\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/aio/utils/am;", "", "", CustomAnimation.KeyPath.MASK_COLOR, "Landroid/graphics/Canvas;", PM.CANVAS, "Landroid/graphics/Paint;", "paint", "Landroid/view/View;", "childView", "", "c", "rangeColor", "Landroid/graphics/Path;", "path", "", "isPrevItemChecked", "isNextItemChecked", "d", "Lcom/tencent/aio/api/runtime/a;", "context", "j", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", tl.h.F, "f", "totalHeight", "Landroid/graphics/Point;", "outSize", "i", "g", "", "k", "v", "needAlpha", "Landroid/graphics/Bitmap;", "e", "Landroidx/recyclerview/widget/AIORecycleView;", "recyclerView", "Lcom/tencent/aio/data/msglist/a;", "longShotMsgList", "displayMsgList", "l", "Landroid/content/Context;", "msgItemList", "newMsgList", "b", "msgHeight", "a", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class am {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final am f194110a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65298);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            f194110a = new am();
        }
    }

    am() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void c(int maskColor, Canvas canvas, Paint paint, View childView) {
        paint.setColor(maskColor);
        paint.setStyle(Paint.Style.FILL);
        paint.setPathEffect(null);
        canvas.drawRect(childView.getLeft(), childView.getTop(), childView.getRight(), childView.getBottom(), paint);
    }

    private final void d(int rangeColor, Path path, boolean isPrevItemChecked, boolean isNextItemChecked, View childView, Canvas canvas, Paint paint) {
        paint.setColor(rangeColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2.0f);
        paint.setPathEffect(new DashPathEffect(new float[]{2.0f, 6.0f}, 0.0f));
        path.reset();
        path.moveTo(childView.getLeft() + 1, childView.getTop() + 1);
        path.lineTo(childView.getLeft() + 1, childView.getTop() + (childView.getHeight() / 2));
        canvas.drawPath(path, paint);
        path.reset();
        path.moveTo(childView.getRight() - 1, childView.getTop() + 1);
        path.lineTo(childView.getRight() - 1, childView.getTop() + (childView.getHeight() / 2));
        canvas.drawPath(path, paint);
        if (!isPrevItemChecked) {
            path.reset();
            path.moveTo(childView.getLeft() + 1, childView.getTop() + 1);
            path.lineTo(childView.getRight() - 1, childView.getTop() + 1);
            canvas.drawPath(path, paint);
        }
        path.reset();
        path.moveTo(childView.getLeft() + 1, childView.getTop() + (childView.getHeight() / 2));
        path.lineTo(childView.getLeft() + 1, childView.getBottom() - 1);
        canvas.drawPath(path, paint);
        path.reset();
        path.moveTo(childView.getRight() - 1, childView.getTop() + (childView.getHeight() / 2));
        path.lineTo(childView.getRight() - 1, childView.getBottom() - 1);
        canvas.drawPath(path, paint);
        if (!isNextItemChecked) {
            path.reset();
            path.moveTo(childView.getLeft() + 1, childView.getBottom() - 1);
            path.lineTo(childView.getRight() - 1, childView.getBottom() - 1);
            canvas.drawPath(path, paint);
        }
    }

    public final boolean a(@NotNull Context context, int msgHeight) {
        Activity activity;
        WindowManager windowManager;
        Display defaultDisplay;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) context, msgHeight)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Point point = new Point();
        Unit unit = null;
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null && (windowManager = activity.getWindowManager()) != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
            defaultDisplay.getSize(point);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            return false;
        }
        QLog.i("MsgShotUtil", 1, "[checkMsgLimit]: msgHeight= " + msgHeight + ", outSize.x = " + point.x + ", outSize.y = " + point.y);
        if (!i(msgHeight, point)) {
            return true;
        }
        BaseApplication baseApplication = BaseApplication.context;
        QQToast.makeText(baseApplication, 1, baseApplication.getString(R.string.yrx), 0).show();
        return false;
    }

    public final boolean b(@NotNull Context context, @NotNull List<? extends AIOMsgItem> msgItemList, @NotNull List<? extends AIOMsgItem> newMsgList) {
        Activity activity;
        WindowManager windowManager;
        Display defaultDisplay;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, this, context, msgItemList, newMsgList)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItemList, "msgItemList");
        Intrinsics.checkNotNullParameter(newMsgList, "newMsgList");
        Iterator<T> it = msgItemList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += ((AIOMsgItem) it.next()).T();
        }
        Iterator<T> it5 = newMsgList.iterator();
        int i16 = 0;
        while (it5.hasNext()) {
            i16 += ((AIOMsgItem) it5.next()).T();
        }
        int i17 = i3 + i16;
        Point point = new Point();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null && (windowManager = activity.getWindowManager()) != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
            defaultDisplay.getSize(point);
        }
        QLog.i("MsgShotUtil", 1, "selected height: " + i3 + ", new select height: " + i16 + ", outSize.x = " + point.x + ", outSize.y = " + point.y);
        if (!i(i17, point)) {
            return true;
        }
        BaseApplication baseApplication = BaseApplication.context;
        QQToast.makeText(baseApplication, 1, baseApplication.getString(R.string.yrx), 0).show();
        return false;
    }

    @NotNull
    public final Bitmap e(@NotNull View v3, boolean needAlpha) {
        Bitmap viewBitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Bitmap) iPatchRedirector.redirect((short) 8, this, v3, Boolean.valueOf(needAlpha));
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        if (needAlpha) {
            viewBitmap = Bitmap.createBitmap(v3.getWidth(), v3.getHeight(), Bitmap.Config.ARGB_8888);
        } else {
            viewBitmap = Bitmap.createBitmap(v3.getWidth(), v3.getHeight(), Bitmap.Config.RGB_565);
        }
        Canvas canvas = new Canvas(viewBitmap);
        if (FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("aio_shot_density_8996", true)) {
            canvas.setDensity(0);
        } else {
            canvas.setDensity(v3.getContext().getResources().getDisplayMetrics().densityDpi);
        }
        v3.draw(canvas);
        Intrinsics.checkNotNullExpressionValue(viewBitmap, "viewBitmap");
        return viewBitmap;
    }

    public final int f(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context)).intValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        LongShotMsgIntent.GetSelectMsgSum getSelectMsgSum = new LongShotMsgIntent.GetSelectMsgSum(0, 1, null);
        context.e().h(getSelectMsgSum);
        return getSelectMsgSum.a();
    }

    public final boolean g(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        LongShotMsgIntent.GetMosaicStatus getMosaicStatus = new LongShotMsgIntent.GetMosaicStatus(false, 1, null);
        context.e().h(getMosaicStatus);
        return getMosaicStatus.a();
    }

    public final boolean h(@NotNull com.tencent.aio.api.runtime.a context, @NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) msgItem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        LongShotMsgIntent.IsMsgSelect isMsgSelect = new LongShotMsgIntent.IsMsgSelect(msgItem, false, 2, null);
        context.e().h(isMsgSelect);
        return isMsgSelect.b();
    }

    public final boolean i(int totalHeight, @NotNull Point outSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, totalHeight, (Object) outSize)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(outSize, "outSize");
        if (totalHeight <= outSize.y * 10 && totalHeight <= 30000 && outSize.x * totalHeight < 200000000) {
            return false;
        }
        return true;
    }

    public final boolean j(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        LongShotMsgIntent.GetShotMode getShotMode = new LongShotMsgIntent.GetShotMode(false, 1, null);
        context.e().h(getShotMode);
        return getShotMode.a();
    }

    @NotNull
    public final List<AIOMsgItem> k(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        LongShotMsgIntent.GetLongShotMsgList getLongShotMsgList = new LongShotMsgIntent.GetLongShotMsgList(null, 1, 0 == true ? 1 : 0);
        context.e().h(getLongShotMsgList);
        return getLongShotMsgList.a();
    }

    public final void l(int maskColor, int rangeColor, @NotNull AIORecycleView recyclerView, @NotNull Canvas canvas, @NotNull List<? extends com.tencent.aio.data.msglist.a> longShotMsgList, @NotNull List<? extends com.tencent.aio.data.msglist.a> displayMsgList) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        View view;
        int i3;
        int i16;
        ArrayList arrayList;
        boolean z26;
        boolean z27;
        boolean z28;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z29 = true;
        boolean z36 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(maskColor), Integer.valueOf(rangeColor), recyclerView, canvas, longShotMsgList, displayMsgList);
            return;
        }
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(longShotMsgList, "longShotMsgList");
        Intrinsics.checkNotNullParameter(displayMsgList, "displayMsgList");
        Paint paint = new Paint(1);
        Path path = new Path();
        ArrayList arrayList2 = new ArrayList();
        int i17 = 0;
        for (com.tencent.aio.data.msglist.a aVar : displayMsgList) {
            int i18 = i17 + 1;
            List<? extends com.tencent.aio.data.msglist.a> list = longShotMsgList;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (((com.tencent.aio.data.msglist.a) it.next()).getMsgId() == aVar.getMsgId()) {
                        z27 = true;
                    } else {
                        z27 = false;
                    }
                    if (z27) {
                        z28 = true;
                        break;
                    }
                }
            }
            z28 = false;
            if (z28) {
                arrayList2.add(Integer.valueOf(i17));
            }
            i17 = i18;
        }
        int childCount = recyclerView.getChildCount();
        int i19 = 0;
        int i26 = 0;
        while (i26 < childCount) {
            int findFirstVisibleItemPosition = recyclerView.getLayoutManager().findFirstVisibleItemPosition() + i26;
            View childView = recyclerView.getChildAt(i26);
            if (!arrayList2.isEmpty()) {
                Iterator it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    if (((Number) it5.next()).intValue() == findFirstVisibleItemPosition) {
                        z16 = z29;
                    } else {
                        z16 = z36;
                    }
                    if (z16) {
                        z17 = z29;
                        break;
                    }
                }
            }
            z17 = z36;
            if (!z17) {
                Intrinsics.checkNotNullExpressionValue(childView, "childView");
                c(maskColor, canvas, paint, childView);
                view = childView;
                i3 = i26;
                i16 = childCount;
                arrayList = arrayList2;
            } else {
                if (!arrayList2.isEmpty()) {
                    Iterator it6 = arrayList2.iterator();
                    while (it6.hasNext()) {
                        if (((Number) it6.next()).intValue() == findFirstVisibleItemPosition - 1) {
                            z18 = true;
                        } else {
                            z18 = z36;
                        }
                        if (z18) {
                            z19 = true;
                            break;
                        }
                    }
                }
                z19 = z36;
                if (!arrayList2.isEmpty()) {
                    Iterator it7 = arrayList2.iterator();
                    while (true) {
                        if (it7.hasNext()) {
                            if (((Number) it7.next()).intValue() == findFirstVisibleItemPosition + 1) {
                                z26 = true;
                            } else {
                                z26 = false;
                            }
                            if (z26) {
                                z36 = true;
                                break;
                            }
                        } else {
                            z36 = false;
                            break;
                        }
                    }
                }
                Intrinsics.checkNotNullExpressionValue(childView, "childView");
                view = childView;
                boolean z37 = z36;
                i3 = i26;
                i16 = childCount;
                arrayList = arrayList2;
                d(rangeColor, path, z19, z37, view, canvas, paint);
            }
            i19 = view.getBottom();
            i26 = i3 + 1;
            childCount = i16;
            arrayList2 = arrayList;
            z29 = true;
            z36 = false;
        }
        paint.setColor(maskColor);
        paint.setStyle(Paint.Style.FILL);
        paint.setPathEffect(null);
        canvas.drawRect(recyclerView.getLeft(), i19, recyclerView.getRight(), recyclerView.getBottom(), paint);
    }
}
