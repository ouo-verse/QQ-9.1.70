package com.tencent.mobileqq.activity.aio.zhitu;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import cooperation.peak.PeakConstants;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

/* loaded from: classes10.dex */
public class ZhituPicAdapter extends BaseAdapter implements View.OnClickListener, HorizontalListView.RecycleListener {
    private int C;
    private int D;
    private Context E;
    private QQAppInterface F;
    private BaseActivity G;
    private SessionInfo H;
    private long I;
    private ColorDrawable J;
    public MqqHandler K;
    public String L;
    public int M;

    /* renamed from: d, reason: collision with root package name */
    public List<c> f180365d;

    /* renamed from: e, reason: collision with root package name */
    public List<c> f180366e;

    /* renamed from: f, reason: collision with root package name */
    private float f180367f;

    /* renamed from: h, reason: collision with root package name */
    private int f180368h;

    /* renamed from: i, reason: collision with root package name */
    private int f180369i;

    /* renamed from: m, reason: collision with root package name */
    private int f180370m;

    /* loaded from: classes10.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        RelativeLayout f180372a;

        /* renamed from: b, reason: collision with root package name */
        BubbleImageView f180373b;

        /* renamed from: c, reason: collision with root package name */
        ProgressBar f180374c;

        /* renamed from: d, reason: collision with root package name */
        WeakReference<c> f180375d;

