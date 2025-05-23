package jd0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.al;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b extends BaseAdapter {
    protected static int C;
    protected static int D;
    protected static int E;

    /* renamed from: d, reason: collision with root package name */
    protected Context f409828d;

    /* renamed from: f, reason: collision with root package name */
    protected ArrayList<d> f409830f;

    /* renamed from: i, reason: collision with root package name */
    protected GridView f409832i;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f409833m;

    /* renamed from: e, reason: collision with root package name */
    protected ArrayList<d> f409829e = null;

    /* renamed from: h, reason: collision with root package name */
    protected d f409831h = null;

    public b(Context context, GridView gridView, boolean z16, boolean z17) {
        this.f409830f = null;
        this.f409828d = context;
        this.f409832i = gridView;
        this.f409833m = z16;
        Resources resources = context.getResources();
        C = BaseAIOUtils.f(80.0f, resources);
        D = BaseAIOUtils.f(10.0f, resources);
        E = BaseAIOUtils.f(5.0f, resources);
        this.f409832i.setColumnWidth(C);
        ArrayList<d> arrayList = new ArrayList<>();
        this.f409830f = arrayList;
        arrayList.add(d.f409834n);
        if (!z16) {
            this.f409830f.add(d.f409835o);
        }
        if (z17) {
            this.f409830f.add(d.f409836p);
        }
    }

    public int a(d dVar) {
        ArrayList<d> arrayList = this.f409829e;
        if (arrayList != null) {
            return arrayList.indexOf(dVar);
        }
        return -1;
    }

    public d b() {
        return this.f409831h;
    }

    public int c() {
        return this.f409830f.size();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d() {
        boolean z16;
        ArrayList<d> arrayList = this.f409829e;
        if (arrayList != null) {
            d dVar = d.f409836p;
            if (arrayList.contains(dVar)) {
                this.f409829e.remove(dVar);
                this.f409830f.remove(dVar);
                z16 = true;
                if (!z16) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
        z16 = false;
        if (!z16) {
        }
    }

    public void e(ArrayList<d> arrayList) {
        ArrayList<d> arrayList2 = new ArrayList<>();
        this.f409829e = arrayList2;
        if (arrayList != null) {
            arrayList2.addAll(arrayList);
        }
        this.f409829e.addAll(0, this.f409830f);
        int count = getCount();
        this.f409832i.setNumColumns(count);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f409832i.getLayoutParams();
        layoutParams.width = (C * count) + ((count - 1) * D) + this.f409832i.getPaddingLeft() + this.f409832i.getPaddingRight();
        this.f409832i.setLayoutParams(layoutParams);
    }

    public void f(d dVar) {
        this.f409831h = dVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<d> arrayList = this.f409829e;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        ArrayList<d> arrayList = this.f409829e;
        if (arrayList != null) {
            return arrayList.get(i3);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return 0L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:64:0x013b A[Catch: Exception -> 0x017f, TryCatch #0 {Exception -> 0x017f, blocks: (B:50:0x00fe, B:52:0x0106, B:54:0x0111, B:56:0x0117, B:64:0x013b, B:67:0x016b, B:73:0x0135, B:74:0x0175, B:75:0x017a, B:60:0x0121, B:62:0x0127), top: B:49:0x00fe, inners: #1 }] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [android.widget.TextView, android.view.View] */
    /* JADX WARN: Type inference failed for: r6v4 */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        ?? r65;
        Drawable drawable;
        boolean z16;
        byte[] bArr;
        d dVar;
        View view3;
        d dVar2 = (d) getItem(i3);
        View view4 = null;
        if (dVar2 == null) {
            view3 = view;
        } else {
            if (view == null) {
                TextView textView = new TextView(this.f409828d);
                textView.setGravity(17);
                textView.setSingleLine();
                textView.setTextSize(12.0f);
                int i16 = C;
                textView.setLayoutParams(new AbsListView.LayoutParams(i16, i16));
                int i17 = E;
                textView.setPadding(i17, D, i17, 0);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                view2 = textView;
                r65 = view2;
            } else {
                view2 = view;
                r65 = (TextView) view;
            }
            r65.setText(dVar2.f409838b);
            int i18 = dVar2.f409844h;
            if (i18 == 0) {
                r65.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ff6, 0, 0);
                if (dVar2.equals(this.f409831h)) {
                    r65.getCompoundDrawables()[1].setColorFilter(this.f409828d.getResources().getColor(R.color.f157855a34), PorterDuff.Mode.MULTIPLY);
                }
                r65.setTag(null);
            } else if (i18 == 1) {
                r65.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ff9, 0, 0);
                if (dVar2.equals(this.f409831h)) {
                    r65.getCompoundDrawables()[1].setColorFilter(this.f409828d.getResources().getColor(R.color.f157855a34), PorterDuff.Mode.MULTIPLY);
                }
                r65.setTag(null);
            } else if (i18 == 2) {
                r65.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.f161986ff3, 0, 0);
                d dVar3 = this.f409831h;
                if (dVar3 != null && dVar3.f409844h == 2) {
                    r65.getCompoundDrawables()[1].setColorFilter(this.f409828d.getResources().getColor(R.color.f157855a34), PorterDuff.Mode.MULTIPLY);
                }
                r65.setTag(null);
            } else if (i18 == 4) {
                int a16 = (int) al.a(this.f409828d, 36.0f);
                if (dVar2.f409843g > 0) {
                    Drawable drawable2 = this.f409828d.getResources().getDrawable(dVar2.f409843g);
                    drawable2.setBounds(0, 0, a16, a16);
                    r65.setCompoundDrawables(null, drawable2, null, null);
                } else {
                    Resources resources = this.f409828d.getResources();
                    try {
                        String str = dVar2.f409846j;
                        if (!TextUtils.isEmpty(str)) {
                            File file = new File(str);
                            if (file.exists() && file.isFile() && file.length() > 0) {
                                try {
                                    bArr = FileUtils.getByte(file);
                                } catch (Exception e16) {
                                    e16.printStackTrace();
                                }
                                if (bArr != null) {
                                    drawable = Drawable.createFromStream(new ByteArrayInputStream(bArr), "voiceChangeIcon");
                                    if (drawable == null) {
                                        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                                        obtain.mFailedDrawable = resources.getDrawable(R.drawable.apn);
                                        obtain.mLoadingDrawable = resources.getDrawable(R.drawable.apn);
                                        drawable = URLDrawable.getDrawable(file, obtain);
                                        Object[] objArr = new Object[1];
                                        if (("drawable not null: " + drawable) != null) {
                                            z16 = true;
                                        } else {
                                            z16 = false;
                                        }
                                        objArr[0] = Boolean.valueOf(z16);
                                        QLog.e("blessVoiceIcon", 1, objArr);
                                    }
                                }
                                drawable = null;
                                if (drawable == null) {
                                }
                            } else {
                                drawable = resources.getDrawable(R.drawable.apn);
                            }
                        } else {
                            drawable = resources.getDrawable(R.drawable.apn);
                        }
                    } catch (Exception unused) {
                        drawable = resources.getDrawable(R.drawable.apn);
                    }
                    drawable.setBounds(0, 0, a16, a16);
                    r65.setCompoundDrawables(null, drawable, null, null);
                }
                if (dVar2.equals(this.f409831h)) {
                    r65.getCompoundDrawables()[1].setColorFilter(this.f409828d.getResources().getColor(R.color.f157856a35), PorterDuff.Mode.SRC_ATOP);
                }
            } else {
                if (dVar2.equals(this.f409831h)) {
                    r65.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ff5, 0, 0);
                } else {
                    r65.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.f161987ff4, 0, 0);
                }
                r65.setTag(dVar2);
            }
            if (dVar2.equals(this.f409831h)) {
                r65.setTextColor(this.f409828d.getResources().getColor(R.color.f157855a34));
            } else if (dVar2.f409844h == 2 && (dVar = this.f409831h) != null && dVar.f409844h == 2) {
                r65.setTextColor(this.f409828d.getResources().getColor(R.color.f157855a34));
            } else {
                r65.setTextColor(-1);
                r65.getCompoundDrawables()[1].clearColorFilter();
            }
            view4 = view2;
            view3 = view4;
        }
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view4;
    }
}
