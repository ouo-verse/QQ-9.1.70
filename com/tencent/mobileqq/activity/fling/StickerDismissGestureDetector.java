package com.tencent.mobileqq.activity.fling;

import a61.e;
import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.m;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticonview.StickerGrayTipLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class StickerDismissGestureDetector extends GestureDetector {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private TopGestureLayout f182250a;

    /* renamed from: b, reason: collision with root package name */
    private float f182251b;

    /* renamed from: c, reason: collision with root package name */
    private float f182252c;

    /* renamed from: d, reason: collision with root package name */
    private int f182253d;

    /* renamed from: e, reason: collision with root package name */
    private int f182254e;

    /* renamed from: f, reason: collision with root package name */
    private int f182255f;

    /* renamed from: g, reason: collision with root package name */
    private ChatXListView f182256g;
    public boolean isInTowFingerMode;

    public StickerDismissGestureDetector(TopGestureLayout topGestureLayout, Context context, GestureDetector.OnGestureListener onGestureListener) {
        super(context, onGestureListener);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, topGestureLayout, context, onGestureListener);
            return;
        }
        this.isInTowFingerMode = false;
        this.f182253d = 0;
        this.f182254e = 1;
        this.f182250a = topGestureLayout;
    }

    void a(MotionEvent motionEvent, ChatXListView chatXListView) {
        int i3;
        float x16 = motionEvent.getX(this.f182253d) - this.f182251b;
        float x17 = motionEvent.getX(this.f182254e) - this.f182252c;
        this.f182251b = motionEvent.getX(this.f182253d);
        this.f182252c = motionEvent.getX(this.f182254e);
        if (x16 * x17 < 0.0f) {
            if (x16 < 0.0f) {
                i3 = EmojiStickerManager.f204585v;
            } else {
                i3 = EmojiStickerManager.f204586w;
            }
            this.f182255f = i3;
            if (chatXListView != null) {
                for (int childCount = chatXListView.getChildCount() - 1; childCount >= 0; childCount--) {
                    View childAt = chatXListView.getChildAt(childCount);
                    if (childAt instanceof BaseChatItemLayout) {
                        BaseChatItemLayout baseChatItemLayout = (BaseChatItemLayout) childAt;
                        int i16 = this.f182255f;
                        if (i16 == EmojiStickerManager.f204585v) {
                            x16 = Math.min(0.0f, x16);
                            x17 = Math.max(0.0f, x17);
                            baseChatItemLayout.b((int) Math.abs(x16 - x17), this.f182255f);
                        } else if (i16 == EmojiStickerManager.f204586w) {
                            x16 = Math.max(0.0f, x16);
                            x17 = Math.min(0.0f, x17);
                            baseChatItemLayout.b((int) Math.abs(x16 - x17), this.f182255f);
                        }
                    } else if (childAt instanceof LinearLayout) {
                        LinearLayout linearLayout = (LinearLayout) childAt;
                        for (int childCount2 = linearLayout.getChildCount() - 1; childCount2 >= 0; childCount2--) {
                            View childAt2 = linearLayout.getChildAt(childCount2);
                            if (childAt2 instanceof StickerGrayTipLayout) {
                                StickerGrayTipLayout stickerGrayTipLayout = (StickerGrayTipLayout) childAt2;
                                int i17 = this.f182255f;
                                if (i17 == EmojiStickerManager.f204585v) {
                                    x16 = Math.min(0.0f, x16);
                                    x17 = Math.max(0.0f, x17);
                                    stickerGrayTipLayout.doDismiss((int) Math.abs(x16 - x17), this.f182255f);
                                } else if (i17 == EmojiStickerManager.f204586w) {
                                    x16 = Math.max(0.0f, x16);
                                    x17 = Math.min(0.0f, x17);
                                    stickerGrayTipLayout.doDismiss((int) Math.abs(x16 - x17), this.f182255f);
                                }
                            }
                        }
                    }
                }
                return;
            }
            QLog.e(TopGestureLayout.TAG, 1, "caclLeftAndRightOffset but list view is null");
        }
    }

    public boolean checkPttSlide(MotionEvent motionEvent, ChatXListView chatXListView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) motionEvent, (Object) chatXListView)).booleanValue();
        }
        return false;
    }

    @Override // android.view.GestureDetector
    public boolean onTouchEvent(MotionEvent motionEvent) {
        String str;
        View findViewById;
        View findViewById2;
        View findViewById3;
        View findViewById4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (EmojiStickerManager.f204581r && (findViewById4 = this.f182250a.findViewById(R.id.goe)) != null) {
            return findViewById4.onTouchEvent(motionEvent);
        }
        if (EmojiStickerManager.f204580q && (findViewById3 = this.f182250a.findViewById(R.id.gob)) != null) {
            return findViewById3.onTouchEvent(motionEvent);
        }
        int pointerCount = motionEvent.getPointerCount();
        boolean z16 = false;
        if (pointerCount == 2) {
            BaseActivity baseActivity = BaseActivity.sTopActivity;
            if ((baseActivity instanceof BaseActivity) && baseActivity.getChatFragment() != null && (baseActivity.getChatFragment().qh() instanceof e) && EmojiStickerManager.k().f204597h.size() > 0) {
                this.isInTowFingerMode = true;
                int action = motionEvent.getAction() & motionEvent.getActionMasked();
                if (action != 0) {
                    if (action != 1) {
                        if (action != 2) {
                            if (action != 3) {
                                if (action == 5) {
                                    View findViewById5 = this.f182250a.findViewById(R.id.listView1);
                                    if (findViewById5 instanceof ChatXListView) {
                                        this.f182256g = (ChatXListView) findViewById5;
                                    }
                                    if (motionEvent.getX(0) < motionEvent.getX(1)) {
                                        this.f182253d = 0;
                                        this.f182254e = 1;
                                        this.f182251b = motionEvent.getX(0);
                                        this.f182252c = motionEvent.getX(1);
                                    } else {
                                        this.f182253d = 1;
                                        this.f182254e = 0;
                                        this.f182251b = motionEvent.getX(1);
                                        this.f182252c = motionEvent.getX(0);
                                    }
                                }
                            }
                        } else {
                            if (this.f182256g == null && (findViewById2 = this.f182250a.findViewById(R.id.listView1)) != null && (findViewById2 instanceof ChatXListView)) {
                                this.f182256g = (ChatXListView) findViewById2;
                            }
                            a(motionEvent, this.f182256g);
                        }
                    }
                    this.f182256g = null;
                } else {
                    View findViewById6 = this.f182250a.findViewById(R.id.listView1);
                    if (findViewById6 instanceof ChatXListView) {
                        this.f182256g = (ChatXListView) findViewById6;
                    }
                    this.f182251b = motionEvent.getX(0);
                }
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }
        if (pointerCount == 1) {
            if (motionEvent.getAction() == 1) {
                m.f179512b = false;
                if (this.f182256g == null && (findViewById = this.f182250a.findViewById(R.id.listView1)) != null && (findViewById instanceof ChatXListView)) {
                    this.f182256g = (ChatXListView) findViewById;
                }
                ChatXListView chatXListView = this.f182256g;
                if (chatXListView != null) {
                    for (int childCount = chatXListView.getChildCount() - 1; childCount >= 0; childCount--) {
                        View childAt = this.f182256g.getChildAt(childCount);
                        if (childAt instanceof BaseChatItemLayout) {
                            BaseChatItemLayout baseChatItemLayout = (BaseChatItemLayout) childAt;
                            if (!z16) {
                                z16 = baseChatItemLayout.i();
                            }
                            baseChatItemLayout.j();
                        } else if (childAt instanceof LinearLayout) {
                            LinearLayout linearLayout = (LinearLayout) childAt;
                            for (int childCount2 = linearLayout.getChildCount() - 1; childCount2 >= 0; childCount2--) {
                                View childAt2 = linearLayout.getChildAt(childCount2);
                                if (childAt2 instanceof StickerGrayTipLayout) {
                                    StickerGrayTipLayout stickerGrayTipLayout = (StickerGrayTipLayout) childAt2;
                                    if (!z16) {
                                        z16 = stickerGrayTipLayout.haveStickers();
                                    }
                                    stickerGrayTipLayout.startAutoDismiss();
                                }
                            }
                        }
                    }
                    if (z16) {
                        int i3 = EmojiStickerManager.k().f204591b;
                        if (i3 == 1) {
                            str = "2";
                        } else if (i3 == 3000) {
                            str = "3";
                        } else {
                            str = "1";
                        }
                        String str2 = str;
                        if (this.f182255f == EmojiStickerManager.f204585v) {
                            VasWebviewUtil.reportCommercialDrainage("", "Stick", "Hide", str2, 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                        } else {
                            VasWebviewUtil.reportCommercialDrainage("", "Stick", "CancelHide", str2, 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                        }
                    }
                }
                this.f182256g = null;
            } else if (motionEvent.getAction() == 0) {
                this.isInTowFingerMode = false;
                View findViewById7 = this.f182250a.findViewById(R.id.listView1);
                if (findViewById7 == null) {
                    findViewById7 = this.f182250a.findViewById(R.id.listViewHistory);
                }
                if (findViewById7 != null && (findViewById7 instanceof ChatXListView)) {
                    this.f182256g = (ChatXListView) findViewById7;
                }
            } else {
                if (motionEvent.getAction() == 2) {
                    if (!m.f179512b && !m.f179513c) {
                        if (this.f182256g == null) {
                            View findViewById8 = this.f182250a.findViewById(R.id.listView1);
                            if (findViewById8 == null) {
                                findViewById8 = this.f182250a.findViewById(R.id.listViewHistory);
                            }
                            if (findViewById8 != null && (findViewById8 instanceof ChatXListView)) {
                                this.f182256g = (ChatXListView) findViewById8;
                            }
                        }
                        if (checkPttSlide(motionEvent, this.f182256g)) {
                            m.f179512b = true;
                        }
                    }
                    return false;
                }
                if (motionEvent.getAction() == 3) {
                    m.f179512b = false;
                    this.f182256g = null;
                } else {
                    m.f179512b = false;
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }
}
