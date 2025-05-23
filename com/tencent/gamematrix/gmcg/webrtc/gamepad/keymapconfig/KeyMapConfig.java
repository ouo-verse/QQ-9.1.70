package com.tencent.gamematrix.gmcg.webrtc.gamepad.keymapconfig;

import android.graphics.PointF;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.KeyHandler;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.MoveItem;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.keymapconfig.TVKeyMapMsg;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class KeyMapConfig {
    private List<KeyMapSceneConfig> mChooseWindowSceneConfigs;
    private List<KeyMapSceneConfig> mCombinationSceneConfigs;
    private List<KeyMapSceneConfig> mGamepadSceneConfigs;
    private List<KeyMapSceneConfig> mMFGamepadSceneConfigs;
    private List<KeyMapSceneConfig> mTVControllerSceneConfigs;
    private int mGamepadSceneIndex = 0;
    private int mMFGamepadSceneIndex = 0;
    private int mTVControllerSceneIndex = 0;
    private int mChooseWindowSceneIndex = 0;
    private int mCombinationSceneIndex = 0;
    private KeyMapSceneConfig mLastGamepadSceneConfig = null;
    private KeyMapSceneConfig mLastMFGamepadSceneConfig = null;
    private KeyMapSceneConfig mLastTVControllerSceneConfig = null;
    private KeyMapSceneConfig mLastChooseWindowSceneConfig = null;
    private KeyMapSceneConfig mLastCombinationSceneConfig = null;

    public KeyMapConfig() {
        if (this.mMFGamepadSceneConfigs == null) {
            this.mMFGamepadSceneConfigs = new ArrayList();
        }
        if (this.mGamepadSceneConfigs == null) {
            this.mGamepadSceneConfigs = new ArrayList();
        }
        if (this.mTVControllerSceneConfigs == null) {
            this.mTVControllerSceneConfigs = new ArrayList();
        }
        if (this.mChooseWindowSceneConfigs == null) {
            this.mChooseWindowSceneConfigs = new ArrayList();
        }
        if (this.mCombinationSceneConfigs == null) {
            this.mCombinationSceneConfigs = new ArrayList();
        }
    }

    private boolean loadConfig4ChooseField(KeyMapSceneConfig keyMapSceneConfig, List<TVKeyMapMsg.TVMsgKeyConfig4Choose> list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            TVKeyMapMsg.TVMsgKeyConfig4Choose tVMsgKeyConfig4Choose = list.get(i3);
            if (tVMsgKeyConfig4Choose != null) {
                KeyChooseWindowItem keyChooseWindowItem = new KeyChooseWindowItem();
                keyChooseWindowItem.setId(tVMsgKeyConfig4Choose.f108159id);
                keyChooseWindowItem.setName(tVMsgKeyConfig4Choose.name);
                keyChooseWindowItem.setDesc(tVMsgKeyConfig4Choose.desc);
                keyChooseWindowItem.setUp(tVMsgKeyConfig4Choose.f108160up);
                keyChooseWindowItem.setDown(tVMsgKeyConfig4Choose.down);
                keyChooseWindowItem.setLeft(tVMsgKeyConfig4Choose.left);
                keyChooseWindowItem.setRight(tVMsgKeyConfig4Choose.right);
                keyChooseWindowItem.setX(tVMsgKeyConfig4Choose.f108161x);
                keyChooseWindowItem.setY(tVMsgKeyConfig4Choose.f108162y);
                keyChooseWindowItem.setWidth(tVMsgKeyConfig4Choose.width);
                keyChooseWindowItem.setHeight(tVMsgKeyConfig4Choose.height);
                keyChooseWindowItem.setKeyCodes(tVMsgKeyConfig4Choose.key_codes);
                keyChooseWindowItem.setConfirm(tVMsgKeyConfig4Choose.confirm);
                keyChooseWindowItem.setPoint_x(tVMsgKeyConfig4Choose.percent_x);
                keyChooseWindowItem.setPoint_y(tVMsgKeyConfig4Choose.percent_y);
                keyChooseWindowItem.setSelect(tVMsgKeyConfig4Choose.select);
                keyChooseWindowItem.setIsSwitchShow(tVMsgKeyConfig4Choose.is_switch_show);
                if (tVMsgKeyConfig4Choose.is_switch_show) {
                    keyChooseWindowItem.setIsHide(true);
                }
                keyMapSceneConfig.addChooseWindowItem(keyChooseWindowItem);
            }
        }
        return true;
    }

    private boolean loadConfigField(KeyMapSceneConfig keyMapSceneConfig, List<TVKeyMapMsg.TVMsgKeyConfig> list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            TVKeyMapMsg.TVMsgKeyConfig tVMsgKeyConfig = list.get(i3);
            if (tVMsgKeyConfig != null) {
                switch (tVMsgKeyConfig.type) {
                    case 1:
                    case 2:
                    case 5:
                    case 6:
                        KeyMapJoyPadItem keyMapJoyPadItem = new KeyMapJoyPadItem();
                        keyMapJoyPadItem.setValid(true);
                        keyMapJoyPadItem.setShowRadius(tVMsgKeyConfig.is_show);
                        keyMapJoyPadItem.setPercentX(tVMsgKeyConfig.percent_x);
                        keyMapJoyPadItem.setPercentY(tVMsgKeyConfig.percent_y);
                        keyMapJoyPadItem.setSensitivity(tVMsgKeyConfig.sensitivity);
                        keyMapJoyPadItem.setRadius(tVMsgKeyConfig.radius);
                        keyMapJoyPadItem.setType(tVMsgKeyConfig.type);
                        keyMapSceneConfig.addJoyPadItem(keyMapJoyPadItem);
                        break;
                    case 3:
                        break;
                    case 4:
                    case 7:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                        KeyMapKeyItem keyMapKeyItem = new KeyMapKeyItem();
                        keyMapKeyItem.setType(tVMsgKeyConfig.type);
                        keyMapKeyItem.setKeyName(tVMsgKeyConfig.key_name);
                        keyMapKeyItem.setKeyCodes(tVMsgKeyConfig.key_codes);
                        keyMapKeyItem.setValid(tVMsgKeyConfig.is_show);
                        keyMapKeyItem.setPercentX(tVMsgKeyConfig.percent_x);
                        keyMapKeyItem.setPercentY(tVMsgKeyConfig.percent_y);
                        keyMapKeyItem.setPath(tVMsgKeyConfig.path);
                        keyMapKeyItem.setSensitivity(tVMsgKeyConfig.sensitivity);
                        keyMapSceneConfig.addKeyItem(keyMapKeyItem);
                        break;
                    case 8:
                        KeyMapKeyItem keyMapKeyItem2 = new KeyMapKeyItem();
                        keyMapKeyItem2.setType(tVMsgKeyConfig.type);
                        keyMapKeyItem2.setKeyName(tVMsgKeyConfig.key_name);
                        keyMapKeyItem2.setKeyCodes(tVMsgKeyConfig.key_codes);
                        keyMapKeyItem2.setValid(tVMsgKeyConfig.is_show);
                        keyMapKeyItem2.setPercentX(tVMsgKeyConfig.percent_x);
                        keyMapKeyItem2.setPercentY(tVMsgKeyConfig.percent_y);
                        keyMapKeyItem2.setSensitivity(tVMsgKeyConfig.sensitivity);
                        keyMapSceneConfig.addTouchButtonItem(keyMapKeyItem2);
                        break;
                    case 9:
                    default:
                        CGLog.e("keymap config " + i3 + " unknown item type!");
                        break;
                }
            } else {
                CGLog.e("keymap config " + i3 + " item is null object!");
            }
        }
        return true;
    }

    private boolean loadJoyMoveField(KeyMapSceneConfig keyMapSceneConfig, List<TVKeyMapMsg.TVMsgMoveKeyItem> list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            TVKeyMapMsg.TVMsgMoveKeyItem tVMsgMoveKeyItem = list.get(i3);
            if (tVMsgMoveKeyItem != null && tVMsgMoveKeyItem.type == 9) {
                MoveItem moveItem = new MoveItem();
                moveItem.setType(tVMsgMoveKeyItem.type);
                moveItem.setKeyCode(tVMsgMoveKeyItem.key_code);
                moveItem.setKeyName(tVMsgMoveKeyItem.key_name);
                moveItem.setValid(tVMsgMoveKeyItem.is_valid);
                moveItem.setPercentX(tVMsgMoveKeyItem.percent_x);
                moveItem.setPercentY(tVMsgMoveKeyItem.percent_y);
                moveItem.setMoveDirection(tVMsgMoveKeyItem.move_direction);
                keyMapSceneConfig.addMoveItem(moveItem);
            }
        }
        return true;
    }

    private boolean parseSceneConfig(List<TVKeyMapMsg.TVMsgSceneConfig> list) {
        List<KeyMapSceneConfig> list2;
        List<KeyMapSceneConfig> list3;
        List<KeyMapSceneConfig> list4;
        List<KeyMapSceneConfig> list5;
        List<KeyMapSceneConfig> list6;
        List<PointF> list7;
        boolean z16 = false;
        int i3 = -100;
        for (int i16 = 0; i16 < list.size(); i16++) {
            TVKeyMapMsg.TVMsgSceneConfig tVMsgSceneConfig = list.get(i16);
            if (tVMsgSceneConfig == null) {
                CGLog.i("keymap scene " + i16 + " is null object");
            } else {
                KeyMapSceneConfig keyMapSceneConfig = new KeyMapSceneConfig();
                keyMapSceneConfig.setId(tVMsgSceneConfig.f108163id);
                keyMapSceneConfig.setSceneName(tVMsgSceneConfig.key_scene);
                keyMapSceneConfig.setMapType(tVMsgSceneConfig.map_type);
                if (tVMsgSceneConfig.map_type == 6) {
                    i3 = tVMsgSceneConfig.key_combination_keyCode;
                    z16 = true;
                }
                keyMapSceneConfig.setTGPASceneIds(tVMsgSceneConfig.tgpa_sceneIds);
                keyMapSceneConfig.setTGPAValid(tVMsgSceneConfig.tgpa_valid);
                keyMapSceneConfig.setPrimarySceneId(tVMsgSceneConfig.tgpa_primary_index);
                if (tVMsgSceneConfig.map_type == 3) {
                    keyMapSceneConfig.setSceneTouchMapPos(tVMsgSceneConfig.touch_map_pos_x, tVMsgSceneConfig.touch_map_pos_y);
                    keyMapSceneConfig.mTouchMapSensitivityX = tVMsgSceneConfig.touch_map_sensitivity_x;
                    keyMapSceneConfig.mTouchMapSensitivityY = tVMsgSceneConfig.touch_map_sensitivity_y;
                    keyMapSceneConfig.mIsJoystickToMove = tVMsgSceneConfig.joystick_to_move_enable;
                }
                PointF pointF = keyMapSceneConfig.mSGameSkillsCancelPos;
                if (pointF != null) {
                    pointF.x = tVMsgSceneConfig.sgame_skills_cancel_pos_x;
                    pointF.y = tVMsgSceneConfig.sgame_skills_cancel_pos_y;
                }
                List<TVKeyMapMsg.TVMsgJoyKeyCancelConfig> list8 = tVMsgSceneConfig.joy_key_cancel_config;
                if (list8 != null) {
                    for (TVKeyMapMsg.TVMsgJoyKeyCancelConfig tVMsgJoyKeyCancelConfig : list8) {
                        if (keyMapSceneConfig.getJoyKeyCancelItem(tVMsgJoyKeyCancelConfig.btn_type) == null && (list7 = tVMsgJoyKeyCancelConfig.pos) != null && list7.size() >= 2) {
                            JoyKeyCancelItem joyKeyCancelItem = new JoyKeyCancelItem();
                            joyKeyCancelItem.mBtnType = tVMsgJoyKeyCancelConfig.btn_type;
                            joyKeyCancelItem.mDataType = tVMsgJoyKeyCancelConfig.data_type;
                            joyKeyCancelItem.mPos = tVMsgJoyKeyCancelConfig.pos;
                            keyMapSceneConfig.addJoyKeyItem(joyKeyCancelItem);
                        }
                    }
                }
                if (tVMsgSceneConfig.map_type == 5) {
                    List<TVKeyMapMsg.TVMsgKeyConfig4Choose> list9 = tVMsgSceneConfig.config_for_choose;
                    if (list9 != null) {
                        loadConfig4ChooseField(keyMapSceneConfig, list9);
                    } else {
                        CGLog.i("keymap scene " + i16 + " config4Choose is null object");
                    }
                } else {
                    List<TVKeyMapMsg.TVMsgKeyConfig> list10 = tVMsgSceneConfig.config;
                    if (list10 != null) {
                        loadConfigField(keyMapSceneConfig, list10);
                    } else {
                        CGLog.i("keymap scene " + i16 + " config is null object");
                    }
                    List<TVKeyMapMsg.TVMsgMoveKeyItem> list11 = tVMsgSceneConfig.move_key_items;
                    if (list11 != null) {
                        loadJoyMoveField(keyMapSceneConfig, list11);
                    } else {
                        CGLog.i("keymap scene " + i16 + " moveitems is null object");
                    }
                    int i17 = tVMsgSceneConfig.map_type;
                    if (i17 == 2 && (list6 = this.mTVControllerSceneConfigs) != null) {
                        this.mLastTVControllerSceneConfig = keyMapSceneConfig;
                        list6.add(keyMapSceneConfig);
                    } else if (i17 == 1 && (list5 = this.mGamepadSceneConfigs) != null) {
                        this.mLastGamepadSceneConfig = keyMapSceneConfig;
                        list5.add(keyMapSceneConfig);
                        this.mGamepadSceneIndex++;
                    } else if (i17 == 6 && (list4 = this.mCombinationSceneConfigs) != null) {
                        this.mLastCombinationSceneConfig = keyMapSceneConfig;
                        list4.add(keyMapSceneConfig);
                        this.mCombinationSceneIndex++;
                    } else if (i17 == 3 && (list3 = this.mMFGamepadSceneConfigs) != null) {
                        this.mLastMFGamepadSceneConfig = keyMapSceneConfig;
                        list3.add(keyMapSceneConfig);
                        this.mMFGamepadSceneIndex++;
                    } else if (i17 == 5 && (list2 = this.mChooseWindowSceneConfigs) != null) {
                        this.mLastChooseWindowSceneConfig = keyMapSceneConfig;
                        list2.add(keyMapSceneConfig);
                        this.mChooseWindowSceneIndex++;
                    }
                }
            }
        }
        if (z16) {
            KeyHandler.mKeyCombination = i3;
        } else {
            KeyHandler.mKeyCombination = -100;
        }
        return true;
    }

    public KeyMapSceneConfig getLastSceneConfig(int i3) {
        if (i3 == 2) {
            return this.mLastTVControllerSceneConfig;
        }
        if (i3 == 1) {
            return this.mLastGamepadSceneConfig;
        }
        if (i3 == 3) {
            return this.mLastMFGamepadSceneConfig;
        }
        if (i3 == 5) {
            return this.mLastChooseWindowSceneConfig;
        }
        if (i3 == 6) {
            return this.mLastCombinationSceneConfig;
        }
        return null;
    }

    public KeyMapSceneConfig getNextSceneConfig(int i3) {
        int size;
        int size2;
        int size3;
        int size4;
        List<KeyMapSceneConfig> list;
        int size5;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 5) {
                        if (i3 == 6 && (list = this.mCombinationSceneConfigs) != null && (size5 = list.size()) > 0) {
                            int i16 = (this.mCombinationSceneIndex + 1) % size5;
                            CGLog.d("COMBINATION getNextSceneConfig nextSceneIndex: " + i16);
                            KeyMapSceneConfig keyMapSceneConfig = this.mCombinationSceneConfigs.get(i16);
                            if (keyMapSceneConfig != null) {
                                this.mCombinationSceneIndex = i16;
                                return keyMapSceneConfig;
                            }
                            return keyMapSceneConfig;
                        }
                    } else {
                        List<KeyMapSceneConfig> list2 = this.mChooseWindowSceneConfigs;
                        if (list2 != null && (size4 = list2.size()) > 0) {
                            int i17 = (this.mChooseWindowSceneIndex + 1) % size4;
                            KeyMapSceneConfig keyMapSceneConfig2 = this.mChooseWindowSceneConfigs.get(i17);
                            if (keyMapSceneConfig2 != null) {
                                this.mChooseWindowSceneIndex = i17;
                                return keyMapSceneConfig2;
                            }
                            return keyMapSceneConfig2;
                        }
                    }
                } else {
                    List<KeyMapSceneConfig> list3 = this.mMFGamepadSceneConfigs;
                    if (list3 != null && (size3 = list3.size()) > 0) {
                        int i18 = (this.mMFGamepadSceneIndex + 1) % size3;
                        KeyMapSceneConfig keyMapSceneConfig3 = this.mMFGamepadSceneConfigs.get(i18);
                        if (keyMapSceneConfig3 != null) {
                            this.mMFGamepadSceneIndex = i18;
                            return keyMapSceneConfig3;
                        }
                        return keyMapSceneConfig3;
                    }
                }
            } else {
                List<KeyMapSceneConfig> list4 = this.mTVControllerSceneConfigs;
                if (list4 != null && (size2 = list4.size()) > 0) {
                    int i19 = (this.mTVControllerSceneIndex + 1) % size2;
                    KeyMapSceneConfig keyMapSceneConfig4 = this.mTVControllerSceneConfigs.get(i19);
                    if (keyMapSceneConfig4 != null) {
                        this.mTVControllerSceneIndex = i19;
                        return keyMapSceneConfig4;
                    }
                    return keyMapSceneConfig4;
                }
            }
        } else {
            List<KeyMapSceneConfig> list5 = this.mGamepadSceneConfigs;
            if (list5 != null && (size = list5.size()) > 0) {
                int i26 = (this.mGamepadSceneIndex + 1) % size;
                KeyMapSceneConfig keyMapSceneConfig5 = this.mGamepadSceneConfigs.get(i26);
                if (keyMapSceneConfig5 != null) {
                    this.mGamepadSceneIndex = i26;
                    return keyMapSceneConfig5;
                }
                return keyMapSceneConfig5;
            }
        }
        return null;
    }

    public KeyMapSceneConfig getSceneConfig(int i3, int i16) {
        List<KeyMapSceneConfig> list;
        if (i3 == 2) {
            List<KeyMapSceneConfig> list2 = this.mTVControllerSceneConfigs;
            if (list2 != null && i16 < list2.size()) {
                return this.mTVControllerSceneConfigs.get(i16);
            }
            return null;
        }
        if (i3 == 1) {
            List<KeyMapSceneConfig> list3 = this.mGamepadSceneConfigs;
            if (list3 != null && i16 < list3.size()) {
                return this.mGamepadSceneConfigs.get(i16);
            }
            return null;
        }
        if (i3 == 3) {
            List<KeyMapSceneConfig> list4 = this.mMFGamepadSceneConfigs;
            if (list4 != null && i16 < list4.size()) {
                return this.mMFGamepadSceneConfigs.get(i16);
            }
            return null;
        }
        if (i3 == 5) {
            List<KeyMapSceneConfig> list5 = this.mChooseWindowSceneConfigs;
            if (list5 != null && i16 < list5.size()) {
                return this.mChooseWindowSceneConfigs.get(i16);
            }
            return null;
        }
        if (i3 == 6 && (list = this.mCombinationSceneConfigs) != null && i16 < list.size()) {
            return this.mCombinationSceneConfigs.get(i16);
        }
        return null;
    }

    public int getSceneSize(int i3) {
        List<KeyMapSceneConfig> list;
        if (i3 == 2) {
            List<KeyMapSceneConfig> list2 = this.mTVControllerSceneConfigs;
            if (list2 != null) {
                return list2.size();
            }
            return 0;
        }
        if (i3 == 1) {
            List<KeyMapSceneConfig> list3 = this.mGamepadSceneConfigs;
            if (list3 != null) {
                return list3.size();
            }
            return 0;
        }
        if (i3 == 3) {
            List<KeyMapSceneConfig> list4 = this.mMFGamepadSceneConfigs;
            if (list4 != null) {
                return list4.size();
            }
            return 0;
        }
        if (i3 == 5) {
            List<KeyMapSceneConfig> list5 = this.mChooseWindowSceneConfigs;
            if (list5 != null) {
                return list5.size();
            }
            return 0;
        }
        if (i3 == 6 && (list = this.mCombinationSceneConfigs) != null) {
            return list.size();
        }
        return 0;
    }

    public boolean hasSceneConfig(int i3) {
        List<KeyMapSceneConfig> list;
        if (i3 == 2) {
            List<KeyMapSceneConfig> list2 = this.mTVControllerSceneConfigs;
            if (list2 != null && list2.size() > 0) {
                return true;
            }
            return false;
        }
        if (i3 == 1) {
            List<KeyMapSceneConfig> list3 = this.mGamepadSceneConfigs;
            if (list3 != null && list3.size() > 0) {
                return true;
            }
            return false;
        }
        if (i3 == 3) {
            List<KeyMapSceneConfig> list4 = this.mMFGamepadSceneConfigs;
            if (list4 != null && list4.size() > 0) {
                return true;
            }
            return false;
        }
        if (i3 == 5) {
            List<KeyMapSceneConfig> list5 = this.mChooseWindowSceneConfigs;
            if (list5 != null && list5.size() > 0) {
                return true;
            }
            return false;
        }
        if (i3 == 6 && (list = this.mCombinationSceneConfigs) != null && list.size() > 0) {
            return true;
        }
        return false;
    }

    public KeyMapSceneConfig loadMFGamepadConfig(int i3) {
        List<KeyMapSceneConfig> list = this.mMFGamepadSceneConfigs;
        if (list != null) {
            for (KeyMapSceneConfig keyMapSceneConfig : list) {
                if (keyMapSceneConfig.getId() == i3) {
                    return keyMapSceneConfig;
                }
            }
            return null;
        }
        return null;
    }

    public KeyMapSceneConfig loadSceneConfigById(int i3, int i16) {
        List<KeyMapSceneConfig> list;
        KeyMapSceneConfig keyMapSceneConfig = null;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 5) {
                        if (i3 == 6 && (list = this.mCombinationSceneConfigs) != null) {
                            for (KeyMapSceneConfig keyMapSceneConfig2 : list) {
                                if (keyMapSceneConfig2 != null && keyMapSceneConfig2.getId() == i16) {
                                    this.mCombinationSceneIndex = this.mCombinationSceneConfigs.indexOf(keyMapSceneConfig2);
                                    keyMapSceneConfig = keyMapSceneConfig2;
                                }
                            }
                        }
                    } else {
                        List<KeyMapSceneConfig> list2 = this.mChooseWindowSceneConfigs;
                        if (list2 != null) {
                            for (KeyMapSceneConfig keyMapSceneConfig3 : list2) {
                                if (keyMapSceneConfig3 != null && keyMapSceneConfig3.getId() == i16) {
                                    this.mChooseWindowSceneIndex = this.mChooseWindowSceneConfigs.indexOf(keyMapSceneConfig3);
                                    keyMapSceneConfig = keyMapSceneConfig3;
                                }
                            }
                        }
                    }
                } else {
                    List<KeyMapSceneConfig> list3 = this.mMFGamepadSceneConfigs;
                    if (list3 != null) {
                        for (KeyMapSceneConfig keyMapSceneConfig4 : list3) {
                            if (keyMapSceneConfig4 != null && keyMapSceneConfig4.getId() == i16) {
                                this.mMFGamepadSceneIndex = this.mMFGamepadSceneConfigs.indexOf(keyMapSceneConfig4);
                                keyMapSceneConfig = keyMapSceneConfig4;
                            }
                        }
                    }
                }
            } else {
                List<KeyMapSceneConfig> list4 = this.mTVControllerSceneConfigs;
                if (list4 != null) {
                    for (KeyMapSceneConfig keyMapSceneConfig5 : list4) {
                        if (keyMapSceneConfig5 != null && keyMapSceneConfig5.getId() == i16) {
                            this.mTVControllerSceneIndex = this.mTVControllerSceneConfigs.indexOf(keyMapSceneConfig5);
                            keyMapSceneConfig = keyMapSceneConfig5;
                        }
                    }
                }
            }
        } else {
            List<KeyMapSceneConfig> list5 = this.mGamepadSceneConfigs;
            if (list5 != null) {
                for (KeyMapSceneConfig keyMapSceneConfig6 : list5) {
                    if (keyMapSceneConfig6 != null && keyMapSceneConfig6.getId() == i16) {
                        this.mGamepadSceneIndex = this.mGamepadSceneConfigs.indexOf(keyMapSceneConfig6);
                        keyMapSceneConfig = keyMapSceneConfig6;
                    }
                }
            }
        }
        return keyMapSceneConfig;
    }

    public KeyMapSceneConfig loadSceneConfigByIndex(int i3, int i16) {
        List<KeyMapSceneConfig> list;
        if (i3 == 1) {
            List<KeyMapSceneConfig> list2 = this.mGamepadSceneConfigs;
            if (list2 != null && list2.size() > i16) {
                return this.mGamepadSceneConfigs.get(i16);
            }
        } else if (i3 == 3) {
            List<KeyMapSceneConfig> list3 = this.mMFGamepadSceneConfigs;
            if (list3 != null && list3.size() > i16) {
                return this.mMFGamepadSceneConfigs.get(i16);
            }
        } else if (i3 == 6 && (list = this.mCombinationSceneConfigs) != null && list.size() > i16) {
            return this.mCombinationSceneConfigs.get(i16);
        }
        return null;
    }

    public KeyMapSceneConfig loadTVControllerConfig() {
        List<KeyMapSceneConfig> list = this.mTVControllerSceneConfigs;
        if (list != null) {
            return list.get(0);
        }
        return null;
    }

    public boolean parseKeyMapMsg(TVKeyMapMsg.TVMsg tVMsg) {
        TVKeyMapMsg.TVMsgGameConfig tVMsgGameConfig;
        List<TVKeyMapMsg.TVMsgSceneConfig> list;
        if (tVMsg != null && (tVMsgGameConfig = tVMsg.data) != null) {
            GlobalConfig.getInstance().loadGlobalConfig(tVMsgGameConfig);
            if (GlobalConfig.getInstance().hasSceneConfig() && (list = tVMsgGameConfig.scene_list) != null) {
                parseSceneConfig(list);
            }
            return true;
        }
        CGLog.e("keymap config parse failed, msg=" + tVMsg);
        return false;
    }
}
