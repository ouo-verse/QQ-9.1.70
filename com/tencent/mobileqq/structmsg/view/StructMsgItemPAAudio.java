package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.v;
import com.tencent.mobileqq.activity.photo.MediaDBValues;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.api.IPttTransProcessorHelper;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.ref.WeakReference;
import localpb.richMsg.RichMsg$PttRec;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: classes18.dex */
public class StructMsgItemPAAudio extends AbsStructMsgElement implements com.tencent.mobileqq.activity.aio.r {
    static IPatchRedirector $redirector_;
    public String R0;
    int S0;
    int T0;
    String U0;
    String V0;
    int W0;
    String X0;
    QQAppInterface Y0;
    ImageView Z0;

    /* renamed from: a1, reason: collision with root package name */
    ImageView f290465a1;

    /* renamed from: b1, reason: collision with root package name */
    boolean f290466b1;

    /* renamed from: c1, reason: collision with root package name */
    ViewGroup f290467c1;

    /* renamed from: d1, reason: collision with root package name */
    MediaPlayerManager f290468d1;

    /* renamed from: e1, reason: collision with root package name */
    String f290469e1;

    /* renamed from: f1, reason: collision with root package name */
    View.OnClickListener f290470f1;

    /* renamed from: g1, reason: collision with root package name */
    URLDrawableDownListener.Adapter f290471g1;