        a() {
        }
    }

    @Override // android.widget.Adapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public c getItem(int i3) {
        if (i3 < this.f180365d.size()) {
            return this.f180365d.get(i3);
        }
        return null;
    }

    public void e() {
        int size = this.f180365d.size();
        if (!TextUtils.isEmpty(this.f180365d.get(size - 1).f180387f) && size > this.M) {
            this.M = size;
            ZhituManager.I(this.F).x0(this.f180365d.size(), this.L);
        }
    }

    public void f() {
        if (QLog.isColorLevel()) {
            QLog.d("ZhituManager", 2, "[ZhituPicAdapter]-resetData");
        }
        this.f180365d.clear();
        this.f180365d.addAll(this.f180366e);
        this.L = "";
        this.M = -1;
        notifyDataSetChanged();
    }

    public void g(int i3, String str) {
        if (QLog.isColorLevel()) {
            QLog.i("ZhituManager", 2, "ZhituPicAdapter setPicItemCount: picCount = ,mReqKey = " + str + ",this.mReqKey =" + this.L);
        }
        if (!TextUtils.isEmpty(str) && i3 > 0) {
            if (!str.equals(this.L)) {
                this.f180365d.clear();
                QQAppInterface qQAppInterface = this.F;
                ReportController.o(qQAppInterface, "dc00898", "", "", "0X8008C71", "0X8008C71", ZhituManager.u(ZhituManager.I(qQAppInterface).B()), 0, "", "", "", "");
            }
            this.L = str;
            for (int i16 = 0; i16 < i3; i16++) {
                this.f180365d.add(new c());
            }
            this.M = -1;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f180365d.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        a aVar;
        AbstractGifImage abstractGifImage;
        int intrinsicWidth;
        View view2;
        View view3 = null;
        if (i3 >= getCount()) {
            QLog.e("ZhituManager", 2, "get view position exception , position = " + i3 + ",size = " + this.f180365d.size());
        } else {
            c item = getItem(i3);
            if (item == null) {
                QLog.e("ZhituManager", 1, "getView emoticon empty position = " + i3);
            } else {
                if (view != null && view.getTag() != null) {
                    aVar = (a) view.getTag();
                } else {
                    aVar = new a();
                    aVar.f180372a = new RelativeLayout(this.E);
                    aVar.f180372a.setLayoutParams(new ViewGroup.LayoutParams(-2, this.f180369i));
                    BubbleImageView bubbleImageView = new BubbleImageView(this.E);
                    aVar.f180373b = bubbleImageView;
                    bubbleImageView.m(false);
                    aVar.f180373b.setRadius(5.0f);
                    BubbleImageView bubbleImageView2 = aVar.f180373b;
                    bubbleImageView2.f179329f = false;
                    bubbleImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.C);
                    layoutParams.addRule(13, -1);
                    aVar.f180372a.addView(aVar.f180373b, layoutParams);
                    ProgressBar progressBar = new ProgressBar(this.E);
                    aVar.f180374c = progressBar;
                    progressBar.setIndeterminateDrawable(this.E.getResources().getDrawable(R.drawable.f160545jt));
                    float f16 = this.f180367f;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) (f16 * 30.0f), (int) (f16 * 30.0f));
                    layoutParams2.addRule(13, -1);
                    aVar.f180372a.addView(aVar.f180374c, layoutParams2);
                    view = aVar.f180372a;
                    view.setTag(aVar);
                    view.setOnClickListener(this);
                }
                aVar.f180375d = new WeakReference<>(item);
                aVar.f180374c.setVisibility(0);
                if (item.f180386e) {
                    String A = ZhituManager.I(this.F).A(item);
                    abstractGifImage = ZhituManager.H(A);
                    if (abstractGifImage == null) {
                        ZhituManager.I(this.F).V(item);
                        if (QLog.isColorLevel()) {
                            QLog.d("ZhituManager", 2, "get gif image from cache fail, " + A);
                        }
                    }
                } else {
                    abstractGifImage = null;
                }
                if (item.f180390i == null && abstractGifImage == null) {
                    aVar.f180373b.setImageDrawable(this.J);
                    ViewGroup.LayoutParams layoutParams3 = aVar.f180373b.getLayoutParams();
                    intrinsicWidth = this.f180368h;
                    layoutParams3.width = intrinsicWidth;
                    aVar.f180374c.setVisibility(0);
                } else {
                    aVar.f180372a.setMinimumWidth(0);
                    Drawable drawable = item.f180390i;
                    aVar.f180373b.setTag(item.f180382a + item.f180389h);
                    if (abstractGifImage != null) {
                        drawable = new GifDrawable(abstractGifImage);
                    }
                    intrinsicWidth = drawable.getIntrinsicWidth();
                    int intrinsicHeight = drawable.getIntrinsicHeight();
                    int i16 = this.C;
                    if (intrinsicHeight == i16) {
                        aVar.f180373b.setScaleType(ImageView.ScaleType.CENTER);
                    } else if (intrinsicHeight > i16) {
                        intrinsicWidth = (intrinsicWidth * i16) / intrinsicHeight;
                        aVar.f180373b.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    } else {
                        intrinsicWidth = (intrinsicWidth * this.f180370m) / intrinsicHeight;
                        aVar.f180373b.setScaleType(ImageView.ScaleType.FIT_XY);
                    }
                    aVar.f180373b.getLayoutParams().width = intrinsicWidth;
                    aVar.f180373b.setImageDrawable(drawable);
                    aVar.f180373b.setBackgroundDrawable(null);
                    aVar.f180374c.setVisibility(8);
                }
                if (i3 == 0) {
                    ViewGroup.LayoutParams layoutParams4 = aVar.f180372a.getLayoutParams();
                    int i17 = this.D;
                    layoutParams4.width = intrinsicWidth + i17;
                    aVar.f180372a.setPadding(0, 0, i17, 0);
                } else {
                    ViewGroup.LayoutParams layoutParams5 = aVar.f180372a.getLayoutParams();
                    int i18 = this.D;
                    layoutParams5.width = intrinsicWidth + (i18 * 2);
                    aVar.f180372a.setPadding(i18, 0, i18, 0);
                }
                d dVar = item.f180393l;
                if (dVar != null && !dVar.f180404i) {
                    ZhituManager.I(this.F).q0(item);
                    item.f180393l.f180404i = true;
                }
                view3 = view;
                view2 = view3;
                EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
                return view3;
            }
        }
        view2 = view;
        EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
        return view3;
    }

    public void h(c cVar) {
        if (cVar != null) {
            int i3 = cVar.f180388g;
            if (i3 >= 0 && i3 < this.f180365d.size()) {
                this.f180365d.get(i3).a(cVar);
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        final c cVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.I < 200) {
            if (QLog.isColorLevel()) {
                QLog.d("ZhituManager", 2, "filter multi click");
            }
        } else {
            this.I = uptimeMillis;
            Object tag = view.getTag();
            if (tag != null && (tag instanceof a)) {
                aVar = (a) tag;
            } else {
                aVar = null;
            }
            if (aVar != null && (cVar = aVar.f180375d.get()) != null && cVar.f180382a != null && cVar.f180393l != null) {
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.zhitu.ZhituPicAdapter.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String str;
                        File file;
                        Bitmap bitmap;
                        c cVar2 = cVar;
                        if (!cVar2.f180392k) {
                            ZhituManager I = ZhituManager.I(ZhituPicAdapter.this.F);
                            c cVar3 = cVar;
                            file = I.O(cVar3.f180382a, cVar3.f180384c);
                            Drawable drawable = cVar.f180390i;
                            if (drawable instanceof BitmapDrawable) {
                                bitmap = ((BitmapDrawable) drawable).getBitmap();
                            } else {
                                bitmap = null;
                            }
                            if (bitmap == null) {
                                return;
                            }
                            try {
                                if (!file.exists()) {
                                    file.getParentFile().mkdirs();
                                    file.createNewFile();
                                }
                                if (!FileUtils.saveBitmapToFile(bitmap, file.getAbsolutePath())) {
                                    return;
                                }
                            } catch (IOException e16) {
                                e16.printStackTrace();
                                return;
                            } catch (OutOfMemoryError e17) {
                                ZhituManager.w0(e17);
                                return;
                            }
                        } else if (cVar2.f180383b == null) {
                            try {
                                str = ZhituManager.I(ZhituPicAdapter.this.F).z(cVar);
                            } catch (OutOfMemoryError e18) {
                                QLog.e("ZhituManager", 1, "oom when save bitmap");
                                ZhituManager.w0(e18);
                                str = null;
                            }
                            if (str == null) {
                                return;
                            } else {
                                file = new File(str);
                            }
                        } else {
                            ZhituManager I2 = ZhituManager.I(ZhituPicAdapter.this.F);
                            c cVar4 = cVar;
                            file = I2.O(cVar4.f180382a, cVar4.f180384c);
                            FileUtils.copyFile(cVar.f180383b, file.getAbsolutePath());
                        }
                        if (ZhituManager.I(ZhituPicAdapter.this.F).B() == 7220) {
                            cVar.f180383b = file.getAbsolutePath();
                            ZhituManager.I(ZhituPicAdapter.this.F).m0(cVar);
                        } else {
                            Intent intent = new Intent();
                            ArrayList<String> arrayList = new ArrayList<>();
                            arrayList.add(file.getAbsolutePath());
                            intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList);
                            intent.putExtra(PeakConstants.SEND_BUSINESS_TYPE, 1044);
                            intent.putExtra("uin", ZhituPicAdapter.this.H.f179557e);
                            intent.putExtra("uintype", ZhituPicAdapter.this.H.f179555d);
                            intent.putExtra("troop_uin", ZhituPicAdapter.this.H.f179559f);
                            intent.putExtra(PeakConstants.SEND_SIZE_SPEC, 0);
                            intent.putExtra(PeakConstants.SEND_IN_BACKGROUND, true);
                            intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", arrayList);
                            new SendPhotoTask(ZhituPicAdapter.this.G, intent, null).run();
                        }
                        ReportController.o(ZhituPicAdapter.this.F, "dc00898", "", "", "0X8008C72", "0X8008C72", ZhituManager.u(ZhituManager.I(ZhituPicAdapter.this.F).B()), 0, "", "", "", "");
                    }
                }, 8, null, false);
                ZhituManager.I(this.F).p0(cVar);
                MqqHandler mqqHandler = this.K;
                if (mqqHandler != null) {
                    Message obtainMessage = mqqHandler.obtainMessage(86);
                    obtainMessage.arg1 = 1;
                    obtainMessage.sendToTarget();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.widget.HorizontalListView.RecycleListener
    public void onViewRecycled(View view) {
        BubbleImageView bubbleImageView;
        if (view != null && (view.getTag() instanceof a) && (bubbleImageView = ((a) view.getTag()).f180373b) != null) {
            bubbleImageView.setImageDrawable(null);
        }
    }

    @Override // com.tencent.widget.HorizontalListView.RecycleListener
    public void onRecycle(View view) {
    }
}
