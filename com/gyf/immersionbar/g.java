package com.gyf.immersionbar;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;

/* compiled from: P */
/* loaded from: classes2.dex */
class g {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f36043a = false;

        /* renamed from: b, reason: collision with root package name */
        public boolean f36044b = false;

        /* renamed from: c, reason: collision with root package name */
        public NavigationBarType f36045c;

        a() {
        }

        public String toString() {
            return "GestureBean{isGesture=" + this.f36043a + ", checkNavigation=" + this.f36044b + ", type=" + this.f36045c + '}';
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x007a, code lost:
    
        if (android.provider.Settings.Global.getInt(r9, "navigation_bar_gesture_hint", 1) == 1) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x007c, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00da, code lost:
    
        if (android.provider.Settings.Global.getInt(r9, "hide_gesture_line", -1) != 1) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a a(Context context) {
        int i3;
        boolean z16;
        boolean z17;
        a aVar = new a();
        if (context != null && context.getContentResolver() != null) {
            ContentResolver contentResolver = context.getContentResolver();
            NavigationBarType navigationBarType = NavigationBarType.UNKNOWN;
            boolean z18 = false;
            boolean z19 = true;
            if (!OSUtils.isHuaWei() && !OSUtils.isEMUI()) {
                if (!OSUtils.isXiaoMi() && !OSUtils.isMIUI()) {
                    if (!OSUtils.isVivo() && !OSUtils.isFuntouchOrOriginOs()) {
                        if (!OSUtils.isOppo() && !OSUtils.isColorOs()) {
                            if (OSUtils.isSamsung()) {
                                i3 = Settings.Global.getInt(contentResolver, "navigation_bar_gesture_while_hidden", -1);
                                if (i3 != -1) {
                                    if (i3 == 0) {
                                        navigationBarType = NavigationBarType.CLASSIC;
                                    } else if (i3 == 1) {
                                        if (Settings.Global.getInt(contentResolver, "navigation_bar_gesture_detail_type", 1) == 1) {
                                            navigationBarType = NavigationBarType.GESTURES;
                                        } else {
                                            navigationBarType = NavigationBarType.GESTURES_THREE_STAGE;
                                        }
                                    }
                                    z16 = false;
                                    z17 = false;
                                    if (i3 == -1) {
                                    }
                                    z19 = z16;
                                    z18 = z17;
                                    aVar.f36043a = z18;
                                    aVar.f36044b = z19;
                                    aVar.f36045c = navigationBarType;
                                } else {
                                    i3 = Settings.Global.getInt(contentResolver, "navigationbar_hide_bar_enabled", -1);
                                    if (i3 == 0) {
                                        navigationBarType = NavigationBarType.CLASSIC;
                                    } else if (i3 == 1) {
                                        navigationBarType = NavigationBarType.GESTURES;
                                        z16 = false;
                                        z17 = true;
                                        if (i3 == -1) {
                                        }
                                        z19 = z16;
                                        z18 = z17;
                                        aVar.f36043a = z18;
                                        aVar.f36044b = z19;
                                        aVar.f36045c = navigationBarType;
                                    }
                                    z16 = false;
                                    z17 = false;
                                    if (i3 == -1) {
                                    }
                                    z19 = z16;
                                    z18 = z17;
                                    aVar.f36043a = z18;
                                    aVar.f36044b = z19;
                                    aVar.f36045c = navigationBarType;
                                }
                            } else {
                                z16 = false;
                                z17 = false;
                                i3 = -1;
                                if (i3 == -1) {
                                }
                                z19 = z16;
                                z18 = z17;
                                aVar.f36043a = z18;
                                aVar.f36044b = z19;
                                aVar.f36045c = navigationBarType;
                            }
                        } else {
                            i3 = Settings.Secure.getInt(contentResolver, "hide_navigationbar_enable", -1);
                            if (i3 == 0) {
                                navigationBarType = NavigationBarType.CLASSIC;
                            } else if (i3 == 1 || i3 == 2 || i3 == 3) {
                                navigationBarType = NavigationBarType.GESTURES;
                                z16 = false;
                                z17 = true;
                                if (i3 == -1) {
                                }
                                z19 = z16;
                                z18 = z17;
                                aVar.f36043a = z18;
                                aVar.f36044b = z19;
                                aVar.f36045c = navigationBarType;
                            }
                            z16 = false;
                            z17 = false;
                            if (i3 == -1) {
                            }
                            z19 = z16;
                            z18 = z17;
                            aVar.f36043a = z18;
                            aVar.f36044b = z19;
                            aVar.f36045c = navigationBarType;
                        }
                    } else {
                        i3 = Settings.Secure.getInt(contentResolver, "navigation_gesture_on", -1);
                        if (i3 == 0) {
                            navigationBarType = NavigationBarType.CLASSIC;
                        } else {
                            if (i3 == 1) {
                                navigationBarType = NavigationBarType.GESTURES_THREE_STAGE;
                            } else if (i3 == 2) {
                                navigationBarType = NavigationBarType.GESTURES;
                            }
                            z16 = false;
                            z17 = true;
                            if (i3 == -1) {
                            }
                            z19 = z16;
                            z18 = z17;
                            aVar.f36043a = z18;
                            aVar.f36044b = z19;
                            aVar.f36045c = navigationBarType;
                        }
                        z16 = false;
                        z17 = false;
                        if (i3 == -1) {
                        }
                        z19 = z16;
                        z18 = z17;
                        aVar.f36043a = z18;
                        aVar.f36044b = z19;
                        aVar.f36045c = navigationBarType;
                    }
                } else {
                    i3 = Settings.Global.getInt(contentResolver, "force_fsg_nav_bar", -1);
                    if (i3 == 0) {
                        navigationBarType = NavigationBarType.CLASSIC;
                    } else if (i3 == 1) {
                        navigationBarType = NavigationBarType.GESTURES;
                    }
                    z16 = false;
                    z17 = false;
                    if (i3 == -1) {
                    }
                    z19 = z16;
                    z18 = z17;
                    aVar.f36043a = z18;
                    aVar.f36044b = z19;
                    aVar.f36045c = navigationBarType;
                }
            } else {
                if (!OSUtils.isEMUI3_x()) {
                    i3 = Settings.Global.getInt(contentResolver, "navigationbar_is_min", -1);
                } else {
                    i3 = Settings.System.getInt(contentResolver, "navigationbar_is_min", -1);
                }
                if (i3 == 0) {
                    navigationBarType = NavigationBarType.CLASSIC;
                } else if (i3 == 1) {
                    navigationBarType = NavigationBarType.GESTURES;
                    z16 = false;
                    z17 = true;
                    if (i3 == -1) {
                        int i16 = Settings.Secure.getInt(contentResolver, "navigation_mode", -1);
                        if (i16 == 0) {
                            navigationBarType = NavigationBarType.CLASSIC;
                        } else if (i16 == 1) {
                            navigationBarType = NavigationBarType.DOUBLE;
                        } else if (i16 == 2) {
                            navigationBarType = NavigationBarType.GESTURES;
                            z18 = true;
                            aVar.f36043a = z18;
                            aVar.f36044b = z19;
                            aVar.f36045c = navigationBarType;
                        }
                        z19 = z16;
                        aVar.f36043a = z18;
                        aVar.f36044b = z19;
                        aVar.f36045c = navigationBarType;
                    }
                    z19 = z16;
                    z18 = z17;
                    aVar.f36043a = z18;
                    aVar.f36044b = z19;
                    aVar.f36045c = navigationBarType;
                }
                z16 = false;
                z17 = false;
                if (i3 == -1) {
                }
                z19 = z16;
                z18 = z17;
                aVar.f36043a = z18;
                aVar.f36044b = z19;
                aVar.f36045c = navigationBarType;
            }
        }
        return aVar;
    }
}