    /* loaded from: classes18.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StructMsgItemPAAudio.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (!TextUtils.isEmpty(StructMsgItemPAAudio.this.f290469e1)) {
                try {
                    IPttTransProcessorHelper iPttTransProcessorHelper = (IPttTransProcessorHelper) QRoute.api(IPttTransProcessorHelper.class);
                    StructMsgItemPAAudio structMsgItemPAAudio = StructMsgItemPAAudio.this;
                    String pAAudioPttPath = iPttTransProcessorHelper.getPAAudioPttPath(structMsgItemPAAudio.Y0, structMsgItemPAAudio.X0);
                    if (TextUtils.isEmpty(pAAudioPttPath)) {
                        StructMsgItemPAAudio.this.q();
                        StructMsgItemPAAudio structMsgItemPAAudio2 = StructMsgItemPAAudio.this;
                        structMsgItemPAAudio2.m(structMsgItemPAAudio2.f290469e1, view);
                    } else if (new File(pAAudioPttPath).exists()) {
                        StructMsgItemPAAudio structMsgItemPAAudio3 = StructMsgItemPAAudio.this;
                        if (structMsgItemPAAudio3.f290466b1) {
                            structMsgItemPAAudio3.r();
                        } else {
                            structMsgItemPAAudio3.o();
                        }
                    } else {
                        StructMsgItemPAAudio.this.q();
                        StructMsgItemPAAudio structMsgItemPAAudio4 = StructMsgItemPAAudio.this;
                        structMsgItemPAAudio4.m(structMsgItemPAAudio4.f290469e1, view);
                    }
                    StructMsgItemPAAudio structMsgItemPAAudio5 = StructMsgItemPAAudio.this;
                    QQAppInterface qQAppInterface = structMsgItemPAAudio5.Y0;
                    String str = structMsgItemPAAudio5.f290469e1;
                    String currentAccountUin = qQAppInterface.getCurrentAccountUin();
                    StructMsgItemPAAudio structMsgItemPAAudio6 = StructMsgItemPAAudio.this;
                    ReportController.n(qQAppInterface, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005C9B", "0X8005C9B", 0, 1, 0, str, currentAccountUin, structMsgItemPAAudio6.V0, structMsgItemPAAudio6.X0);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes18.dex */
    class b extends URLDrawableDownListener.Adapter {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StructMsgItemPAAudio.this);
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener.Adapter, com.tencent.image.URLDrawableDownListener
        public void onLoadCancelled(View view, URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) uRLDrawable);
            } else {
                super.onLoadCancelled(view, uRLDrawable);
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener.Adapter, com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(View view, URLDrawable uRLDrawable, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, view, uRLDrawable, th5);
            } else {
                super.onLoadFailed(view, uRLDrawable, th5);
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener.Adapter, com.tencent.image.URLDrawableDownListener
        public void onLoadInterrupted(View view, URLDrawable uRLDrawable, InterruptedException interruptedException) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, view, uRLDrawable, interruptedException);
            } else {
                super.onLoadInterrupted(view, uRLDrawable, interruptedException);
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener.Adapter, com.tencent.image.URLDrawableDownListener
        public void onLoadSuccessed(View view, URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, (Object) uRLDrawable);
            } else {
                view.setBackgroundDrawable(uRLDrawable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StructMsgItemPAAudio.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* loaded from: classes18.dex */
    public static class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f290477a;

        /* renamed from: b, reason: collision with root package name */
        public View f290478b;

        /* renamed from: c, reason: collision with root package name */
        public View f290479c;

        /* renamed from: d, reason: collision with root package name */
        public View f290480d;

        /* renamed from: e, reason: collision with root package name */
        public View f290481e;

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public StructMsgItemPAAudio() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f290466b1 = false;
        this.f290470f1 = new a();
        this.f290471g1 = new b();
        this.f290322e = "paaudio";
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public View c(Context context, View view, Bundle bundle) {
        d dVar;
        Drawable drawable;
        boolean z16;
        View view2;
        Drawable drawable2;
        boolean z17;
        View view3 = view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, this, context, view, bundle);
        }
        boolean z18 = bundle.getBoolean("isSubscript", false);
        QQAppInterface qQAppInterface = ((BaseActivity) context).app;
        this.Y0 = qQAppInterface;
        this.f290468d1 = (MediaPlayerManager) qQAppInterface.getManager(QQManagerFactory.MGR_MEDIA_PLAYER);
        Resources resources = context.getResources();
        if (view3 != null && (view.getTag() instanceof d)) {
            dVar = (d) view.getTag();
            dVar.f290480d.clearAnimation();
            ((TextView) dVar.f290481e).setText(String.valueOf(this.T0) + "''");
            try {
                drawable2 = resources.getDrawable(R.drawable.d86);
            } catch (OutOfMemoryError unused) {
                drawable2 = null;
            }
            if (TextUtils.isEmpty(this.R0)) {
                ((AnyScaleTypeImageView) dVar.f290478b).setBackgroundDrawable(drawable2);
            } else {
                int i3 = resources.getDisplayMetrics().widthPixels;
                URLDrawable drawable3 = URLDrawable.getDrawable(this.R0, i3, i3, drawable2, drawable2);
                if (!AbsDownloader.hasFile(this.R0) && URLDrawableHelper.isMobileNetAndAutodownDisabled(context)) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (drawable3 != null) {
                    drawable3.setAutoDownload(z17);
                }
                if (drawable3 != null && drawable3.getStatus() == 1) {
                    ((AnyScaleTypeImageView) dVar.f290478b).setBackgroundDrawable(null);
                } else {
                    ((AnyScaleTypeImageView) dVar.f290478b).setURLDrawableDownListener(this.f290471g1);
                    dVar.f290478b.setBackgroundColor(15790320);
                }
                ((AnyScaleTypeImageView) dVar.f290478b).setBackgroundDrawable(drawable3);
            }
            if (!TextUtils.isEmpty(this.R0)) {
                View findViewById = view3.findViewById(97);
                view2 = view3;
                if (findViewById == null) {
                    View view4 = new View(context);
                    view4.setId(97);
                    if (z18) {
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) ((BaseChatItemLayout.J / 2.4d) * 0.69d));
                        layoutParams.addRule(12, -1);
                        view4.setBackgroundResource(R.drawable.f161244t9);
                        ((RelativeLayout) view3).addView(view4, layoutParams);
                        view2 = view3;
                    } else {
                        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                        view4.setBackgroundColor(Color.parseColor("#1A000000"));
                        ((RelativeLayout) view3).addView(view4, layoutParams2);
                        view2 = view3;
                    }
                }
            } else {
                View findViewById2 = view3.findViewById(97);
                view2 = view3;
                if (findViewById2 != null) {
                    ((RelativeLayout) view3).removeView(findViewById2);
                    view2 = view3;
                }
            }
        } else {
            dVar = new d();
            RelativeLayout relativeLayout = new RelativeLayout(context);
            AnyScaleTypeImageView anyScaleTypeImageView = new AnyScaleTypeImageView(context);
            dVar.f290478b = anyScaleTypeImageView;
            anyScaleTypeImageView.setContentDescription(resources.getString(R.string.cli));
            ((AnyScaleTypeImageView) dVar.f290478b).setDisplayRuleDef(com.tencent.mobileqq.widget.e.f316872a);
            ((AnyScaleTypeImageView) dVar.f290478b).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            try {
                drawable = resources.getDrawable(R.drawable.d86);
            } catch (OutOfMemoryError unused2) {
                drawable = null;
            }
            if (TextUtils.isEmpty(this.R0)) {
                ((AnyScaleTypeImageView) dVar.f290478b).setBackgroundDrawable(drawable);
            } else {
                int i16 = resources.getDisplayMetrics().widthPixels;
                URLDrawable drawable4 = URLDrawable.getDrawable(this.R0, i16, i16, drawable, drawable);
                if (!AbsDownloader.hasFile(this.R0) && URLDrawableHelper.isMobileNetAndAutodownDisabled(context)) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (drawable4 != null) {
                    drawable4.setAutoDownload(z16);
                }
                if (drawable4 != null && drawable4.getStatus() == 1) {
                    ((AnyScaleTypeImageView) dVar.f290478b).setBackgroundDrawable(null);
                } else {
                    ((AnyScaleTypeImageView) dVar.f290478b).setURLDrawableDownListener(this.f290471g1);
                    dVar.f290478b.setBackgroundColor(15790320);
                }
                ((AnyScaleTypeImageView) dVar.f290478b).setBackgroundDrawable(drawable4);
            }
            ImageView imageView = new ImageView(context);
            dVar.f290479c = imageView;
            imageView.setId(99);
            dVar.f290479c.setBackgroundResource(R.drawable.d8a);
            ImageView imageView2 = new ImageView(context);
            dVar.f290480d = imageView2;
            imageView2.setId(98);
            dVar.f290480d.setBackgroundResource(R.drawable.d8w);
            TextView textView = new TextView(context);
            dVar.f290481e = textView;
            textView.setText(String.valueOf(this.T0) + "'");
            ((TextView) dVar.f290481e).setTextSize(20.0f);
            ((TextView) dVar.f290481e).setTextColor(-1);
            relativeLayout.addView(dVar.f290478b, new RelativeLayout.LayoutParams(-1, -1));
            if (!TextUtils.isEmpty(this.R0)) {
                View view5 = new View(context);
                view5.setId(97);
                if (z18) {
                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) ((BaseChatItemLayout.J / 2.4d) * 0.69d));
                    layoutParams3.addRule(12, -1);
                    view5.setBackgroundResource(R.drawable.f161244t9);
                    relativeLayout.addView(view5, layoutParams3);
                } else {
                    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
                    view5.setBackgroundColor(Color.parseColor("#1A000000"));
                    relativeLayout.addView(view5, layoutParams4);
                }
            }
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(BaseAIOUtils.f(12.0f, resources), BaseAIOUtils.f(20.0f, resources));
            layoutParams5.addRule(9, -1);
            layoutParams5.setMargins(BaseAIOUtils.f(20.0f, resources), 0, 0, 0);
            layoutParams5.addRule(15, -1);
            relativeLayout.addView(dVar.f290479c, layoutParams5);
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(BaseAIOUtils.f(14.0f, resources), BaseAIOUtils.f(20.0f, resources));
            layoutParams6.setMargins(BaseAIOUtils.f(5.0f, resources), 0, 0, 0);
            layoutParams6.addRule(15, -1);
            layoutParams6.addRule(1, dVar.f290479c.getId());
            relativeLayout.addView(dVar.f290480d, layoutParams6);
            RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams7.setMargins(BaseAIOUtils.f(15.0f, resources), 0, 0, 0);
            layoutParams7.addRule(15, -1);
            layoutParams7.addRule(1, dVar.f290480d.getId());
            relativeLayout.addView(dVar.f290481e, layoutParams7);
            view2 = relativeLayout;
        }
        view2.post(new Runnable(view2, dVar) { // from class: com.tencent.mobileqq.structmsg.view.StructMsgItemPAAudio.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ View f290472d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ d f290473e;

            {
                this.f290472d = view2;
                this.f290473e = dVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, StructMsgItemPAAudio.this, view2, dVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                StructMsgForGeneralShare structMsgForGeneralShare;
                v.a aVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                ViewParent parent = this.f290472d.getParent();
                while (parent != null && (parent instanceof ViewGroup)) {
                    ViewGroup viewGroup = (ViewGroup) parent;
                    if (viewGroup.getId() == R.id.j59) {
                        structMsgForGeneralShare = (StructMsgForGeneralShare) viewGroup.getTag(R.id.j59);
                        break;
                    }
                    parent = viewGroup.getParent();
                }
                structMsgForGeneralShare = null;
                if (structMsgForGeneralShare == null) {
                    return;
                }
                ViewGroup viewGroup2 = (ViewGroup) parent;
                StructMsgItemPAAudio.this.f290467c1 = viewGroup2;
                if (viewGroup2 == null || (aVar = (v.a) com.tencent.mobileqq.activity.aio.l.A(viewGroup2)) == null) {
                    return;
                }
                long j3 = aVar.f180131a.uniseq;
                StructMsgItemPAAudio structMsgItemPAAudio = StructMsgItemPAAudio.this;
                structMsgItemPAAudio.f290469e1 = structMsgForGeneralShare.uin;
                structMsgItemPAAudio.f290466b1 = structMsgItemPAAudio.n(j3);
                if (!StructMsgItemPAAudio.this.f290466b1) {
                    this.f290473e.f290480d.setBackgroundResource(R.drawable.d8w);
                } else {
                    this.f290473e.f290480d.setBackgroundResource(R.anim.f154802cu);
                    ((AnimationDrawable) this.f290473e.f290480d.getBackground()).start();
                }
            }
        });
        dVar.f290477a = ((IPttTransProcessorHelper) QRoute.api(IPttTransProcessorHelper.class)).getPAAudioPttPath(this.Y0, this.X0);
        view2.setTag(dVar);
        this.Z0 = (ImageView) dVar.f290479c;
        this.f290465a1 = (ImageView) dVar.f290480d;
        WeakReference<com.tencent.mobileqq.activity.aio.an> weakReference = this.O0;
        if (weakReference != null) {
            view2.setOnLongClickListener(weakReference.get());
            view2.setOnTouchListener(this.O0.get());
        }
        view2.setOnClickListener(this.f290470f1);
        return view2;
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public boolean d(com.tencent.mobileqq.structmsg.j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) jVar)).booleanValue();
        }
        if (jVar == null) {
            return true;
        }
        this.R0 = jVar.a("cover");
        this.S0 = Integer.parseInt(jVar.a("busitype"));
        this.T0 = Integer.parseInt(jVar.a("duration"));
        this.U0 = jVar.a("md5");
        this.V0 = jVar.a("filename");
        this.W0 = Integer.parseInt(jVar.a(MediaDBValues.FILESIZE));
        this.X0 = jVar.a("uuid");
        return true;
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return "paaudio";
    }

    @Override // com.tencent.mobileqq.activity.aio.r
    public void handleMessage(View view, FileMsg fileMsg, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, view, fileMsg, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (fileMsg.fileType == 33 && i3 != 2002 && i3 != 2001 && i3 == 2003 && this.Y0 != null) {
            p();
            o();
        }
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void i(ObjectInput objectInput) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) objectInput);
            return;
        }
        super.i(objectInput);
        this.R0 = objectInput.readUTF();
        this.S0 = objectInput.readInt();
        this.T0 = objectInput.readInt();
        this.U0 = objectInput.readUTF();
        this.V0 = objectInput.readUTF();
        this.W0 = objectInput.readInt();
        this.X0 = objectInput.readUTF();
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void k(XmlSerializer xmlSerializer) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) xmlSerializer);
            return;
        }
        xmlSerializer.startTag(null, "paaudio");
        xmlSerializer.attribute(null, "cover", this.R0);
        xmlSerializer.attribute(null, "busitype", String.valueOf(this.S0));
        xmlSerializer.attribute(null, "duration", String.valueOf(this.T0));
        xmlSerializer.attribute(null, "md5", this.U0);
        xmlSerializer.attribute(null, "filename", this.V0);
        xmlSerializer.attribute(null, MediaDBValues.FILESIZE, String.valueOf(this.W0));
        xmlSerializer.attribute(null, "uuid", this.X0);
        xmlSerializer.endTag(null, "paaudio");
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void l(ObjectOutput objectOutput) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) objectOutput);
            return;
        }
        super.l(objectOutput);
        objectOutput.writeUTF(this.R0);
        objectOutput.writeInt(this.S0);
        objectOutput.writeInt(this.T0);
        String str = this.U0;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        objectOutput.writeUTF(str);
        String str3 = this.V0;
        if (str3 == null) {
            str3 = "";
        }
        objectOutput.writeUTF(str3);
        objectOutput.writeInt(this.W0);
        String str4 = this.X0;
        if (str4 != null) {
            str2 = str4;
        }
        objectOutput.writeUTF(str2);
    }

    void m(String str, View view) {
        boolean z16;
        if (com.tencent.mobileqq.managers.b.b().e()) {
            Context context = view.getContext();
            DialogUtil.createCustomDialog(context, 232, null, context.getString(R.string.b3j), new c(), null).show();
            p();
            return;
        }
        com.tencent.mobileqq.activity.aio.y.d(this.Y0).a(view, this);
        RichMsg$PttRec richMsg$PttRec = new RichMsg$PttRec();
        richMsg$PttRec.localPath.set(this.X0);
        richMsg$PttRec.size.set(this.W0);
        richMsg$PttRec.type.set(2);
        richMsg$PttRec.uuid.set(this.X0);
        richMsg$PttRec.isRead.set(false);
        richMsg$PttRec.serverStorageSource.set("pttcenter");
        richMsg$PttRec.isReport.set(0);
        richMsg$PttRec.version.set(5);
        richMsg$PttRec.pttFlag.set(0);
        richMsg$PttRec.longPttVipFlag.set(0);
        richMsg$PttRec.msgRecTime.set(System.currentTimeMillis() / 1000);
        richMsg$PttRec.msgTime.set(0L);
        richMsg$PttRec.voiceChangeFlag.set(0);
        richMsg$PttRec.busiType.set(this.S0);
        MessageRecord d16 = com.tencent.mobileqq.service.message.q.d(-2002);
        d16.frienduin = str;
        d16.istroop = 1008;
        d16.msgData = richMsg$PttRec.toByteArray();
        ((MessageForPtt) d16).doParse();
        try {
            TransferRequest transferRequest = new TransferRequest();
            transferRequest.mSelfUin = this.Y0.getAccount();
            transferRequest.mPeerUin = str;
            transferRequest.mUinType = 1008;
            transferRequest.mFileType = 33;
            transferRequest.mUniseq = d16.uniseq;
            transferRequest.mIsUp = false;
            transferRequest.mServerPath = ((MessageForPtt) d16).urlAtServer;
            transferRequest.mOutFilePath = ((MessageForPtt) d16).getLocalFilePath();
            if (!d16.isSendFromOtherTerminal() && !d16.isSend()) {
                z16 = false;
                transferRequest.mIsSelfSend = z16;
                transferRequest.mMd5 = ((MessageForPtt) d16).md5;
                transferRequest.mGroupFileID = ((MessageForPtt) d16).groupFileID;
                transferRequest.mGroupFileKeyStr = ((MessageForPtt) d16).groupFileKeyStr;
                transferRequest.mDbRecVersion = ((MessageForPtt) d16).subVersion;
                transferRequest.mRec = d16;
                transferRequest.mExtraObj = new TransferRequest.PttDownExtraInfo(1, 0);
                ((ITransFileController) this.Y0.getRuntimeService(ITransFileController.class)).transferAsync(transferRequest);
            }
            z16 = true;
            transferRequest.mIsSelfSend = z16;
            transferRequest.mMd5 = ((MessageForPtt) d16).md5;
            transferRequest.mGroupFileID = ((MessageForPtt) d16).groupFileID;
            transferRequest.mGroupFileKeyStr = ((MessageForPtt) d16).groupFileKeyStr;
            transferRequest.mDbRecVersion = ((MessageForPtt) d16).subVersion;
            transferRequest.mRec = d16;
            transferRequest.mExtraObj = new TransferRequest.PttDownExtraInfo(1, 0);
            ((ITransFileController) this.Y0.getRuntimeService(ITransFileController.class)).transferAsync(transferRequest);
        } catch (Exception e16) {
            QLog.d("structmsg.StructMsgItemPAAudio", 2, e16.getMessage());
        }
    }

    boolean n(long j3) {
        ChatMessage s16 = this.f290468d1.s();
        if (s16 == null || s16.uniseq != j3) {
            return false;
        }
        return true;
    }

    public void o() {
        ViewGroup viewGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.f290466b1 || (viewGroup = this.f290467c1) == null) {
            return;
        }
        this.f290466b1 = true;
        this.f290468d1.x(((v.a) com.tencent.mobileqq.activity.aio.l.A(viewGroup)).f180131a);
        this.f290465a1.clearAnimation();
        this.f290465a1.setBackgroundResource(R.anim.f154802cu);
        ((AnimationDrawable) this.f290465a1.getBackground()).start();
    }

    void p() {
        this.Z0.clearAnimation();
        this.Z0.setBackgroundResource(R.drawable.d8a);
        if (this.f290466b1) {
            this.f290465a1.setBackgroundResource(R.anim.f154802cu);
            ((AnimationDrawable) this.f290465a1.getBackground()).start();
        } else {
            this.f290465a1.clearAnimation();
            this.f290465a1.setBackgroundResource(R.drawable.d8w);
        }
    }

    void q() {
        this.Z0.setBackgroundResource(R.anim.f154801ct);
        ((AnimationDrawable) this.Z0.getBackground()).start();
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (!this.f290466b1 || this.f290467c1 == null) {
            return;
        }
        this.f290466b1 = false;
        MediaPlayerManager mediaPlayerManager = (MediaPlayerManager) this.Y0.getManager(QQManagerFactory.MGR_MEDIA_PLAYER);
        if (((v.a) com.tencent.mobileqq.activity.aio.l.A(this.f290467c1)).f180131a.equals(mediaPlayerManager.s())) {
            mediaPlayerManager.D(false);
        }
        this.f290465a1.clearAnimation();
        this.f290465a1.setBackgroundResource(R.drawable.d8w);
    }
}
