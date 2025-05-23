package com.tencent.mobileqq.qqperftool.crash;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qzone.util.QZoneAppCtrlUploadFileLogic;

/* compiled from: P */
/* loaded from: classes17.dex */
public class l {
    static IPatchRedirector $redirector_;

    public static String a(int i3, int i16) {
        if (i3 != 4) {
            if (i3 != 5) {
                if (i3 != 7) {
                    if (i3 != 8) {
                        if (i3 != 11) {
                            if (i3 == 31 && i16 == 1) {
                                return "SYS_SECCOMP";
                            }
                        } else {
                            switch (i16) {
                                case 1:
                                    return "SEGV_MAPERR";
                                case 2:
                                    return "SEGV_ACCERR";
                                case 3:
                                    return "SEGV_BNDERR";
                                case 4:
                                    return "SEGV_PKUERR";
                                case 5:
                                    return "SEGV_ACCADI";
                                case 6:
                                    return "SEGV_ADIDERR";
                                case 7:
                                    return "SEGV_ADIPERR";
                            }
                        }
                    } else {
                        switch (i16) {
                            case 1:
                                return "FPE_INTDIV";
                            case 2:
                                return "FPE_INTOVF";
                            case 3:
                                return "FPE_FLTDIV";
                            case 4:
                                return "FPE_FLTOVF";
                            case 5:
                                return "FPE_FLTUND";
                            case 6:
                                return "FPE_FLTRES";
                            case 7:
                                return "FPE_FLTINV";
                            case 8:
                                return "FPE_FLTSUB";
                        }
                    }
                } else if (i16 != 1) {
                    if (i16 != 2) {
                        if (i16 != 3) {
                            if (i16 != 4) {
                                if (i16 == 5) {
                                    return "BUS_MCEERR_AO";
                                }
                            } else {
                                return "BUS_MCEERR_AR";
                            }
                        } else {
                            return "BUS_OBJERR";
                        }
                    } else {
                        return "BUS_ADRERR";
                    }
                } else {
                    return "BUS_ADRALN";
                }
            } else if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != 3) {
                        if (i16 != 4) {
                            if (i16 == 5) {
                                return "TRAP_UNK";
                            }
                        } else {
                            return "TRAP_HWBKPT";
                        }
                    } else {
                        return "TRAP_BRANCH";
                    }
                } else {
                    return "TRAP_TRACE";
                }
            } else {
                return "TRAP_BRKPT";
            }
        } else {
            switch (i16) {
                case 1:
                    return "ILL_ILLOPC";
                case 2:
                    return "ILL_ILLOPN";
                case 3:
                    return "ILL_ILLADR";
                case 4:
                    return "ILL_ILLTRP";
                case 5:
                    return "ILL_PRVOPC";
                case 6:
                    return "ILL_PRVREG";
                case 7:
                    return "ILL_COPROC";
                case 8:
                    return "ILL_BADSTK";
                case 9:
                    return "ILL_BADIADDR";
            }
        }
        if (i16 != -60) {
            if (i16 != 128) {
                switch (i16) {
                    case -7:
                        return "SI_DETHREAD";
                    case -6:
                        return "SI_TKILL";
                    case -5:
                        return "SI_SIGIO";
                    case -4:
                        return "SI_ASYNCIO";
                    case -3:
                        return "SI_MESGQ";
                    case -2:
                        return "SI_TIMER";
                    case -1:
                        return "SI_QUEUE";
                    case 0:
                        return "SI_USER";
                    default:
                        return "UNKNOW_CODE_" + i16;
                }
            }
            return "SI_KERNEL";
        }
        return "SI_ASYNCNL";
    }

    public static String b(int i3) {
        if (i3 != 11) {
            if (i3 != 16) {
                if (i3 != 31) {
                    switch (i3) {
                        case 3:
                            return QZoneAppCtrlUploadFileLogic.ANR_PATH;
                        case 4:
                            return "SIGILL";
                        case 5:
                            return "SIGTRAP";
                        case 6:
                            return "SIGABRT";
                        case 7:
                            return "SIGBUS";
                        case 8:
                            return "SIGFPE";
                        case 9:
                            return "SIGKILL";
                        default:
                            return "UNKNOW_NUMBER_" + i3;
                    }
                }
                return "SIGSYS";
            }
            return "SIGSTKFLT";
        }
        return "SIGSEGV";
    }
}
